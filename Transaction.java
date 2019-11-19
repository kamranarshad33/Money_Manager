//import java.util.Date;

public abstract class Transaction{
    private double amount;
    // private Date transDate; //date needed for search
    //private String transType;

    
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
}  