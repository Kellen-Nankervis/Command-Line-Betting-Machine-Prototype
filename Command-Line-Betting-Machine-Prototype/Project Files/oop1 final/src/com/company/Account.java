package com.company;

/**
 * <h1>Account</h1>
 * <p>This is the class for the Account object that stores information on the users Account</p>
 *
 * <p>Created: 8/28/2021</p>
 *
 * @author Kellen Nankervis
 */

public class Account {
    private double balance;
    private double gameBalance;

    /**
     * Name: Account
     * This Method is used to create the Account object.
     * @param balance (double; the amount of money in the users account.)
     */

    Account(double balance){
        this.balance = balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setGameBalance(double gameBalance) {
        this.gameBalance = gameBalance;
    }

    public double getGameBalance() {
        return gameBalance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void gameWithdraw(double amount) {
        gameBalance -= amount;
    }

    public void gameDeposit(double amount) {
        gameBalance += amount;
    }
}
