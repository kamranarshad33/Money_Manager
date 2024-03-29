import java.util.*;

//linkedlist and/or arraylist
public class Bank{
    private String bankName;
    private Account[] bankAccs;
    //Alt:
    private LinkedList<Account> accts;
    //parallel arrays to be swapped out
    private String[] usernames; //prepopulate 
    private String[] passwords; //prepopulate: no protection because of test environment
    // Possible Alt: Map usernames and passwords? key = username, value = pw
    static public Map<String, String> users;
    private double minBalance;
    
    private Bank(){
        //initialize data structures
        accts = new LinkedList<Account>();
        users = new HashMap<String, String>();
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
    
    public int existingUser(String username){
        int index = -1;
        for(int i = 0; i < this.usernames.length; i++){
            if(username.trim().equalsIgnoreCase(this.usernames[i].trim())){
                index = i;
            }
        }
        return index;
    }
    
    public boolean validateUser(String username, String password){
        //logic for parallel arrays
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
    }
    
    // Alt to parallel arrays with usermap
    public static boolean validateUserMap(String username, String password) {
      boolean valid = false;
      for (Map.Entry m : users.entrySet()) {
         if (m.getKey().equals(username) && m.getValue().equals(password)) {
            valid = true;
         }
      }
      if (!valid) {
         throw new IllegalArgumentException("Username or Password does not match.");
      }
      return valid;
    }
    
    public void addCheckingAcc(String username, String password, double balance){
        //boolean validUser = validateUser(username, password);
        Account newAcc = new CheckingAcc(username, balance);
        accts.add(newAcc);     
    }
    
    public void addSavingsAcc(String username, String password, double balance){
        //boolean validUser = validateUser(username, password);
        Account newAcc = new SavingsAcc(username, balance);
        accts.add(newAcc);  
    }
    
    public void addCreditAcc(String username, String password, double balance){
        //boolean validUser = validateUser(username, password);
        Account newAcc = new CreditAcc(username, balance);
        accts.add(newAcc);  
    }
}