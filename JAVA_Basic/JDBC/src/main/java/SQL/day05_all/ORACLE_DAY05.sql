视图
视图是数据库对象之一
数据库对象有:表，视图，索引，序列

视图在SQL中体现的角色与表相同，但是
并非真实的表，它不包含任何数据。它只
对应一个查询语句的结果集。
所以查询一张视图时，会先执行该视图对应
的查询语句，得到结果集，然后在根据这个
结果集进行实际的查询工作。

CREATE VIEW v_emp_dept10
AS
SELECT empno, ename, sal*12, deptno 
FROM emp 
WHERE deptno = 10;

SELECT *
FROM v_emp_dept10

DESC v_emp_dept10

创建视图为字段起别名
CREATE OR REPLACE VIEW v_emp_dept10
AS
SELECT empno id,ename name , 
       sal salary,deptno 
FROM emp 
WHERE deptno = 10;

SELECT * FROM v_emp_dept10
DESC v_emp_dept10
当视图对应的查询语句中字段含有
函数或者表达式时，该字段必须给别名。

对视图进行DML操作
仅能对简单视图进行DML操作，
复杂视图不允许进行DML操作。
简单视图:视图数据来自单一的一张表
        且不含有函数或表达式。
复杂视图:查询语句含有函数，表达式，
        分组等。
连接视图:视图数据来自多张表。算作
        复杂视图的一种。

对简单视图进行DML虽然可以，但是
也要注意不能违反基表的约束条件。
基表:视图数据来源的表。
对视图进行DML操作就是对基表进行
DML操作。

INSERT INTO v_emp_dept10
(id,name,salary,deptno)
VALUES
(1001,'JACK',5000,10)

SELECT * FROM v_emp_dept10
SELECT * FROM emp

UPDATE v_emp_dept10
SET salary=9000
WHERE id=1001

对视图进行某些DML操作，可能
导致视图自身对该记录不可见，但是
依然能影响基表记录，这种操作是对
基表的"污染"
INSERT INTO v_emp_dept10
(id,name,salary,deptno)
VALUES
(1002,'ROSE',5000,20)

UPDATE v_emp_dept10
SET deptno=20

DELETE不会出现该问题。
由于删除不掉视图数据，所以也不会对
基表数据删除。
DELETE FROM v_emp_dept10
WHERE deptno=20

对视图添加检查选项，来避免对基表
污染。添加了检查选项的视图要求对
视图进行DML操作后视图必须对其可控。
INSERT后视图必须可见，UPDATE后
视图也必须对其可见。DELETE没有该问题
CREATE OR REPLACE VIEW v_emp_dept10
AS
SELECT empno id,ename name , 
       sal salary,deptno 
FROM emp 
WHERE deptno = 10
WITH CHECK OPTION

对视图添加只读选项，添加后，该视图不能
进行DML操作。
CREATE OR REPLACE VIEW v_emp_dept10
AS
SELECT empno id,ename name , 
       sal salary,deptno 
FROM emp 
WHERE deptno = 10
WITH READ ONLY

数据字典
数据字典也是一系列的表，这些表中的
数据有数据库自身维护。是用来记录用户
曾经创建过的数据库对象的清单。
当需要了解时，可以查看这些数据字典。

user_objects:记录了所有数据库对象

查看所有创建过的视图:
SELECT object_name, object_type
FROM user_objects 
WHERE object_type = 'VIEW'
--WHERE object_tpye = 'TABLE'

记录用户创建的所有表的数据字典
SELECT table_name
FROM user_tables

记录用户创建的所有视图的数据字典
SELECT view_name,text
FROM user_views

创建复杂视图
创建一个部门工资情况的视图
CREATE VIEW v_salinfo
AS
SELECT AVG(e.sal) avg_sal,
       SUM(e.sal) sum_sal,
       MAX(e.sal) max_sal,
       MIN(e.sal) min_sal,
       e.deptno,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno
GROUP BY e.deptno,d.dname

查看比自己所在部门平均工资高?
SELECT * FROM v_salinfo

SELECT e.ename,e.sal,e.deptno
FROM emp e,v_salinfo v
WHERE e.deptno=v.deptno
AND e.sal>v.avg_sal

删除视图
DROP VIEW v_emp_dept10

删除视图并不会对基表有任何影响。


序列
另一个数据库对象
用来生成一系列数字的。
通常序列生成的数字是为某张表的
主键字段(id)提供值的
CREATE SEQUENCE seq_emp_empno
START WITH 1000
INCREMENT BY 10

序列支持两个伪列:
NEXTVAL:使序列生成下一个数字，新创建
        的序列第一次生成是START WITH
        指定的数字，以后就是上次生成的
        数字加上步长得到的。序列不能后退，
        所以生成新数字后就不能得到以前的
        数字了。
CURRVAL:返回序列最后生成的数字。
        新创建的序列至少调用一次NEXTVAL
        以后才可以使用CURRVAL。

SELECT seq_emp_empno.NEXTVAL
FROM dual
SELECT seq_emp_empno.CURRVAL
FROM dual

INSERT INTO emp
(empno,ename,job,sal,deptno)
VALUES
(seq_emp_empno.NEXTVAL,'rose',
 'CLERK',1000,10)

SELECT * FROM emp

删除序列
DROP SEQUENCE seq_emp_empno


NOT NULL 非空约束
非空约束也是列级约束，只能
在修改表中某个字段的同时修改
该约束。

唯一性约束
UNIQUE:唯一性约束可以保证指定字段
的值在整张表中没有重复的，NULL除外。
CREATE TABLE employees1 (
eid NUMBER(6) UNIQUE,
name VARCHAR2(30),
email VARCHAR2(50),
salary NUMBER(7, 2),
hiredate DATE,
CONSTRAINT employees_email_uk UNIQUE(email)
 );
INSERT INTO employees1
(eid,name,email,salary)
VALUES
(NULL,'ROSE',NULL,5000)

SELECT * FROM employees1


主键约束
每张表通常都要有主键(id),
该字段的值在整张表中是非空且
唯一的。这样才能用主键的值唯一
确定表中的一条数据。
CREATE TABLE employees2 (
eid NUMBER(6) PRIMARY KEY,
name VARCHAR2(30),
email VARCHAR2(50),
salary NUMBER(7, 2),
hiredate DATE
);
INSERT INTO employees2
(eid,name)
VALUES
(1,'JACK')









