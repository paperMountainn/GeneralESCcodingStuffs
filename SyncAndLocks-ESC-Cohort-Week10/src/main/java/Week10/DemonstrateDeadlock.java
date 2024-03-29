package Week10;

import java.util.Random;

public class DemonstrateDeadlock {
    private static final int NUM_THREADS = 20;
    private static final int NUM_ACCOUNTS = 5;

    public static void main(String[] args) {
        final Account[] accounts = new Account[NUM_ACCOUNTS];

        for (int i = 0; i < accounts.length; i++)
            accounts[i] = new Account(i);

        for (int i = 0; i < NUM_THREADS; i++)
            new TransferThread(accounts).start();
    }
}

class TransferThread extends Thread {
    private static final int NUM_ITERATIONS = 100;
    private Account[] accounts;

    public TransferThread(Account[] accounts) {
        this.accounts = accounts;
    }

    public void run() {
        final Random rnd = new Random();
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            int fromAcct = rnd.nextInt(accounts.length);
            int toAcct = rnd.nextInt(accounts.length);
            int amount = rnd.nextInt(1000);
            transferMoney(accounts[fromAcct], accounts[toAcct], amount);
            System.out.println("Finished Iteration:" + i + " for thread Id:" + currentThread().getId());
        }
    }

    public void transferMoney(Account from, Account to, int amount) {
        synchronized (from) {
            synchronized (to) {
                if (from.getBalance() < amount) {
                    System.out.println("Insufficient Fund");
                } else {
                    from.debit(amount);
                    to.credit(amount);
                }
            }
        }
    }
}

class Account {
    private final int id;
    private int amount;
    public Account(int i) {
        id = i;
    }

    public int getBalance() {
        return amount;
    }

    public void debit(int n) {
        amount = amount - n;
    }

    public void credit(int n) {
        amount = amount + n;
    }
    public int getId() {
        return id;
    }
}
