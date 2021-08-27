package com.menma.thread;

public class StaticProxy {
    //静态代理举例
    public static void main(String[] args) {
        new WeddingCom(new Me()).happyMarry();

//        new Thread(new Me()).start();  这种感觉
    }
}

interface Marry{
    void happyMarry();
}

//真实角色
class Me implements Marry{    //相当于实现Runnable
    @Override
    public void happyMarry() {
        System.out.println("我要结婚啦~~");
    }
}

//代理角色
class WeddingCom implements Marry{  //相当于Thread
    //真实角色
    private Marry target;
    //构造
    public WeddingCom(Marry target) {
        this.target = target;
    }
    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        done();
    }

    private void ready(){
        System.out.println("结婚准备ing。。。");
    }

    private void done(){
        System.out.println("结婚结束。。。");
    }
}
