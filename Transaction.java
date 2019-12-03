import java.util.Date;

public class Transaction{
    private double amount;
    private String transDate; //date needed for search
    private String transType;
   
    private Transaction(){ }
    
    public Transaction(double amount, String date, String type){
        if(amount >= 0){ 
            this.amount = amount;
        }
        else{
            throw new IllegalArgumentException("The transaction amount cannot be negative.");
        } 
        setDate(date);
        //we can change this based on what you think is better. 'W & D' OR 'Withdrawal & Deposit'
        //if(!type.equalsIgnoreCase("Withdrawal") || !type.equalsIgnoreCase("Deposit")){
        //System.out.println("type: " + type);
        if(!(type.equalsIgnoreCase("Withdrawal") || type.equalsIgnoreCase("Deposit"))){
            throw new IllegalArgumentException("The transaction type was not valid.");
        }
        else{
            transType = type;
        }
    }
    
    //copy constructor
    public Transaction(Transaction original){
        this.amount = original.getAmount();
        this.transDate = original.getDate();
        this.transType = original.getTransType();
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
    
    
    public void setDate(String date) {
        if(date.length() > 8){
            throw new IllegalArgumentException("The date given was too long.");
        }
        if(date.length() == 7){
            String temp = "0" + date;
            date = temp;
        }
        for(int i = 0; i < date.length(); i++){
            //System.out.println("i-"+ i + ": " + date.charAt(i));
            if(i != 2 && i != 5){
                
                if(!Character.isDigit(date.charAt(i))){
                    throw new IllegalArgumentException("The date can only contain numeric values and '/'.");
                }
            }
            //*
            else if (i == 2 || i == 5){
                if(date.charAt(i) != '/'){
                    throw new IllegalArgumentException("The '/' character was not found in the right location.");
                }
            }
            //*/
        }
        this.transDate = date;
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