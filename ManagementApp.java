//login info/check to map?
import javax.swing.JOptionPane;


public class ManagementApp{
    public static void main(String[] args){
        //read from files to create objects: loadData(); JUnit tester style adding of banks/bank accs/user accs/transactions/etc.
            //addUser(info);
            //validateUser(user)
            //addBankAccount(info);
            //validateAcc(acc)
            
      //do you have an account?
      //yes? || no?
      //gather acc info || make account?
      //validate acc info || yes? / no?
      //valid? / not valid? || gather new acc info / quit
      //main menu || again? / signup? / quit? || new? / not new?
      //options || back to 3.1 / back to 3.2 / quit || back to 3.1 / again? / quit?
      //options || looped sections or quit || looped section / back to 5.3 / quit
        
                
      //boolean login = false;
      //do{
         //login = startMenu();
         startMenu();  
         //if(login){
            //int option = mainMenu();
            //function(option);
            //if(JOptionPane.showConfirmDialog(null, "Would you like to continue? ", YES_NO_OPTION) != JOptionPane.YES_OPTION){
               //quit();
            //}
         //}
         //else{
            //login = JOptionPane.showConfirmDialog(null, "Would you like to try again? ", YES_NO_OPTION) != JOptionPane.YES_OPTION);
            //if(!login){
            //   quit();
            //}
         //}
      //}while(login);
   }   
    
    public static void startMenu(){
      String start = "Welcome to the Money Manager! \n\n Do you have an existing account?";
      String[] info = new String[2];
      //boolean attempt = false;
      
      // Different methods based on existing or new account path
      if (JOptionPane.showConfirmDialog(null, start) == JOptionPane.YES_OPTION) {
         login();
         //attempt = login(); // Existing user
      }
      else if (JOptionPane.showConfirmDialog(null, start) == JOptionPane.NO_OPTION) {
         signup(); // New user
         if (JOptionPane.showConfirmDialog(null, "Would like to sign in?") == JOptionPane.YES_OPTION) {
            login();
            //attempt = login(); // Existing user
         }
         else{
            quit();
         }  
      }
      else {
         quit();
      }
      //return attempt;
   }
    
   // Existing Account path
   public static void login() { // validate + return validated Acct obj to main? return t/f is fine.
      System.out.println("Existing"); // testcheck
      // Gather User Info
      String uname = "";
      String pw = "";
      boolean valid = false;
      //do {
         uname = JOptionPane.showInputDialog(null, "Username: ", "Existing User Login", JOptionPane.QUESTION_MESSAGE);
         pw = JOptionPane.showInputDialog(null, "Password: ", "Existing User Login", JOptionPane.QUESTION_MESSAGE);
         /*
         // this is to login to the application itself. bank login is dealt with in the bank obj.
         if (validateUser(uname, pw)) {
            JOptionPane.showMessageDialog(null, "Welcome back, " + uname + "!");
            return true;
         }
         else{
            JOptionPane.showMessageDialog(null, "Error: Login invalid. username or password is incorrect.");
            return false;
         }
         */
      // Go to main menu
   }
   
   // New Account path
   public static void signup() {
      System.out.println("New"); // testcheck
      // Gather User Info   
      String uname = "";
      String pw = "";
      if (JOptionPane.showConfirmDialog(null, "Would you like to create an account?") == JOptionPane.YES_OPTION) {
         System.out.println("Creating Account"); // testcheck
         uname = JOptionPane.showInputDialog(null, "Enter a username: ", "New User Signup", JOptionPane.QUESTION_MESSAGE);
         pw = JOptionPane.showInputDialog(null, "Enter a password: ", "New User Signup", JOptionPane.QUESTION_MESSAGE);
         /*
         // Bank = placeholder for correct object // this is to sign up for the application itself.
         if (Bank.validateUser(uname, pw)) {
            JOptionPane.showMessageDialog(null, "This account already exists. Try a different username.");
            
         }
         else {
            Bank.addUser(uname, pw) method implement?
            JOptionPane.showMessageDialog(null, "Thank you! Welcome, " + uname + "!" + " Your account has been created");  
         }
         // Go to main menu
         */
      }
   }
    
    public static boolean validateLogin(){
        /* to do */
        return true;
    }
    
    public static boolean validateSignup(){
        /* to do */
        return true;
    }
    
    public static int mainMenu(){
        String menu = getMenu();
        
        int menuOption = 0;
        do{
            menuOption = getMenuOption(menu, menu.length());
            switch(menuOption){
                case 1:
                    JOptionPane.showMessageDialog(null, "add bank account");
                    //addBankAcc();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "new transaction");
                    //getBankAcc(UserObj); //choose which bank account to make the transaction with
                    //newTransaction(bankAcc); //make transaction (withdrawal, disposit)
                    //receipt(); //can be done at end of transaction instead
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "transaction history");
                    historySearch();
                    //historySearch(UserObj);
                    //historyReport() //reporting done at end of search instead
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "user report");
                    //generateReport(UserObj);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "quit");
                    quit();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option: Please choose a number between 1 and 5");
                    break; 
            }
        }while(menuOption != 5);
        return option;
    }
    
    public static String getMenu(){
        String[] menu = {"Add Bank Account", "New Transaction", "Search Transaction History", "Generate Report", "Quit"};  
        String menuStr = "";
        for(int i = 0; i < menu.length; i++){
            menuStr += (i+1)  + ") " + menu[i] + "\n";
        }
        return menuStr;      
    }
    
    public static int getMenuOption(String menu, int length){
        int option = 0;
        do{
            try{
                option = Integer.parseInt(JOptionPane.showInputDialog("Choose a menu option number: \n" + menu));
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error: Menu Option needs to be a number between 1 & " + length);
            }
        }while(option < 1 || option > length);
        return option;
    }
    
    
    
        
    
    
    
    
    
    public static void historySearch() {
        int option = 0;
        String date = "";
        int category = 0;
 
        do{
            try {
               option = Integer.parseInt(JOptionPane.showInputDialog(null, "Search transactions by:\n 1) Date\n 2) Category",
                  "Search Transaction History", JOptionPane.QUESTION_MESSAGE));
               if (option < 1 || option > 2) {
                  throw new NumberFormatException();
               }
               else {
                  switch(option) {
                     case 1: // Search by Date
                        do {
                           date = JOptionPane.showInputDialog(null, "Enter a date in the format of MM/DD/YY: ");
                        } while (!validDate(date)); 
                        historyReport(date);
                        break;
                     case 2: // Search by transaction category
                        do  {
                           category = Integer.parseInt(JOptionPane.showInputDialog(null, "Search by:\n 1) Deposits\n 2) Withdrawals"));
                           if (category < 1 || category > 2) {
                              throw new NumberFormatException();
                           }
                        } while (category < 1 || category > 2);
                        historyReport(category);
                        break;
                  }
               }
            }
            catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "Error: Search Choice must be number 1 or 2.  Please try again.");
            }
        }while(option < 1 || option > 2);    
    }
    
    public static boolean validDate(String date) { // return boolean
         boolean valid = false;  // true only for testing
         
            if (date.charAt(2) == '/' && date.charAt(5) == '/') { // Check for correct format of slashes
               valid = true;
            }
            else {
               JOptionPane.showMessageDialog(null, "Error: Date must be in format MM/DD/YY. Please try again.");
            }
         return valid;
    }
    
    public static void historyReport(String date) {
        
    }
    
    public static void historyReport(int type) {
        
        if(type == 1){
            //unless we are going to use W for withdrawal
            String type = "Withdrawal"; 
            
        }
    }
    
    public static void quit(){
        JOptionPane.showMessageDialog(null, "Thank you for using the Money Management App.");
        System.exit(0);
    }

}