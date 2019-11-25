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
    Map<String, Account> userAccs; //key: Username
    private double minBalance;
    
    private Bank(){
        //initialize data structures
        this.userAccs = = new Hashtable<String, String>();
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
    
    private void setBankName(String bankName){
        this.bankName = bankName;
    }
    
    private void setMinBalance(double minBalance){
        this.minBalance = minBalance;
    }
    //to do
    public boolean validateUser(String username, String password){
      if(userInfo.containsKey(username)){
         
      }
      else{
         System.out.println("The given phone number: " + key + " was not found.");
      }
        /*//logic for parallel arrays
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
        */
    }
    
    
    public void addCheckingAcc(String username, String password, double balance){
        //boolean validUser = validateUser(username, password);
        Account newAcc = new CheckingAcc(username, balance);     
    }
    
    public void addSavingsAcc(String username, String password, double balance){
        //boolean validUser = validateUser(username, password);
        Account newAcc = new SavingsAcc(username, balance);
    }
    
    public void addCreditAcc(String username, String password, double balance){
        //boolean validUser = validateUser(username, password);
        Account newAcc = new CreditAcc(username, balance);
    }
}