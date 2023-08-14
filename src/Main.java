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

    public void initialize () throws InvalidAmountException, InsufficientBalanceException {
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
                    if (inputAmount <= 0 )
                    {
                        throw new InvalidAmountException("Amount must be greater than 0.");
                    }
                    depositAmount(inputAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to be withdrawn ... Rs.");
                    inputAmount = Integer.parseInt(scanner.nextLine());
                    if (inputAmount <= 0 )
                    {
                        throw new InvalidAmountException("Amount must be greater than 0.");
                    }
                    if (getAccountBalance() < inputAmount)
                    {
                        throw new InsufficientBalanceException("Insufficient account balance.");
                    }
                    withDrawAmount(inputAmount);
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you, Have a nice day :)");
                    exit(0);

                default:
                    System.out.println("________________________________");
                    System.out.println("Invalid option, please retry with a valid option");
            }
        }while (true);
    }
    private void depositAmount(int inputAmount) {
        addMoney(inputAmount);
        checkBalance();
    }

    private void withDrawAmount(int inputAmount) {
        takeMoney(inputAmount);
        checkBalance();
    }

    private void checkBalance() {
        System.out.println("________________________________");
        System.out.println("Your balance is Rs. " + getAccountBalance());
    }
}

public class Main {
    public static void main(String[] args) throws InvalidAmountException, InsufficientBalanceException {
        IndianBankATM guindyATM = new IndianBankATM();
        guindyATM.initialize();
    }
}

class InvalidAmountException extends Exception{
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

