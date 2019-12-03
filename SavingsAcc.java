import java.util.*;
import java.util.LinkedList;

public class SavingsAcc extends Account{
    private int monthlyWDLimit;
    // Track withdrawals? yes
    int numWithdrawals = 0;
    
    private SavingsAcc(){ 
        
    }
    
    public SavingsAcc(String username, double balance){
        super(username, balance);
    }
    
    //copy constructor
    public SavingsAcc(SavingsAcc acc){
        super(acc.getAccNum(), acc.getUsername(), acc.getBalance(), acc.getInterest(), acc.getTransactions());
        this.monthlyWDLimit = acc.getWDLimit();
        this.numWithdrawals = acc.getNumWD();
    }
    
    public int getWDLimit(){
        return this.monthlyWDLimit;
    }
    
    public int getNumWD(){
        return this.numWithdrawals;
    }
    
    public void setWithdrawals(){
        if(this.numWithdrawals + 1 < monthlyWDLimit){
            throw new IllegalArgumentException("You have reached the monthly withdrawal limit.");
        }
        this.numWithdrawals = this.numWithdrawals + 1;
    }
    
    public void resetWithdrawals(){
        this.numWithdrawals = 0;
    }
    
    public String toString() {
      return "Savings";
    }   
}  