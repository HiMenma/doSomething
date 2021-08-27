package com.menma.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockSleep {

    public static void main(String[] args) throws InterruptedException {
        Date endTime = new Date(System.currentTimeMillis() + 10000);
        long time = endTime.getTime();
        while (true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()- 1000);
            if(time - 10000 > endTime.getTime()){break;}
        }

    }
}
