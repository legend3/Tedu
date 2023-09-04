SELECT CONCAT(CONCAT(ename,':'),sal),sal*12
FROM emp

当一个SELECT子句中查询的内容是一个
函数或者表达式，那么在结果集对应的该
字段的字段名就是这个函数或表达式，可
读性差。为此应当为该列添加别名。
别名不区分大小写，若希望区分大小写，或
在别命中含有空格，可以使用双引号括起来。
SELECT ename,sal*12 "sal"
FROM emp

SELECT ename, sal, job 
FROM emp 
WHERE sal > 1000 
AND job = 'CLERK';

查看工资高于1000的CLERK与SALESMAN?
SELECT ename, sal, job 
FROM emp
WHERE sal>1000
AND (job='SALESMAN'
OR job='CLERK')
AND的优先级高于OR，所以可以通过添加
括号来提高OR的优先级


LIKE用于模糊匹配字符串。
两个通配符:
%:0到多个字符
_:一个字符

查看名字第二个字符是A的员工
SELECT ename,job,sal
FROM emp
WHERE ename LIKE '_A%'


IN(list),NOT IN(list)
判断在列表中和不在列表中
IN与NOT IN常用于子查询中。
SELECT ename,job,sal
FROM emp
WHERE job IN ('MANAGER','CLERK')

ANY,ALL
用于判断诸如>,>=,<,<=一个列表中
的内容。
>ALL(list):大于列表中所有的(大于最大的)
>ANY(list):大于列表中之一即可(大于最小的)
SELECT empno, ename, job, 
       sal, deptno
FROM emp
WHERE sal > ANY (3500,4000,4500);

ANY和ALL的列表通常不会给确定值，这样
没有意义，通常使用在判断一个子查询的结
果。

可以使用函数或者表达式的结果作为过滤条件
SELECT ename, sal, job 
FROM emp 
WHERE ename = UPPER('scott');

SELECT ename, sal, job 
FROM emp 
WHERE sal * 12 >50000;


DISTINCT关键字
去除后面指定字段的重复行。
DISTINCT必须紧跟在SELECT关键
字之后！
查看公司总共有多少种职位？
SELECT DISTINCT job
FROM emp

DISTINCT后面可以跟多个字段:
这些字段值的组合没有重复的。
SELECT DISTINCT job,deptno
FROM emp

排序
ORDER BY子句，可以根据后面指定
的字段对结果集进行升序或者降序排
列。其中ASC是升序，DESC是降序。
通常ASC可以不写，不写默认就是升序。
ORDER BY子句只能写在SELECT语句中的
最后一个子句上。
查看公司工资的排名:
SELECT ename,sal
FROM emp
ORDER BY sal DESC

ORDER BY可以按照多个字段排序，
排序是有优先级的，首先按照第一个
字段的排序规则排序，当第一个字段
有重复值时，才按照第二个字段排序。
SELECT ename,deptno,sal
FROM emp
ORDER BY deptno,sal DESC

聚合函数
聚合函数又称为多行函数，分组函数。
聚合函数可以将条记录进行统计，然后
得出一个结果。所以聚合函数是用来
统计使用的。

MAX(),MIN()
用来统计最大值与最小值

查看公司的最高工资是多少?
SELECT MAX(sal),MIN(sal)
FROM emp

AVG(),SUM()
求平均值与总和
SELECT AVG(sal),SUM(sal)
FROM emp

COUNT()
统计记录总数
SELECT COUNT(ename)
FROM emp

聚合函数忽略NULL值。
SELECT AVG(comm),SUM(comm)
FROM emp

SELECT AVG(NVL(comm,0))
FROM emp

统计表中总数据量:
SELECT COUNT(*)
FROM emp

查看SALESMAN和CLERK员工的
名字，职位，部门
然后按照入职时间从早到晚排序

SELECT ename,job,deptno
FROM emp
WHERE job IN ('SALESMAN','CLERK')
ORDER BY hiredate

查看82年以前入职的职位是MANAGER并且
公司高于2500的员工的名字，职位，工资
以及所在部门?
SELECT ename,job,sal
FROM emp
WHERE job='MANAGER'
AND sal>2500
AND hiredate<TO_DATE('1982-01-01','YYYY-MM-DD')


SELECT ename,sal,deptno
FROM emp
ORDER BY deptno,sal DESC

分组
GROUP BY子句
GROUP BY可以将结果集按照指定的
字段值相同的记录看做一组，配合
聚合函数使用可以对不同分组的记录
分别进行统计然后得到结果。

查看每个部门最高工资与最低工资?
SELECT MAX(sal),MIN(sal),deptno
FROM emp
GROUP BY deptno

在SELECT当中若使用了聚合函数，那么
不在聚合函数中的其他单独字段必须出现
在GROUP BY子句中。反过来不是必须的。

SELECT AVG(sal),SUM(sal),job
FROM emp
GROUP BY job

GROUP BY也可以按照多个字段进行分组。
分组原则是这些字段值的组合相同的看做
一组。
查看每个部门每种职位的平均工资?
SELECT AVG(sal),deptno,job
FROM emp
GROUP BY deptno,job
    
查看部门的平均工资，前提是
该部门平均工资高于2000？
SELECT AVG(sal),deptno
FROM emp
WHERE AVG(sal)>2000
GROUP BY deptno
执行上述SQL会出现:
此处不允许使用分组函数
的错误，原因在于AVG(sal)>2000
不应当定义在WHERE中。过滤的时机
不对。

WHERE的过滤时机:WHERE是在查询表
中每一条数据时进行过滤的，只会将
满足WHERE条件的记录查询出来。

HAVING子句:
HAVING子句必须紧跟在GROUP BY
子句之后，作用是添加条件来过滤
不同的分组。
HAVING可以使用聚合函数作为过滤
条件。

SELECT AVG(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

查看部门平均工资高于2000的这些部门的
最高工资和最低工资?
SELECT MAX(sal),MIN(sal),deptno
FROM emp
GROUP BY deptno
HAVING AVG(sal)>2000

查看最高工资>=3000的职位的平均工资?



关联查询
关联查询是建立在多张表上进行
联合查询。
查询的结果集中每一条记录中的
字段可能来自于不同表。
重点是:找到表与表的记录之间的
对应关系。

查看每个员工的信息以及其所在部门的信息?
SELECT e.ename,e.job,e.sal,
       e.deptno,d.dname,d.loc
FROM emp e,dept d
WHERE e.deptno=d.deptno

上述SQL中:e.deptno=d.deptno
条件是用来联系emo,dept的数据关系
的，这样的条件称为:连接条件。

在关联查询中，必须要添加连接条件，
N张表关联查询至少要添加N-1个连接
条件。不添加连接条件会产生笛卡尔积。
SELECT e.ename,d.dname
FROM emp e,dept d
实际开发中要避免笛卡尔积的出现。
这是一个无意义的结果集。

在关联查询中，连接条件应当与
过滤条件同时成立.
查看SALES部门的员工?
SELECT e.ename,e.job,e.sal,
       e.deptno,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno
AND d.dname='SALES'

内连接
内连接是关联查询的另一种写法
SELECT e.ename,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno

SELECT e.ename,d.dname
FROM emp e JOIN dept d
ON e.deptno=d.deptno
WHERE d.dname='SALES'

查看每个员工以及所在部门信息:
SELECT e.ename,e.sal,
       d.dname,d.loc
FROM emp e JOIN dept d
ON e.deptno=d.deptno
SCOTT没有被查询出来，原因是他的部门
号是50，不满足连接条件。
若想将不满足连接条件的记录也列出来，
需要使用外连接。
外连接分为:
左外连接:以JOIN左侧的表为驱动表，该表
        所有记录都要显示出来，那么当
        某条记录不满足连接条件时，那么
        来自JOIN右侧表中的字段的值全部
        显示为NULL。
右外连接:
全外连接:
SELECT e.ename,e.sal,
       d.dname,d.loc
FROM 
  emp e 
  LEFT|RIGHT|FULL OUTER JOIN 
  dept d
ON e.deptno=d.deptno

关联查询也可以实现外连接效果
(+)定义在连接条件上，定义在哪边
哪边就补NULL。
但是不能实现全外连接效果。
SELECT e.ename,d.dname
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno

自连接
当前表的一条记录对应当前表自己的
多条记录，这种设计就是自连接。
自连接是用来解决数据内容相同，但是
数据间又存在上下级关系的树状结构的
情况。

查看每个员工以及其上司的名字
SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno







