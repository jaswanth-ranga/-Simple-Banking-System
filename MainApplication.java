import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = null;
        boolean running = true;

        while (running) {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    String accountNo = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initBalance = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    customer = new Customer(name, customerId);
                    customer.createAccount(accountNo, initBalance);
                    break;

                case 2:
                    if (checkCustomerExists(customer)) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmt = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        customer.depositMoney(depositAmt);
                    }
                    break;

                case 3:
                    if (checkCustomerExists(customer)) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmt = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        customer.withdrawMoney(withdrawAmt);
                    }
                    break;

                case 4:
                    if (checkCustomerExists(customer)) {
                        System.out.println("Current balance: " + customer.getBalance());
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static boolean checkCustomerExists(Customer customer) {
        if (customer == null) {
            System.out.println("Please create an account first.");
            return false;
        }
        return true;
    }
}
