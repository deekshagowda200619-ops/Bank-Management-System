import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
    int accountNumber;
    String name;
    double balance;

    BankAccount(int accNo, String name, double balance) {
        this.accountNumber = accNo;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully!");
    }
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        }
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

public class BankManagementSystem {

    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Login credentials
    static String USERNAME = "admin";
    static String PASSWORD = "1234";

    public static boolean login() {
        System.out.println("===== BANK LOGIN =====");

        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
            System.out.println("Login Successful!\n");
            return true;
        } else {
            System.out.println("Invalid Credentials!");
            return false;
        }
    }

    public static BankAccount findAccount(int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.accountNumber == accNo) {
                return acc;
            }
        }
        return null;
    }

    public static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.add(new BankAccount(accNo, name, balance));
        System.out.println("Account Created Successfully!");
    }

    public static void depositMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            acc.deposit(amt);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            System.out.println("Balance: " + acc.balance);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public static void displayAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            acc.display();
        } else {
            System.out.println("Account Not Found!");
        }
    }

    public static void main(String[] args) {

        if (!login()) {
            return;
        }

        int choice;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: depositMoney(); break;
                case 3: withdrawMoney(); break;
                case 4: checkBalance(); break;
                case 5: displayAccount(); break;
                case 6: System.out.println("Thank You!"); break;
                default: System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }
}