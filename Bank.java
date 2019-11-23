//linkedlist and/or arraylist
public class Bank{
    private String bankName;
    private Account[] bankAccs;
    //parallel arrays to be swapped out
    private String[] usernames; //prepopulate 
    private String[] passwords; //prepopulate: no protection because of test environment
    private double minBalance;
    
    private Bank(){
        //initialize data structures
        
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