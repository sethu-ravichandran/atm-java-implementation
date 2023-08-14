import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    static int accountBalance; //global variable

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice, inputAmount;

        do{
            System.out.println("________________________________");
            System.out.println("1 - Deposit Amount");
            System.out.println("2 - Withdraw Amount");
            System.out.println("3 - Check Balance");
            System.out.println("4 - Exit");
            System.out.println("________________________________");
            System.out.print("Enter your preferred option ... ");

            userChoice = Integer.parseInt(scanner.nextLine());

            switch (userChoice)
            {
                case 1:
                    System.out.print("Enter the amount to be deposited ... Rs.");
                    inputAmount = Integer.parseInt(scanner.nextLine());
                    depositAmount(inputAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to be withdrawn ... Rs.");
                    inputAmount = Integer.parseInt(scanner.nextLine());
                    withDrawAmount(inputAmount);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    exit(0);

                default:
                    System.out.println("________________________________");
                    System.out.println("Invalid option, please retry with a valid option");
            }
        }while (true);
    }

    static void depositAmount(int inputAmount) {
        accountBalance += inputAmount;
        checkBalance();
    }

    static void withDrawAmount(int inputAmount) {
        accountBalance -= inputAmount;
        checkBalance();
    }

    static void checkBalance() {
        System.out.println("________________________________");
        System.out.println("Your balance is Rs. " + accountBalance);
    }
}
