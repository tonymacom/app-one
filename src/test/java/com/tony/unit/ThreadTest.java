package com.tony.unit;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/3/11
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class ThreadTest {

//    public final static Object lock = new Object();


    public static void main(String[] args) {
         ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(()->{

            while (true) {
                try {
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println("thread 1 finish");
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });

        Thread thread2 = new Thread(()->{

            while (true) {
                try {
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println("thread 2 finish");
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();


    }

}
