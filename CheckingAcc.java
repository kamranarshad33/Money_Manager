import java.util.*;
import java.util.LinkedList;


public class CheckingAcc extends Account{
    //private final MINBAL = 500;
    private final double OVERDRAFT_FEE = 30;
    
    private CheckingAcc(){ 
           
    }

    public CheckingAcc(String username, double balance){
        super(username, balance);
    }

    //copy constructor
    public CheckingAcc(CheckingAcc acc){
        super(acc.getAccNum(), acc.getUsername(), acc.getBalance(), acc.getInterest(), acc.getTransactions());
    }    
    
    
    public String toString() {
      return "Checking";
    }
}