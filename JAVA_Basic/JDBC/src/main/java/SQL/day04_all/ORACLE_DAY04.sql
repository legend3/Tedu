子查询
子查询就是一条查询语句，它是嵌套
在其他SQL语句中的。目的是为实际的
SQL语句提供数据。
子查询可以应用在DQL,DDL,DML中。

查看比CLARK工资高的员工信息?
SELECT ename,sal
FROM emp
WHERE sal>(SELECT sal
           FROM emp
           WHERE ename='CLARK')
查看和CLARK相同部门的员工?
SELECT ename,deptno
FROM emp
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='CLARK')
AND ename <> 'CLARK'

查看高于公司平均工资的员工信息?
SELECT ename,sal,deptno,job
FROM emp
WHERE sal>(SELECT AVG(sal)
           FROM emp)

子查询在DDL中的应用:
可以根据查询的结果集快速创建一张表

创建一张表myemployee含有字段:
empno,ename,sal,job,deptno,dname,loc
数据来自emp与dept表。
CREATE TABLE myemployee
AS
SELECT e.empno,e.ename,e.sal,
       e.job,e.deptno,d.dname,
       d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno

DESC myemployee
SELECT * FROM myemployee

DML中使用子查询:
将CLARK所在部门所有员工的工资增加500？
UPDATE emp
SET sal=sal+500
WHERE deptno=(SELECT deptno
              FROM emp
              WHERE ename='CLARK')

SELECT * FROM emp

子查询根据查询结果不同，分为:
单行单列子查询:常用作过滤条件
多行单列子查询:常用作过滤条件
多行多列子查询:常当做表看待

查看与职位是SALESMAN同部门的其他员工?
SELECT ename,job,deptno
FROM emp
WHERE deptno IN(SELECT deptno
                FROM emp
                WHERE job='SALESMAN'
              )
AND job <> 'SALESMAN'              

查看比所有职位是CLERK和SALESMAN工资都
高的员工信息?
SELECT ename,job,sal
FROM emp
WHERE sal > ALL(SELECT sal
                FROM emp
                WHERE job IN ('CLERK','SALESMAN'))

查看部门的最低薪水，前提是该部门的最低薪水
要高于30号部门的最低薪水?
SELECT MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING MIN(sal)>(SELECT MIN(sal)
                 FROM emp
                 WHERE deptno=30)

查看高于自己所在部门平均工资的员工?
SELECT e.ename,e.sal,e.deptno
FROM emp e,(SELECT AVG(sal) avg_sal,
                   deptno
            FROM emp
            GROUP BY deptno) s
WHERE e.deptno=s.deptno
AND e.sal>s.avg_sal

SELECT ename,deptno
FROM emp
ORDER BY deptno

查看4人以上(含4人)的部门员工的
工资都是多少?
SELECT ename,sal,deptno
FROM emp
WHERE deptno IN (SELECT deptno
                 FROM emp
                 GROUP BY deptno
                 HAVING COUNT(*)>=4)

SELECT e.ename,e.sal,e.deptno
FROM emp e,(SELECT COUNT(*) p_count,
                   deptno
            FROM emp
            GROUP BY deptno) t
WHERE e.deptno=t.deptno
AND t.p_count>=4

EXISTS关键字
该关键字后面跟一个子查询，用于
在WHERE中作为过滤条件使用。
是用来判断其后的子查询是否可以
查询出数据，若可以则EXSITS返回
真，否则返回假。

查看有员工的部门?
SELECT d.deptno,d.dname,d.loc
FROM dept d
WHERE EXISTS(
  SELECT * FROM emp e
  WHERE e.deptno=d.deptno
)

子查询在SELECT子句中:
SELECT 
  e.ename, e.sal, 
 (SELECT d.dname 
  FROM dept d 
  WHERE d.deptno=e.deptno) dname
FROM emp e;

查看有下属的员工的工号，名字，职位，工资

分页查询
分页查询是分段查询数据，在查询
的数据量非常大的时候尤其重要。
分页可以减少系统资源消耗，响应
速度快。
不同的数据库分页的语法不一致。


ORACLE中使用ROWNUM解决分页。
ROWNUM是一个伪列。不存在与任何
一张表中，但是每张表都可以查询
该字段。在查询某张表时，只要可以
查询出一条记录，该字段的值就是这
条记录的行号，从1开始。生成的过程
在查询过程中进行。
SELECT ROWNUM,ename,sal,deptno
FROM emp
WHERE ROWNUM BETWEEN 6 AND 10
以上查询不出任何数据。
因为编号是在查询的过程中进行的，所以
不能用ROWNUM在编号的过程中进行>1以上的
数字的判断，否则查询不出数据。

SELECT * 
FROM(SELECT ROWNUM rn,ename,
            sal,deptno
     FROM emp) 
WHERE rn BETWEEN 6 AND 10

查看公司工资排名的第6-10名?
SELECT * 
FROM(SELECT ROWNUM rn,ename,
            sal,deptno
     FROM emp) 
WHERE rn BETWEEN 6 AND 10

若在分页中有排序需求时，一定要先排序
因为排序总是在SQL最后执行。
SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,sal,deptno
          FROM emp
          ORDER BY sal DESC) t)
WHERE rn BETWEEN 6 AND 10
计算分页公式
page:页号
pageSize:每页的条目数

start:(page-1)*pageSize+1
end:pageSize*page

SELECT *
FROM(SELECT ROWNUM rn,t.*
     FROM(SELECT ename,sal,deptno
          FROM emp
          ORDER BY sal DESC) t
     WHERE ROWNUM <=10)     
WHERE rn>=6


DECODE函数，可以实现分之结构。
SELECT ename, job, sal,
  DECODE(job,  
         'MANAGER', sal * 1.2,
         'ANALYST', sal * 1.1,
         'SALESMAN', sal * 1.05,
         sal) bonus
FROM emp;

将MANAGER与ANALYST看做一组，其他职位
员工看做另一组分别统计人数?
SELECT COUNT(*),
  DECODE(job,
         'MANAGER','VIP',
         'ANALYST','VIP',
         'OTHER'
         )
FROM emp
GROUP BY DECODE(job,
         'MANAGER','VIP',
         'ANALYST','VIP',
         'OTHER'
         )

排序函数
排序函数允许按照指定字段分组，
再按照指定字段排序，然后生成
组内编号。

ROW_NUMBER:生成组内连续且唯一的数字
查看每个部门工资排名:
SELECT 
  ename,sal,deptno,
  ROW_NUMBER() OVER(
    PARTITION BY deptno
    ORDER BY sal DESC
  ) rank
FROM emp

RANK函数:生成组内不连续也不唯一的数字
SELECT 
  ename,sal,deptno,
  RANK() OVER(
    PARTITION BY deptno
    ORDER BY sal DESC
  ) rank
FROM emp

DENSE_RANK函数:生成组内连续但不唯一的数字
SELECT 
  ename,sal,deptno,
  DENSE_RANK() OVER(
    PARTITION BY deptno
    ORDER BY sal DESC
  ) rank
FROM emp

CREATE TABLE sales_tab (
  year_id   NUMBER NOT NULL,
  month_id   NUMBER NOT NULL,
  day_id   NUMBER NOT NULL,
  sales_value NUMBER(10,2) NOT NULL
);
INSERT INTO sales_tab
SELECT TRUNC(DBMS_RANDOM.value(2010, 2012)) AS year_id,
       TRUNC(DBMS_RANDOM.value(1, 13)) AS month_id,
       TRUNC(DBMS_RANDOM.value(1, 32)) AS day_id,
       ROUND(DBMS_RANDOM.value(1, 100), 2) AS sales_value
FROM   dual
CONNECT BY level <= 1000;

SELECT * FROM sales_tab
ORDER BY year_id,month_id,day_id

查看每天的营业额?
SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id,day_id
ORDER BY year_id,month_id,day_id

查看每月营业额?
SELECT year_id,month_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id
ORDER BY year_id,month_id

每年营业额?
SELECT year_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id
ORDER BY year_id

所有营业额?
SELECT SUM(sales_value)
FROM sales_tab

查看每天，每月，每年，以及总额?
SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id,day_id
UNION ALL
SELECT year_id,month_id,NULL,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id,month_id
UNION ALL
SELECT year_id,NULL,NULL,
       SUM(sales_value)
FROM sales_tab
GROUP BY year_id
UNION ALL
SELECT NULL,NULL,NULL,
       SUM(sales_value)
FROM sales_tab

高级分组函数:
1:ROLLUP
GROUP BY ROLLUP(a,b,c)
等同于
GROUP BY a,b,c
UNION ALL
GROUP BY a,b
UNION ALL
GROUP BY a
UNION ALL
全表

SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY 
   ROLLUP(year_id,month_id,day_id)


CUBE(a,b,c)
CUBE分组方式是全方位的。
分组方式是2的参数个数次方。
a,b,c
a,b
a,c
b,c
a
b
c
全表
SELECT year_id,month_id,day_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY 
   CUBE(year_id,month_id,day_id)
ORDER BY year_id,month_id,day_id

查看每月与每年营业额?
GROUPING SETS
允许指定不同的分组方式，然后将这些分组
统计的结果并在一个结果集中。
SELECT year_id,month_id,
       SUM(sales_value)
FROM sales_tab
GROUP BY GROUPING SETS(
  (year_id,month_id),year_id
)
ORDER BY year_id,month_id





