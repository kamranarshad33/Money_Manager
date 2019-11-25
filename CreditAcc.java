// Only withdrawals, no deposits allowed? I really want to remove this class... too much of a headache to keep...

public class CreditAcc extends Account {
   
   private double creditLimit;  // amount can be changed
   
   private CreditAcc(){
      
   }  
   
   public CreditAcc(double limit){
      this.creditLimit = limit;
   }
   
   public CreditAcc(String username, double balance) {
      super(username);
   }
   
   public double getCreditLimit() {
      return creditLimit;
   }
   
    public String toString() {
      return "Credit";
    }
}