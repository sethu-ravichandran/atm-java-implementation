import java.util.Scanner;

import static java.lang.System.exit;

class ATM
{
    private int accountBalance;

    public int getAccountBalance() {
        return accountBalance;
    }

    public void addMoney(int amountToBeDeposited)
    {
        accountBalance += amountToBeDeposited;
    }

    public void takeMoney(int amountToBeWithDrawn)
    {
        accountBalance -= amountToBeWithDrawn;
    }
}

class IndianBankATM extends ATM{
    void depositAmount(int inputAmount) {
        addMoney(inputAmount);
        checkBalance();
    }

    void withDrawAmount(int inputAmount) {
        takeMoney(inputAmount);
        checkBalance();
    }

    void checkBalance() {
        System.out.println("________________________________");
        System.out.println("Your balance is Rs. " + getAccountBalance());
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        IndianBankATM guindyATM = new IndianBankATM();

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
                    guindyATM.depositAmount(inputAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to be withdrawn ... Rs.");
                    inputAmount = Integer.parseInt(scanner.nextLine());
                    guindyATM.withDrawAmount(inputAmount);
                    break;

                case 3:
                    guindyATM.checkBalance();
                    break;

                case 4:
                    exit(0);

                default:
                    System.out.println("________________________________");
                    System.out.println("Invalid option, please retry with a valid option");
            }
        }while (true);
    }


}

