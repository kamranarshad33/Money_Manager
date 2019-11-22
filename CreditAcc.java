// Only withdrawals, no deposits allowed?

public class CreditAcc extends Account {
   
   private double creditLimit = 500.00;  // amount can be changed
   
   public CreditAcc() {
      
   }  
   
   public CreditAcc(String username) {
      super(username);
   }
}