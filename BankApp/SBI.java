public class SBI {

    String name;
    String AccountNo;
    int Balance;

    SBI() {
        name = "Unknown";
        AccountNo = "SBI000000";
        Balance = 0;
    }

    SBI(String AccName, String AccNo, int Bal) {
        name = AccName;
        AccountNo = AccNo;
        Balance = Bal;
    }

    void Deposite(int Amount) {
        Balance += Amount;
        System.out.println("₹" + Amount + " deposited into account.");
        System.out.println("Current Balance: " + Balance);
    }

    void Withdraw(int Amount) {
        if (Amount > Balance) {
            System.out.println("Insufficient Balance");
        } else {
            Balance -= Amount;
            System.out.println("₹" + Amount + " withdrawn from account.");
            System.out.println("Current Balance: " + Balance);
        }
    }

    void CheckBalance() {
        System.out.println("Current Balance: " + Balance);
    }

    void CheckAcount() {
        if (AccountNo.contains("COR")) {
            System.out.println("Current Account");
        } else if (AccountNo.contains("BUIS")) {
            System.out.println("Business Account");
        } else {
            System.out.println("Saving Account");
        }
    }
}