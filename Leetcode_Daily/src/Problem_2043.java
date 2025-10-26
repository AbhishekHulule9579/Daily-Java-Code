import java.util.*;

public class Problem_2043 {

    static class Bank {

        private long[] balances;

        public Bank(long[] balance) {
            this.balances = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (isValid(account1) && isValid(account2) && balances[account1 - 1] >= money) {
                balances[account1 - 1] -= money;
                balances[account2 - 1] += money;
                return true;
            }
            return false;
        }

        public boolean deposit(int account, long money) {
            if (isValid(account)) {
                balances[account - 1] += money;
                return true;
            }
            return false;
        }

        public boolean withdraw(int account, long money) {
            if (isValid(account) && balances[account - 1] >= money) {
                balances[account - 1] -= money;
                return true;
            }
            return false;
        }

        private boolean isValid(int account) {
            return account >= 1 && account <= balances.length;
        }

        public void printBalances() {
            System.out.println("Current Balances: " + Arrays.toString(balances));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example: Initialize the bank with balances
        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();
        long[] balance = new long[n];

        System.out.println("Enter balances for each account:");
        for (int i = 0; i < n; i++) {
            balance[i] = sc.nextLong();
        }

        Bank bank = new Bank(balance);
        bank.printBalances();

        System.out.println("\nChoose an operation:");
        System.out.println("1 - Transfer");
        System.out.println("2 - Deposit");
        System.out.println("3 - Withdraw");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter fromAccount, toAccount, money: ");
                int a1 = sc.nextInt(), a2 = sc.nextInt();
                long moneyT = sc.nextLong();
                System.out.println(bank.transfer(a1, a2, moneyT) ? "Transfer successful" : "Transfer failed");
                break;
            case 2:
                System.out.print("Enter account, money: ");
                int a3 = sc.nextInt();
                long moneyD = sc.nextLong();
                System.out.println(bank.deposit(a3, moneyD) ? "Deposit successful" : "Deposit failed");
                break;
            case 3:
                System.out.print("Enter account, money: ");
                int a4 = sc.nextInt();
                long moneyW = sc.nextLong();
                System.out.println(bank.withdraw(a4, moneyW) ? "Withdraw successful" : "Withdraw failed");
                break;
            default:
                System.out.println("Invalid choice");
        }

        bank.printBalances();
        sc.close();
    }
}
