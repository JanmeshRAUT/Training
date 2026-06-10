package Inheritance.Bank;

public class SavingAccount extends Account {

    private double interestRate;

    SavingAccount(String accountNumber,
                  String holderName,
                  double balance,
                  double interestRate) {

        super(accountNumber, holderName, balance);

        if(interestRate < 0) {
            throw new IllegalArgumentException(
                    "Interest Rate Cannot Be Negative");
        }

        this.interestRate = interestRate;
    }

    void calculateInterest() {

        double interest =
                getBalance() * interestRate / 100;

        System.out.println("Interest = " + interest);
    }
}