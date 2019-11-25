import java.util.Date;

public class Transaction{
    private double amount;
    private String transDate; //date needed for search
    private String transType;
   
    private Transaction(){ }
    
    //public Transaction(int amount, String date, String type){
    public Transaction(double amount, Date date, String type){
        if(amount >= 0){ 
            this.amount = amount;
        }
        else{
            throw new IllegalArgumentException("The transaction amount cannot be negative.");
        } 
        //************* not sure how we are doing the date, please fix if this is wrong ************
        transDate = String.format("%tD", date);
        //we can change this based on what you think is better. 'W & D' OR 'Withdrawal & Deposit'
        //if(!type.equalsIgnoreCase("Withdrawal") || !type.equalsIgnoreCase("Deposit")){
        if(!type.equalsIgnoreCase("W") || !type.equalsIgnoreCase("D")){
            throw new IllegalArgumentException("The transaction type was not valid.");
        }
        else{
            transType = type;
        }
    }
    
    //copy constructor
    public Transaction(double amount, String date, String type){
        this.amount = amount;
        this.transDate = date;
        this.transType = type;
    }
    
    public double getAmount(){
        return this.amount;    
    }
    
    private void setAmount(double amount){
        if(amount >= 0){ 
            this.amount = amount;
        }
        else{
            throw new IllegalArgumentException("The transaction amount cannot be negative.");
        }    
    }
    
    public String getDate() {
      return this.transDate;
    }
    
    
    public void setDate(Date userDate) {
        // formats date to String = MM/DD/YY
        transDate = String.format("%tD", userDate);
    }
    
    public String getTransType() {
      return transType;
    }
    
    public void setTransType(String type) {
      if (type.trim().equalsIgnoreCase("deposit") || type.trim().equalsIgnoreCase("withdrawal")) {
         this.transType = type;
      }
      else {
         throw new IllegalArgumentException("Error: Deposit and withdrawal are only options.");
      }
    }
}  