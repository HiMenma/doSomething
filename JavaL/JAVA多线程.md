JAVA多线程

1.继承Thread类，重写run方法，创建子类对象，在调用start。

2.实现Runnable接口，重写run方法，创建Thread对象讲子类对象丢进去，再调用start。

3.实现Callable<>接口并throws异常。