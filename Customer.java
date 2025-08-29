public class Customer {
    private String name;
    private String customerId;
    private BankAccount account;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public void createAccount(String accNo, double balance) {
        this.account = new BankAccount(accNo, balance);
        System.out.println("Account created successfully with balance: " + balance);
    }

    public void depositMoney(double amt) {
        if (account != null) {
            account.deposit(amt);
            System.out.println("Deposited amount: " + amt);
        } else {
            System.out.println("Create an account first.");
        }
    }

    public void withdrawMoney(double amt) {
        if (account != null) {
            account.withdraw(amt);
            System.out.println("Withdrawn amount: " + amt);
        } else {
            System.out.println("Create an account first.");
        }
    }

    public double getBalance() {
        if (account != null) {
            return account.getBalance();
        } else {
            System.out.println("Create an account first.");
            return 0;
        }
    }
}
