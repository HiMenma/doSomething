JAVA多线程

1.继承Thread类，重写run方法，创建子类对象，在调用start。

2.实现Runnable接口，重写run方法，创建Thread对象讲子类对象丢进去，再调用start。

3.实现Callable<>接口并throws异常。

4.静态代理

5.lambda表达式

6.每个线程对应一个 工作空间 ， 工作空间 再与 主内存 进行拷贝等操作

7.进入就绪状态：start、解除阻塞、yield：礼让，让线程重新进入就绪状态、jvm算法调度

8.进入阻塞状态：sleep：抱着资源睡觉；wait：不占资源等待；jion：阻塞当前线程，让使用jion的线程先执行完。

9.线程生命周期：new 、runnable、terminated

10.优先级：不代表绝对的先后顺序，而是时间片轮转的概率

```java
t.setPriority(Thread.MAX_PRIORITY);  //-->10
t.setPriority(Thread.MIN_PRIORITY);	 //-->1
t.setPriority(Thread.NORM_PRIORITY);  //-->5
```

11.守护线程：JVM需要等待用户线程结束之后才能结束，但不需要等待守护线程结束就可以结束

```java
t.setDaemon(true);  //设置成守护线程
```

12.多线程的其他方法：

```java
t.setName("11");  //设置代理名称
t.getName();    //获取代理名称
t.isAlive();    //判断线程是否结束
Thread.currentThread(); //表示当前线程
```

13.并发：队列＋锁。 锁的目标要对，效率要尽可能提高。

```java
synchronized void test（）{} //锁方法，范围更大，不一定锁得住
synchronized（object）{} //锁同步块 
```

14.避免死锁：不要在同一个代码块中，同时持有多个对象的锁。