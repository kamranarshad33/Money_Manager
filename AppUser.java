import java.util.*;
import java.util.LinkedList;

public class AppUser{
    private String name;
    private String username;
    private String password;
    LinkedList<Account> bankAccs;
    
    
    private AppUser(){
        this.bankAccs = new LinkedList<Account>();
    }
    public AppUser(String name, String username, String password){
        this();
        this.password = password;
        this.name = name;
        this.username = username;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public LinkedList<Account> getBankAccs(){
        LinkedList<Account> copyList = new LinkedList<Account>();
        Account copy = null;
        for(Account curr : this.bankAccs){
            if(curr instanceof CheckingAcc){
                copy = new CheckingAcc(curr.getAccNum(), curr.getUsername(), curr.getBalance(), curr.getInterest(), curr.getTransactions());
            }
            else if(curr instanceof SavingsAcc){
                copy = new SavingsAcc(curr.getAccNum(), curr.getUsername(), curr.getBalance(), curr.getInterest(), curr.getTransactions(), curr.getWDLimit(), curr.getNumWD());
            }
            else if(curr instanceof CreditAcc){
                copy = new CreditAcc(curr.getAccNum(), curr.getUsername(), curr.getBalance(), curr.getInterest(), curr.getTransactions());
            }
            copyList.add(copy);
        }
        return copyList;
    }
    
    public void setName(String name){
        this.name = name ;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password, String confirm){
        this.password = password;
    }
    
    public void setBankAccs(){
        LinkedList<Account> copyList = new LinkedList<Account>();
        Account copy = null;
        for(Account curr : this.bankAccs){
            if(curr instanceof CheckingAcc){
                copy = new CheckingAcc(curr.getAccNum(), curr.getUsername(), curr.getBalance(), curr.getInterest(), curr.getTransactions());
            }
            else if(curr instanceof SavingsAcc){
                copy = new SavingsAcc(curr.getAccNum(), curr.getUsername(), curr.getBalance(), curr.getInterest(), curr.getTransactions(), curr.getWDLimit(), curr.getNumWD());
            }
            else if(curr instanceof CreditAcc){
                copy = new CreditAcc(curr.getAccNum(), curr.getUsername(), curr.getBalance(), curr.getInterest(), curr.getTransactions());
            }
            copyList.add(copy);
        }
        this.bankAccs = copyList;
    }
    
}