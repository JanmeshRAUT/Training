import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Name:");
        String name = sc.next();

        System.out.println("Enter Your Account Number:");
        String accNo = sc.next();

        SBI s1 = new SBI(name, accNo, 500000);

        int option = 0;

        while (option != 5) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Check Account Type");
            System.out.println("5. Exit");
            System.out.print("Enter Option: ");

            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.print("Enter Amount To Deposit: ");
                    int amount = sc.nextInt();
                    s1.Deposite(amount);
                    break;

                case 2:
                    System.out.print("Enter Amount To Withdraw: ");
                    int amount1 = sc.nextInt();
                    s1.Withdraw(amount1);
                    break;

                case 3:
                    s1.CheckBalance();
                    break;

                case 4:
                    s1.CheckAcount();
                    break;

                case 5:
                    System.out.println("Thank You For Using Our Service");
                    break;

                default:
                    System.out.println("Invalid Option");
            }
        }

        sc.close();
    }
}