MySQL

## 一、mysql的查询

## 二、mysql的应用

![image-20210901093112308](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901093112308.png)

![image-20210901093558228](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901093558228.png)

## 三、msyql的详解

### 1.mysql的体系结构

![image-20210901143049337](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901143049337.png)

### 2.索引

index（）

unique index（）

primary key（）

index(a,b)  最左原则

fulltext index（）

1.普通索引
2.唯一索引
3.主键索引
4.组合索引
5.全文索引

### 3.B+树

![image-20210901143142472](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901143142472.png)

#### 	3.1本质

![image-20210901100024723](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901100024723.png)

**聚集索引**：（叶子存储的是具体的行数据）把主键对应的B+树索引出来的，查找的行数据在叶子节点中。

​	对于Innodb，主键毫无疑问是一个聚集索引。但是当一个表没有主键，或者没有一个索引，Innodb会如何处理呢。请看如下规则:

- 如果一个主键被定义了，那么这个主键就是作为聚集索引。
- 如果没有主键被定义，那么该表的第一个唯一非空索引被作为聚集索引。
- 如果没有主键也没有合适的唯一索引，那么innodb内部会生成一个隐藏的主键作为聚集索引，这个隐藏的主键是一个6个字节的列(_rowid)，该列的值会随着数据的插入自增。

**辅助索引**：（叶子存储的是索引 + 主键key）先通过辅助索引找到主键，再通过主键进行回表查询行数据。

![image-20210901100630030](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901100630030.png)

### 4.事务

![image-20210901102752481](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901102752481.png)

- 事务：用来解决并发执行的问题；InnoDB有行级锁。

#### 4.1ACID

![image-20210901104439156](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901104439156.png)

-  一致性 由前三个共同维护

#### 4.2事务的隔离级别

![image-20210901104618157](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901104618157.png)

1. 读未提交：可能会 读到 其他连接（线程）还没有提交的数据  ；     不加锁 （脏读）

2. 读已提交： 可能会  读到 其他连接（线程）已经提交（最新）的数据；     不加锁 MVCC(不可重复读)

3. 可重复读：可以 读取开始之前的数据，但是插入、更新时会出错；  不加锁 MVCC（幻读）

4. 可串行化：加了锁，所有事务都时串行化的执行，隔离级别最高。

   ![image-20210901114944219](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901114944219.png)

**MVCC**

![image-20210901110821840](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901110821840.png)

#### 4.3死锁

![image-20210901115355226](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901115355226.png)

