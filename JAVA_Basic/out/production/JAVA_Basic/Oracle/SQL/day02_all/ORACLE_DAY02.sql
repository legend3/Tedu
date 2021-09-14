查询语句 DQL
SELECT语句用于查询数据 

查看emp表中所有字段以及所有记录
SELECT * FROM emp

查看某几个字段的值。
SELECT ename,job,sal,deptno 
FROM emp

SELECT子句可以查看:字段，函数，表达式
查看每个员工的年薪
SELECT ename,sal*12
FROM emp

SELECT语句也可以使用WHERE子句
查看20号部门的员工信息?
SELECT ename,sal,job,deptno
FROM emp
WHERE deptno=20

SELECT ename,sal,job,deptno
FROM emp
WHERE job='CLERK'

字符串函数
CONCAT(p1,p2):拼接字符串

SELECT CONCAT(ename,sal)
FROM emp

SELECT CONCAT(CONCAT(ename,':'),sal)
FROM emp

SQL语句中可以使用"||"连接字符串
SELECT ename||':'||sal
FROM emp

LENGTH(p):获取字符串长度w
SELECT ename,LENGTH(ename)
FROM emp

LOWER,UPPER,INITCAP:小写，大写，首字母大写
伪表：dual
当查询的内容与任何一张表无关时，为了满足
FROM子句要求，可以使用伪表。伪表只会查询
出一条记录。
SELECT LOWER('HELLOWORLD'),
       UPPER('helloworld'),
       INITCAP('HELLO WORLD')
FROM dual

SELECT ename,sal,job
FROM emp
WHERE ename=UPPER('scott')

TRIM,LTRIM,RTRIM:去除字符串两边内容
SELECT TRIM('e' FROM 'eeeeliteeee')
FROM emp

SELECT LTRIM('esesesliteee','es')
FROM emp

LPAD,RPAD:补位函数
可以将指定内容显示指定位数，不足时
则补充若干个指定的单一字符以达到位数。
SELECT LPAD(sal,6,'$')
FROM emp

SUBSTR(str,m[,n])函数:截取字符串
截取str字符串从m处开始，连续截取n个,
若不指定n,则是连续截取到字符串末尾。
n若超过实际可截取的长度，也是到字符串
末尾。
需要注意:数据库中下标是从1开始的!!!

SELECT 
  SUBSTR('thinking in java',10,2)
FROM dual

INSTR(str1,str2[,n[,m]])查找位置
查找str2在str1中的位置
若指定了位置n:从n处开始查找第一次出现的位置
若指定了m:则是查找第m次出现的位置
SELECT 
  INSTR('thinking in java','in',4,2)
FROM dual

数字函数
ROUND(n[,m])
对n进行四舍五入
m时保留到小数点后多少位
若m为0或不指定，则保留到整数
若m为负数，则是保留小数点前的位数
SELECT ROUND(45.678,2),
       ROUND(45.678),
       ROUND(55.678,-2)
FROM dual

TRUNC(n[,m])
截取数字
SELECT TRUNC(45.678,2),
       TRUNC(45.678),
       TRUNC(55.678,-1)
FROM dual

MOD(n,m):求余数
若m为0，则直接返回n
SELECT MOD(13,4)
FROM dual

CEIL,FLOOR:向上取整，向下取整
SELECT 
  CEIL(45.678),FLOOR(45.678)
FROM dual

日期类型
DATE与TIMESTAMP
时间戳的前面7个字节与DATE一致，多出
的4个字节保存一个整数(int)，可以存
秒一下的精度。所以可以精确到纳秒

日期相关关键字
SYSDATE:表示一个内部函数，返回一个表示
当前系统时间的DATE类型的值。

SELECT SYSDATE FROM dual

INSERT INTO emp
(empno,ename,hiredate,sal,
 job,deptno)
VALUES
(1001,'JACK',SYSDATE,5000,
 'CLERK',20)

SELECT * FROM emp

SYSTIMESTAMP:返回时间戳类型当前系统时间
SELECT SYSTIMESTAMP FROM dual

日期类型可以比大小，越晚的越大。
日期可以进行加减运算，加上一个
数字等同于加上指定的天数，减法
同理。
两个日期间也可以相减，差为相差的
天数。

SELECT SYSDATE+1 FROM dual

查看每个员工到今天为止入职多少天了?
SELECT ename,TRUNC(SYSDATE-hiredate)
FROM emp

查看自己到今天为止活了多少天?
SELECT 
  SYSDATE-TO_DATE('1992-07-21','YYYY-MM-DD')
FROM dual

TO_DATE()函数
可以将一个字符串按照指定的日期格式转换
为DATE。
RR:两位数字表示年，会自动判定世纪。

TO_DATE('05-07-21','RR-MM-DD')

查看1982年以后入职的员工:
SELECT ename, hiredate 
FROM emp 
WHERE 
 hiredate > TO_DATE('1982-01-01',
                    'YYYY-MM-DD');

TO_CHAR():可以将日期按照指定日期格式
转换为字符串
SELECT 
 TO_CHAR(SYSDATE,
         'YYYY-MM-DD HH24:MI:SS'
         )
FROM 
 dual 

日期格式字符串中，出现的字符凡不是英文
与符号，其他字符全部要使用双引号括起来。
SELECT 
 TO_CHAR(SYSDATE,
         'YYYY"年"MM"月"DD"日"'
         )
FROM 
 dual 

SELECT
 TO_CHAR(
  TO_DATE('50-02-04','RR-MM-DD'),
  'YYYY-MM-DD'
 ) 
FROM 
 dual

LAST_DAY(date):
返回给定日期所在月的月底日期

当月月底是哪天?
SELECT LAST_DAY(SYSDATE)
FROM dual

ADD_MONTHS(date,i)
对指定日期加上指定的月

查看每个员工入职20周年的纪念日?
SELECT 
 ename,ADD_MONTHS(hiredate,12*20)
FROM emp


MONTHS_BETWEEN(date1,date2)
返回两个日期之间相差的月，计算是
根据date1-date2计算的结果。
查看每个员工距今已经入职多少个月了?
SELECT 
 ename,
 MONTHS_BETWEEN(SYSDATE,hiredate)
FROM
 emp


NEXT_DAY(date,i)
返回给定日期之后一周内的周几对应
的日期
i表示周几，1为周日，2为周一，以此类推

SELECT NEXT_DAY(SYSDATE,4)
FROM dual

LEAST、GREATEST函数
求最小值与最大值
SELECT 
  LEAST(SYSDATE, 
        TO_DATE('2008-10-10',
                'YYYY-MM-DD')
       ) 
FROM dual;

查看每个员工的入职时间，若是82年以后
入职的，则显示其入职时间，若是82年以前
入职的则显示为1982-01-01
SELECT 
 ename,
 GREATEST(
  hiredate,
  TO_DATE('1982-01-01',
          'YYYY-MM-DD'))
FROM emp

EXTRACT函数
提取一个日期中指定时间分量
对应的值。
SELECT 
  EXTRACT(YEAR FROM SYSDATE)
FROM dual;

查看1982年入职的员工?
SELECT ename,hiredate
FROM emp
WHERE 
  EXTRACT(YEAR FROM hiredate)=1982


空值操作
CREATE TABLE student
    (id NUMBER(4), name CHAR(20), gender CHAR(1));

插入NULL值:
INSERT INTO student VALUES(1000, '李莫愁', 'F');

INSERT INTO student VALUES(1001, '林平之', NULL);

INSERT INTO student(id, name) VALUES(1002, '张无忌');

SELECT * FROM student

更新NULL值
UPDATE student
SET gender=NULL
WHERE id=1000

NULL作为条件进行过滤时:
SELECT *
FROM student
WHERE gender IS NOT NULL
不可以用"="判断NULL。

NULL的运算:
NULL与字符串连接等于什么也没干。
NULL与数字运算结果还是NULL。

SELECT ename,sal,comm
FROM emp

SELECT 
 ename,sal,comm,sal+comm
FROM emp

空值函数:
NVL(p1,p2)
当p1为NULL时，函数返回p2,若
p1不为NULL，则函数返回p1自身
所以是将NULL替换为一个非NULL值
SELECT 
 ename,sal,comm,
 sal+NVL(comm,0)
FROM emp

查看每个员工奖金状态:
若有奖金的，则显示为"有奖金"
没有的则显示为"没有奖金"
NVL2(p1,p2,p3)
若p1不为NULL，则函数返回p2
若p1为NULL，则函数返回p3

SELECT 
  ename,comm,
  NVL2(comm,'有奖金','没有奖金')
FROM 
  emp

SELECT 
 ename,sal,comm,
 NVL2(comm,sal+comm,sal)
FROM
 emp



