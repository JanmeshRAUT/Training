package Inheritance.Bank;

public class App {

    public static void main(String[] args) {

        Account arr[] = {

                new SavingAccount(
                        "S101",
                        "Janmesh",
                        10000,
                        5),

                new Current(
                        "C101",
                        "Anish",
                        5000,
                        2000),

                new SavingAccount(
                        "S102",
                        "Prajwal",
                        15000,
                        4),

                new Current(
                        "C102",
                        "Samarth",
                        7000,
                        3000)
        };

        Operation op = new Operation();

        op.findTotalBalance(arr);
        op.maximumBalance(arr);
        op.minimumBalance(arr);
        op.totalSaving(arr);
        op.totalCurrent(arr);

        System.out.println();

        arr[0].deposit(1000);

        arr[1].withdraw(6000);

        ((SavingAccount)arr[0])
                .calculateInterest();
    }
}