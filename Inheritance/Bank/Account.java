package Inheritance.Bank;

public class Account {

    private String accountNumber;
    private String holderName;
    private double balance;

    Account(String accountNumber,
            String holderName,
            double balance) {

        if(balance < 0) {
            throw new IllegalArgumentException(
                    "Balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    void deposit(double amount) {

        if(amount <= 0) {
            System.out.println("Invalid Deposit Amount");
            return;
        }

        balance += amount;
        System.out.println("Deposited : " + amount);
    }

    void withdraw(double amount) {

        if(amount <= 0) {
            System.out.println("Invalid Withdrawal Amount");
            return;
        }

        if(amount > balance) {
            System.out.println("Insufficient Balance");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn : " + amount);
    }

    void display() {

        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name : " + holderName);
        System.out.println("Balance : " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}