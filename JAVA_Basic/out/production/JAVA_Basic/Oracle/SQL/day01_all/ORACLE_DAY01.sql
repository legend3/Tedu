SELECT SYSDATE FROM dual
--创建表
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1),
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

-- 查看表结构
DESC employee;

-- 在数据库中，所有类型的默认值都是NULL。
-- 即:当插入数据时，若某个字段没有指定值时，
-- 默认就将NULL作为值插入。
-- 可以在创建表的时候通过使用DEFAULT关键字
-- 来单独指定默认值。

-- 字符串的字面量是使用单引号括起来的，这一点
-- 与java不同。
--删除表
DROP TABLE employee

CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20),
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

-- NOT NULL约束
-- 当一个字段使用NOT NULL约束后，该字段在
-- 任何情况下值不允许为空。
DROP TABLE employee
CREATE TABLE employee(
	id NUMBER(4),
	name VARCHAR2(20) NOT NULL,
	gender CHAR(1) DEFAULT 'M',
	birth DATE,
  salary NUMBER(6,2),
  job VARCHAR2(30),
  deptno NUMBER(2)
);

-- 修改表
-- 1:修改表名
-- RENAME old_name TO new_name
-- 将employee表改名为myemp
-- RENAME employee TO myemp
--
--
-- 2:修改表结构
-- 2.1:添加列
-- 为myemp表添加一列hiredate
ALTER TABLE myemp ADD(
  hiredate DATE DEFAULT SYSDATE
)

-- 2.2:删除现有列
-- 删除myemp表中的hiredate列
ALTER TABLE myemp DROP(hiredate)


-- 2.3:修改现有列
-- 可以修改列的类型，长度，以及默认值或非空
-- 当表中存在数据后，尽量不修改字段类型，若
-- 修改长度尽量不要减小，否则可能修改失败
ALTER TABLE myemp MODIFY(
  job VARCHAR2(40) DEFAULT 'CLERK'
)



-- DML语句
-- DML可以对表中的数据进行操作，
-- 分为INSERT,UPDATE,DELETE
-- DMS是伴随事务使用的。
INSERT INTO myemp
(id,name,salary,job)
VALUES
(1,'jack',5000,'CLERK')

SELECT * FROM myemp

-- 插入数据时可以不指定具体列，若这样
-- 做则是全列插入
INSERT INTO myemp
VALUES
(1,'JACK',5000,'CLERK',...)--所有列都要给值

SELECT * FROM myemp

-- 插入一个日期的值
INSERT INTO myemp
(id,name,birth)
VALUES
(2,'rose',TO_DATE('2008-08-08',
                  'YYYY-MM-DD')
)

-- UPDATE语句
-- 修改表中现有数据
UPDATE myemp
SET gender='F',salary=6000
WHERE name='jack'

-- 删除数据
-- DELETE语句
-- 通常应当使用WHERE添加条件，否则
-- 是清空表的操作。
DELETE FROM myemp
WHERE name='jack'



















