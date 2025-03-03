package com.omar.synchronization;

public class IssueWithSynchronizedMethodSigniture {
    public static int counter1 = 0;
    public static int counter2 = 0;

    public final static Object lock1 = new Object();
    public final static Object lock2 = new Object();

    public static void incrementCounter1(){
        synchronized (lock1){
            counter1++;
        }
    }

    public static void decremenet1(){
        synchronized (lock1){
            counter1--;
        }
    }

    public static void incrementCounter2(){
        synchronized (lock2){
            counter2++;
        }
    }

    public static void decrementCounter2(){
        synchronized (lock2){
            counter2--;
        }
    }

    public static void main(String[] args) {
        Thread one = new Thread(()->{
            for(int i =0; i<10000000; i++){
                incrementCounter1();
            }
        });

        Thread two = new Thread(()->{
            for(int i =0; i<10000000; i++){
                incrementCounter2();
            }
        });

        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter 1: " + counter1);
        System.out.println("Counter 2: " + counter2);

    }
}
