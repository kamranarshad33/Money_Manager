import java.util.LinkedList;
import java.util.Date;

public abstract class Account{
    private String accNum;
    private String username;
    private double balance;
    private double interestRate;
    private LinkedList<Transaction> transactions;
        
    public Account(){
        this.transactions = new LinkedList<Transaction>();
        //randomized account number
        String accNum_12 = "";
        accNum_12 += (long) (Math.random() * 1000000000000L);
        this.accNum = accNum_12;
        //randomized interest rate (0-10%)
        this.interestRate = (double)(int)(Math.random() * 100)/10;
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
    public LinkedList<Transaction>  getTransactions(){ 
        LinkedList<Transaction> copyList = new LinkedList<Transaction>();
        for(Transaction curr : this.transactions){
            Transaction copy = new Transaction(curr.getAmount(), curr.getDate(), curr.getTransType());
            copyList.add(copy);
        }
        return copyList;
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
    
    private void setTransaction(LinkedList<Transaction> newTransList){
        LinkedList<Transaction> copyList = new LinkedList<Transaction>();
        for(Transaction curr : this.transactions){
            Transaction copy = new Transaction(curr.getAmount(), curr.getDate(), curr.getTransType());
            copyList.add(copy);
        }
        this.transactions = copyList;
    }
    
    
    public void withdrawal(double amount){//, Date date){
        String transType = "Withdrawal";
        if(amount < 0){
            throw new IllegalArgumentException("Withdrawal amount needs to be a positive number");
        }
        else if(amount > getBalance()){
            throw new IllegalArgumentException("Withdrawal amount needs to be less than the balance: " + this.balance);
        }
        else{
            //Transaction transaction = new Transaction(amount, date, transType); 
            //this.transactions.add(transaction);
            double newBal = getBalance() - 0;//transaction.getAmount//transaction amount
            //if(newBal < bank.getMinBalance()){
            //    
            //}
            setBalance(newBal);
        }
    }
    
    public void deposit(double amount){//, Date date){
        String transType = "Deposit";
        if(amount < 0){
            throw new IllegalArgumentException("Deposit amount needs to be a positive number");
        }
        else{
            //Transaction transaction = new Transaction(amount, date, transType);
            //this.transactions.add(transaction);
            double newBal = getBalance() + 0;//transaction.getAmount();//transaction amount
            setBalance(newBal);
        }
    }
    
    public String toString() {
      return accNum + " " + balance;
    }
}