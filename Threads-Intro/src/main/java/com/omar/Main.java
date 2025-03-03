package com.omar;

public class Main {

//    3 ways of creating a new thread in Java
//    extending the Threads class
//    implementing the runnable interface
//    inline using lambda expressions
    public static void main(String[] args) throws InterruptedException {
//        inside of the consutrctor for the Thread() we will pass the class which implements the runnable interface
//     1. Runnable Interface
       Thread one = new Thread(new Thread1());
//     2. extending Thread class
       Thread second = new Thread2();

//     3. inline lambda expression
        Thread three = new Thread(()->{
            System.out.println("This is the fourth thread running in my program");
        });
        System.out.println(one.getState());

//        starting thread using thread.start()
//        one.start();
//        second.start();
//        three.start();

//        System.out.println(Thread.currentThread().getName());

//        System.out.println("after for loop");


        Thread runnableTask = new Thread(new RunnableTask());
        Thread threadTask = new ThreadTask();
        Thread lambdaTask = new Thread(()->{
                for(int i =0; i<6; i++){
                    System.out.println("lambda Task printing " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

        });

        runnableTask.start();
        threadTask.start();
        lambdaTask.start();

//        main thread will wait for these threads to finish before continuing execution
        runnableTask.join();
        threadTask.join();
        lambdaTask.join();


        System.out.println("After Printing other threads");

    }
}