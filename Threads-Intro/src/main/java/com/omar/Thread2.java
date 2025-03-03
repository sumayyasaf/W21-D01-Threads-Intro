package com.omar;

public class Thread2 extends Thread{
    @Override
    public void run() {
        Thread.currentThread().setName("Third Thread");
        System.out.println("This is the third thread");
    }
}
