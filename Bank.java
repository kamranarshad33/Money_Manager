import java.util.*;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import java.util.HashMap;

//linkedlist and/or arraylist
public class Bank{
    private String bankName;
    //private Account[] bankAccs;
    //parallel arrays to be swapped out
    //private String[] usernames; //prepopulate 
    //private String[] passwords; //prepopulate: no protection because of test environment
    // Possible Alt: Map usernames and passwords? key = username, value = pw //Smart idea
    Map<String, String> userInfo; //key: Username
    LinkedList<Account> bankAccs; //key: Username//bankAcc map is impossible.
    private double minBalance;
    
    private Bank(){
        //initialize data structures
        this.userInfo = new Hashtable<String, String>();
        //this.bankAccs = new Hashtable<String, Account>();
        this.bankAccs = new LinkedList<Account>();
        this.minBalance = 0;
    }
    
    public Bank(String name){
        this();
        this.bankName = name;
    }
    
    public Bank(String name, double minBal){
        this(name);
        this.minBalance = minBal;
    }
    
    public String getBankName(){
        return this.bankName;
    }
    
    public double getMinBalance(){
        return this.minBalance;
    }
    
    public LinkedList<Account> getBankAcc(){
        return this.bankAccs;
    }
    
    private void setBankName(String bankName){
        this.bankName = bankName;
    }
    
    private void setMinBalance(double minBalance){
        this.minBalance = minBalance;
    }
    
    ////////////////////////////////////////////////////////////////////////////////
    //ADD USER ACCOUNTS: Scrapped
    ////////////////////////////////////////////////////////////////////////////////
    /*
    public void addUser(String username, String password){
        boolean newUser = validateUser(username, password);
        this.userInfo.put(username, password);
    }
    
    public boolean validateUser(String username, String password){
      if(userInfo.containsKey(username)){
         if(userInfo.get(username) != password){
            return false;
         }      
         else{
            return true;
         }
      }
      return false;

        ////logic for parallel arrays
        int index = existingUser(username);
        boolean valid = false;
        if(index != -1){
            valid = this.passwords[index].equals(password);
            if(!valid){
                throw new IllegalArgumentException("Password does not match.");
            }
        }
        else{
            throw new IllegalArgumentException("Username does not exist.");
        }
        return valid;
        ////
    }
    */
    
    ////////////////////////////////////////////////////////////////////////////////
    //ADD BANK ACCOUNTS
    ////////////////////////////////////////////////////////////////////////////////
    public void addCheckingAcc(CheckingAcc acc){
        CheckingAcc copy = new CheckingAcc(acc);
        bankAccs.add(acc);
    }
    
    public void addSavingsAcc(SavingsAcc acc){
        SavingsAcc copy = new SavingsAcc(acc);
        bankAccs.add(acc);
    }
    /*
    public void addCreditAcc(String username, String password, double limit){
        boolean validUser = validateUser(username, password);
        if(validUser){
            bankAccs.put(username, new CreditAcc(limit));
        }
        else{
            System.out.println("Username is invalid. The checking account was not added.");//invalid user
        }
    }
    */
}