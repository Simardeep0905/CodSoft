import java.util.Scanner;

class ATM {
    private Bank account;

    public ATM(Bank account) {
        this.account = account;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank You! Have a nice day.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: Rs %.2f %n", account.getBalance());
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: Rs.");
        double amount = scanner.nextDouble();
        if(account.deposit(amount)){
            System.out.printf("Deposit successful. Your current balance is: Rs %.2f %n",account.getBalance());
        }
        else{
            System.out.println("Balance to be deposited should be greater than 0. Thank You.");
        }
       
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: Rs.");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.printf("Withdrawal successful. Your current balance is: Rs %.2f %n",account.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
}

class Bank {
    private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount) {
        if(amount>0){
          balance += amount;
          return true;
        } else {
           return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        Bank account = new Bank(2000);
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}