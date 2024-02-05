import java.util.*;

class BankAccount 
    {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) 
        {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM 
  {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu: \n 1. Withdraw\n 2. Deposit\n 3. Check Balance\n 4. Exit");
    }

    public void performTransaction(int choice, Scanner sc) {
        switch (choice) {
            case 1:
                withdraw(sc);
                break;
            case 2:
                deposit(sc);
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid choice...");
        }
    }

    private void withdraw(Scanner sc) {
        System.out.print("Enter withdrawal amount: $");
        double withdrawAmount = sc.nextDouble();
        if (userAccount.withdraw(withdrawAmount)) {
            System.out.println("Transaction successful. Remaining balance: $" + userAccount.getBalance());
        } 
        else {
            System.out.println("Insufficient balance. Transaction failed...");
        }
    }

    private void deposit(Scanner sc) {
        System.out.print("Enter deposit amount: $");
        double depositAmount = sc.nextDouble();
        userAccount.deposit(depositAmount);
        System.out.println("Transaction successful. New balance: $" + userAccount.getBalance());
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + userAccount.getBalance());
    }
}

public class MainATM 
 {
    public static void main(String[] args) 
       {
        BankAccount userAccount = new BankAccount(0.0);
        ATM atm = new ATM(userAccount);
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            atm.performTransaction(choice, sc);
        } 
        while (choice != 4);

        sc.close();
    }
}
