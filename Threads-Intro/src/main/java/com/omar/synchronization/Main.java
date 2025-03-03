package com.omar.synchronization;

public class Main {
    static BankAccount bankAccount = new BankAccount(1000);


    public synchronized static void increment(){
        bankAccount.deposit(1);
    }

    public synchronized static void decrement(){
        bankAccount.withdraw(1);
    }

    public static void main(String[] args) {



        Thread depositThread = new Thread(()->{
            for(int i =0; i<10000; i++){
                increment();
            }
        });

        Thread withdrawThread = new Thread(()->{
            for(int i =0; i<10000; i++){
                decrement();
            }
        });

        depositThread.start();
        withdrawThread.start();


        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        System.out.println(bankAccount.getBalance());





    }
}
