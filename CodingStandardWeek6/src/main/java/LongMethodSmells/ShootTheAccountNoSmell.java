package LongMethodSmells;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import LongMethodSmells.Transaction;


public class ShootTheAccountNoSmell {
    private int balance = 0;
    private List<Transaction> ListOfAllTransactions = new ArrayList<Transaction>();
    private String lastDebitTime;
    private String lastcreditTime;
    private String accountType;



    public ShootTheAccountNoSmell () {
    }

    public ShootTheAccountNoSmell (int balance) {
        this.balance = balance;
    }

    public void deposit (int amount) {
        balance += amount;
    }

    public void setBalance (int amount) {
        balance = amount;
    }

    public int getBalance () {
        return balance;
    }

    public void addTransaction(String tType, int amount){
        this.ListOfAllTransactions.add(new Transaction(tType, amount));

    }


    public void logTransactionTime(String tType){
        Calendar cal = Calendar.getInstance();

        if (tType.equals("debit")){
            this.lastDebitTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);
        }
        else if (tType.equals("credit")){
            this.lastcreditTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);
        }
        else{
            System.out.println("Not Supported");
        }

    }

    // intention: we want to add a new feature such that these actions were only performed for personal accounts
    // and accounts with >= 500 in balance
    // we add this additional checking method to ensure that the 2 conditions are checked
    // instead of adding condition to each if statements in Transfer, DebitTransaction and CreditTransaction

    // later on if you want to modify the restrictions, only need to modify this function
    public boolean check(){
        boolean conditionIsOk = balance >= 500 || !this.accountType.equals("personal");
        return conditionIsOk;
    }



    // this method has a long method smell
    public void DebitTransaction(int amount) {

        if (check()){
        //reduce the amount
//	  balance = balance - amount;
        deposit(-amount);
        //add to the transaction list
//	  ListOfAllTransactions.add(new Transaction("debit", amount));
        addTransaction("debit", amount);

        //update the last debit date
//	  Calendar cal = Calendar.getInstance();
//
//	  lastDebitTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);
        logTransactionTime("debit");
        }
    }

    public void CreditTransaction(int amount){
        if (check()) {
            // increase the amount
            deposit(amount);

            // add to the transaction list
            addTransaction("credit", amount);

            // update the last credit date
            logTransactionTime("credit");

        }
    }



    // this method has a long method smell
    public void Transfer(int amount, ShootTheAccount Benf) {

        if (check()) {
            //reduce the amount
//            balance = balance - amount;
            deposit(-amount);

            //add to the transaction list
//            ListOfAllTransactions.add(new Transaction("debit", amount));
            addTransaction("debit", amount);

            //update the last debit date
//            Calendar cal = Calendar.getInstance();
//
//            lastDebitTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);

            logTransactionTime("debit");

            Benf.CreditTransaction(amount);
        }
    }



    public void sendWarning() {
        if (balance < 500)
            System.out.println("Balance must be more than 500, please deposit");
    }
}
