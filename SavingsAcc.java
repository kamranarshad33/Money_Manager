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
    
    public SavingsAcc(String accNum, String username, double balance, double interest, LinkedList<Transaction> trans, int limit, int numWD){
        super(accNum, username, balance, interest, trans);
        this.monthlyWDLimit = limit;
        this.numWithdrawals = numWD;
    }
    
    public int WDLimit(){
        return this.monthlyWDLimit;
    }
    
    public int numWD(){
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