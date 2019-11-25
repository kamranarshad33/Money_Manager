import java.util.*;

public abstract class Account{
    private String accNum;
    private String username;
    private double balance;
    private double interestRate;
    //private Transaction[] transactions; // change data structure later
    //Alt:
    private LinkedList<String> transactions;
    
    public Account(){
        //randomized account number
        String accNum_12 = "";
        accNum_12 += (long) (Math.random() * 1000000000000L);
        this.accNum = accNum_12;
        //randomized interest rate (0-10%)
        this.interestRate = (double)(int)(Math.random() * 100)/10;
        transactions = new LinkedList<String>();
    }
    public Account(String userName){
        this();
        this.username = userName;
    }
    public Account(String userName, double balance){
        this(userName);
        this.balance = balance;
    }
    
    
    
    public String getAccNum(){
        return this.accNum;
    }
    public String getUsername(){
        return this.username;
    }
    public double getBalance(){
        return this.balance;
    }
    public void getTransactions(){ //Tranaction[] getTransactions(){
        //make copy
        //Transaction[] copy = original
        //return this.copy;
    }
    
    private void setAccNum(String accNum){
        this.accNum = accNum;
    }
    private void setUsername(String userName){
        this.username = userName;
    }
    private void setBalance(double balance){
        this.balance = balance;
    }
    private void setTransactions(){//Tranaction[] getTransactions(){
        //make copy
        //Transaction[] copy = original
        //return this.copy;
        //transactions.add(Transaction.toString());
    }
    
    
    public void withdrawal(double amount){
        //String transType = "Withdrawal";
        if(amount < 0){
            throw new IllegalArgumentException("Withdrawal amount needs to be a positive number");
        }
        else if(amount > getBalance()){
            throw new IllegalArgumentException("Withdrawal amount needs to be less than the balance: " + this.balance);
        }
        else{
            //get transaction date
            //make and store new transaction object
            double newBal = getBalance() - 0;//transaction amount
            //if(newBal < bank.
            setBalance(newBal);
        }
    }
    public void deposit(double amount){
        //String transType = "Deposit";
        if(amount < 0){
            throw new IllegalArgumentException("Deposit amount needs to be a positive number");
        }
        else{
            //get transaction date
            //make and store new transaction object
            double newBal = getBalance() - 0;//transaction amount
            setBalance(newBal);
        }
    }
    
    public String toString() {
      return accNum + " " + balance;
    }
}