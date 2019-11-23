// Only withdrawals, no deposits allowed?

public class CreditAcc extends Account {
   
   private double creditLimit = 500.00;  // amount can be changed
   
   public CreditAcc() {
      
   }  
   
   public CreditAcc(String username, double balance) {
      super(username);
   }
   
   public double getCreditLimit() {
      return creditLimit;
   }
}