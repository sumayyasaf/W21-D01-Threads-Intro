package com.omar;


public class Thread1 implements Runnable{
//    run(): is what the thread will perform once called upon
    @Override
    public void run() {
        Thread.currentThread().setName("SecondThread");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i =0; i<100;i++){
            System.out.println(Thread.currentThread().getName() + " printing " + i);
        }
    }
}
