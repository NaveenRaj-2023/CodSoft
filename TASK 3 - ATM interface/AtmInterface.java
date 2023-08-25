import java.util.Scanner; 
 
class BankAccount { 
    private double balance; 
 
    public BankAccount(double initialBalance) { 
        balance = initialBalance; 
    } 
 
    public double getBalance() { 
        return balance; 
    } 
 
    public void deposit(double amount) { 
        if (amount > 0) { 
            balance += amount; 
            System.out.println("Deposit successful. New balance: " + balance); 
        } else { 
            System.out.println("Invalid amount for deposit."); 
        } 
    } 
 
    public void withdraw(double amount) { 
        if (amount > 0 && amount <= balance) { 
            balance -= amount; 
            System.out.println("Withdrawal successful. New balance: " + balance); 
        } else { 
            System.out.println("Invalid amount for withdrawal or insufficient balance."); 
        } 
    } 
} 
 
class ATM { 
    private BankAccount account; 
 
    public ATM(BankAccount account) { 
        this.account = account; 
    } 
 
    public void displayMenu() { 
        System.out.println("ATM Menu:"); 
        System.out.println("1. Check Balance"); 
        System.out.println("2. Deposit"); 
        System.out.println("3. Withdraw"); 
        System.out.println("4. Exit"); 
    } 
 
    public void run() { 
        Scanner scanner = new Scanner(System.in); 
        int choice; 
 
        do { 
            displayMenu(); 
            System.out.print("Enter your choice: "); 
            choice = scanner.nextInt(); 
 
            switch (choice) { 
                case 1: 
                    System.out.println("Your balance: " + account.getBalance()); 
                    break; 
                case 2: 
                    System.out.print("Enter deposit amount: "); 
                    double depositAmount = scanner.nextDouble(); 
                    account.deposit(depositAmount); 
                    break; 
                case 3: 
                    System.out.print("Enter withdrawal amount: "); 
                    double withdrawalAmount = scanner.nextDouble(); 
                    account.withdraw(withdrawalAmount); 
                    break; 
                case 4: 
                    System.out.println("Thank you for using the ATM."); 
                    break; 
                default: 
                    System.out.println("Invalid choice. Please choose again."); 
                    break; 
            } 
 
        } while (choice != 4); 
        scanner.close(); 
    } 
} 
 
public class AtmInterface { 
    public static void main(String[] args) { 
        BankAccount userAccount = new BankAccount(0); // Initial balance 
        ATM atm = new ATM(userAccount); 
        atm.run(); 
    } 
}
