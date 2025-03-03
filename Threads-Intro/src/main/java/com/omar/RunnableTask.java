package com.omar;

public class RunnableTask implements Runnable{
    @Override
    public void run() {

        for(int i =0; i<6; i++){
            System.out.println("Runnable Task printing " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
