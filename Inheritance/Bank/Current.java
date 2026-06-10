package Inheritance.Bank;

public class Current extends Account {

    private double overdraftLimit;

    Current(String accountNumber,
            String holderName,
            double balance,
            double overdraftLimit) {

        super(accountNumber, holderName, balance);

        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void withdraw(double amount) {

        if(amount <= 0) {
            System.out.println("Invalid Withdrawal Amount");
            return;
        }

        if(amount <= getBalance() + overdraftLimit) {

            setBalance(getBalance() - amount);

            System.out.println(
                    "Withdrawal Successful");
        }
        else {
            System.out.println(
                    "Overdraft Limit Exceeded");
        }
    }
}