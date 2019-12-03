import java.util.*;

public class AppUser{
    private String name;
    private String username;
    private String password;
    ArrayList<Account> bankAccs;
    public static final int MAX_ACCOUNTS = 10;
    private int numAccs = 0;
    
    
    private AppUser(){
        this.bankAccs = new ArrayList<Account>();
    }
    public AppUser(String name, String username, String password){
        this();
        this.name = name;
        this.username = username;
        this.password = password;
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
    
    public ArrayList<Account> getBankAccs(){
        ArrayList<Account> copyList = new ArrayList<Account>();
        Account copy = null;
        for(Account curr : this.bankAccs){
            if(curr instanceof CheckingAcc){
                CheckingAcc temp = (CheckingAcc)curr;
                copy = new CheckingAcc(temp);
            }
            else if(curr instanceof SavingsAcc){
                SavingsAcc temp = (SavingsAcc)curr;
                copy = new SavingsAcc(temp);
            }
            /*
            else if(curr instanceof CreditAcc){
                copy = new CreditAcc(curr.getAccNum(), curr.getUsername(), curr.getBalance(), curr.getInterest(), curr.getTransactions());
            }
            copyList.add(copy);
            */
        }
        return copyList;
    }
    
    public int getNumAccs(){
        return this.numAccs;
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
    
    public void setBankAcc(Account acc){
        if(this.getNumAccs() + 1 > MAX_ACCOUNTS){
            throw new IllegalArgumentException("No more bank accounts can be added to this account.");
        }
    
        Iterator<Account> it = this.bankAccs.iterator();
        while(it.hasNext()){
            Account curr = it.next();
            if(curr.equals(acc)){
                throw new IllegalArgumentException("The bank account has already been added.");
            }
        }
        Account copy = null;
        if(acc instanceof CheckingAcc){
            CheckingAcc temp = (CheckingAcc)acc;
            copy = new CheckingAcc(temp);
        }
        else if(acc instanceof SavingsAcc){
            SavingsAcc temp = (SavingsAcc)acc;
            copy = new SavingsAcc(temp);
        }
        this.bankAccs.add(copy);
        setNumAccs();
    }
    
    public void setBankAccs(ArrayList<Account> list){
        if(list.size() > 10){
            throw new IllegalArgumentException("The list of bank accounts is too long.");
        }
        ArrayList<Account> copyList = new ArrayList<Account>();
        Account copy = null;
        for(Account curr : list){
            if(curr instanceof CheckingAcc){
                CheckingAcc temp = (CheckingAcc)curr;
                copy = new CheckingAcc(temp);
            }
            else if(curr instanceof SavingsAcc){
                SavingsAcc temp = (SavingsAcc)curr;
                copy = new SavingsAcc(temp);
            }
            /*
            else if(curr instanceof CreditAcc){
                copy = new CreditAcc(curr.getAccNum(), curr.getUsername(), curr.getBalance(), curr.getInterest(), curr.getTransactions());
            }
            */
            copyList.add(copy);
        }
        this.bankAccs = copyList;
    }
    
    public void setNumAccs(){
        this.numAccs = this.numAccs + 1;
    }
}