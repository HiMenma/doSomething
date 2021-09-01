# JAVA动态代理  和 两个模式

![image-20210901121950555](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901121950555.png)

先定义一个接口 （Girl）

再定义一个真实角色 （王美丽）类实现这个接口      （Girl）

再定义一个代理类（王美丽Proxy）也实现这个  （InvocationHandler）接口

并重写invoke方法（内有反射机制）；然后加上自定义 前置 和 后置增强。调用method.invoke方法。

![image-20210901123209110](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901123209110.png)

- 再写个方法getProxyInstance返回Proxy的静态方法newProxyInstance
- 最后在main方法中：
- 实例化一个接口对象
- 再将这个对象当作参数放到代理类中 得到一个新对象
- 这个对象再调用getProxyInstance方法 得到一个接口新的接口对象
- 这个对象再调用方法。

![image-20210901123752614](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901123752614.png)







CGLIB

实现；MethodInterceptor接口

![image-20210901125827328](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901125827328.png)

调用：

![image-20210901130007635](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901130007635.png)





# 简单的工厂模式：

通过不同参数，返回不同的实例

![image-20210901130919180](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901130919180.png)



# 单例模式

## 饿汉式

![image-20210901131311736](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901131311736.png)

这个唯一实例在开始加载的时候就实例化了

## 懒汉式

![image-20210901131755064](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901131755064.png)





![image-20210901132344566](C:\Users\Menma\AppData\Roaming\Typora\typora-user-images\image-20210901132344566.png)

