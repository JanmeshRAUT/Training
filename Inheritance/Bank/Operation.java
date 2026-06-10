package Inheritance.Bank;

public class Operation {

    void findTotalBalance(Account arr[]) {

        double total = 0;

        for(Account acc : arr) {
            total += acc.getBalance();
        }

        System.out.println(
                "Total Balance = " + total);
    }

    void maximumBalance(Account arr[]) {

        Account max = arr[0];

        for(Account acc : arr) {

            if(acc.getBalance() >
                    max.getBalance()) {

                max = acc;
            }
        }

        System.out.println(
                "Maximum Balance = "
                        + max.getBalance());
    }

    void minimumBalance(Account arr[]) {

        Account min = arr[0];

        for(Account acc : arr) {

            if(acc.getBalance() <
                    min.getBalance()) {

                min = acc;
            }
        }

        System.out.println(
                "Minimum Balance = "
                        + min.getBalance());
    }

    void totalSaving(Account arr[]) {

        int count = 0;

        for(Account acc : arr) {

            if(acc instanceof SavingAccount) {
                count++;
            }
        }

        System.out.println(
                "Total Saving Accounts = "
                        + count);
    }

    void totalCurrent(Account arr[]) {

        int count = 0;

        for(Account acc : arr) {

            if(acc instanceof Current) {
                count++;
            }
        }

        System.out.println(
                "Total Current Accounts = "
                        + count);
    }
}