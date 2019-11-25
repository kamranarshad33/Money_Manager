public class CheckingAcc extends Account{
    //private final MINBAL = 500;
    private final double OVERDRAFT_FEE = 30;
    
    private CheckingAcc(){ 
           
    }
    public CheckingAcc(String username, double balance){
        super(username, balance);
    }
    
    public String toString() {
      return "Checking";
    }
}