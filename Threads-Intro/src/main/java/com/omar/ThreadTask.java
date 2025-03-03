package com.omar;

public class ThreadTask extends Thread{
    @Override
    public void run() {

        for(int i =0; i<6; i++){
            System.out.println("Thread Task printing " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
