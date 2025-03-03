package com.omar.synchronization;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void deposit(int i){
        this.balance+=i;
    }

    public void withdraw(int i){
        this.balance = this.balance - i;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
