public class SavingsAcc extends Account{
    private final int monthlyWDLimit = 6;
    // Track withdrawals?
    // int numWithdrawals = 0;
    
    private SavingsAcc(){ 
           
    }
    
    public SavingsAcc(String username, double balance){
        super(username, balance);
    }
    
    public String toString() {
      return "Savings";
    }
    
}  