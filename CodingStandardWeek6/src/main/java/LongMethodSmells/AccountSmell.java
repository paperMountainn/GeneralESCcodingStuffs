package LongMethodSmells;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class Transaction {
	private String type;
	private int amount;
	
	public Transaction (String newType, int newAmount) {
		this.type = newType;
		this.amount = newAmount;
	}
}


public class AccountSmell {
  private int balance = 0;
  private List<Transaction> ListOfAllTransactions = new ArrayList<Transaction>();
  private String lastDebitTime;
  private String lastCreditTime;
  
  public AccountSmell () {
  }

  public AccountSmell (int balance) {
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
          this.lastCreditTime = cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);
      }
      else{
          System.out.println("Not Supported");
      }

  }

  
  // this method has a long method smell
  public void DebitTransaction(int amount) {
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

  public void CreditTransaction(int amount){
      // increase the amount
      deposit(amount);

      // add to the transaction list
      addTransaction("credit", amount);

      // update the last credit date
      logTransactionTime("credit");


  }

}                                                                                                                                                                                                       
