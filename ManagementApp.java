import java.util.*;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ManagementApp{
    public static void main(String[] args){

        String accttype = "What type of Account you want to add? \n 1: Saving Acct\n 2: Checking Acct\n 3: Credit Card";


        //read from files to create objects: loadData();
            LinkedList<Bank> users = new LinkedList<Bank>();
            try {
               loadData(users);
               System.out.println(users.size());
            }
            catch (FileNotFoundException f) {
        
            }
            catch (IOException i) {
            
            }
            //addUser(info);
            //validateUser(user)
            //addBankAccount(info);
            //validateAcc(acc)
        //do you have an account?
      String start = "Welcome to the Money Manager! \n\n Do you have an existing account?";
      
      //yes? || no?
      //gather acc info || make account?
      //validate acc info || yes? / no?
      //valid? / not valid? || gather new acc info / quit
      //main menu || again? / signup? / quit? || new? / not new?
      //options || back to 3.1 / back to 3.2 / quit || back to 3.1 / again? / quit?
      //options || looped sections or quit || looped section / back to 5.3 / quit
        
      //login/signup method calls here
      
      // Different methods based on existing or new account path?
      if (JOptionPane.showConfirmDialog(null, start) == JOptionPane.YES_OPTION) {
         Bank currentUser = login(users); // Existing user

      }
      else {

         signup(users); // New user
      }        
        
        String menu = getMenu();
        
        int menuOption = 0;
        do{
            menuOption = getMenuOption(menu, menu.length());
            switch(menuOption){
                case 1:
                    JOptionPane.showInputDialog(null,getAcctMenu());
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
                    //Quits the program //System.exit()??
                    //no action required here
                    break;
                default:
                    //never reached
                    JOptionPane.showMessageDialog(null, "How did you get here???");
                    break; 
            }
        }while(menuOption != 5);
    }
    
   // Existing Account path
   public static Bank login(LinkedList<Bank> users) { // validate + return validated Bank user obj to main?
      System.out.println("Existing"); // testcheck
      // Gather User Info
      String uname = "";
      String pw = "";
      Bank currentUser = null;
      boolean found = false;

         uname = JOptionPane.showInputDialog(null, "Username: ", "Existing User Login", JOptionPane.QUESTION_MESSAGE);
         pw = JOptionPane.showInputDialog(null, "Password: ", "Existing User Login", JOptionPane.QUESTION_MESSAGE);
         
         for (Bank user : users) {
            if (user.validateUserMap(uname, pw)) {
               found = true;
               currentUser = user;
               JOptionPane.showMessageDialog(null, "Welcome back!", "Existing User Login", JOptionPane.QUESTION_MESSAGE);
            }
         }
         if (!found) {
            if (JOptionPane.showConfirmDialog(null, "User not found. Try again?") == JOptionPane.YES_OPTION) {
               login(users);
            }
            else {
               JOptionPane.showMessageDialog(null, "Enter 5 on the next screen to quit.", "Existing User Login", JOptionPane.QUESTION_MESSAGE);         
            }
         }
      return currentUser;
      // Go to main menu
   }
   
   // New Account path
   public static void signup(LinkedList<Bank> users) {
      System.out.println("New"); // testcheck
      // Gather User Info   
      String uname = "";
      String pw = "";
      if (JOptionPane.showConfirmDialog(null, "Would you like to create an account?") == JOptionPane.YES_OPTION) {
         System.out.println("Creating Account"); // testcheck
         uname = JOptionPane.showInputDialog(null, "Enter a username: ", "New User Signup", JOptionPane.QUESTION_MESSAGE);
         pw = JOptionPane.showInputDialog(null, "Enter a password: ", "New User Signup", JOptionPane.QUESTION_MESSAGE);
         
         // if matching account
         if (Bank.validateUserMap(uname, pw)) {
            JOptionPane.showMessageDialog(null, "This account already exists. Taking to Existing User Login.", "New User Signup", JOptionPane.QUESTION_MESSAGE);
            login(users);
         }
         else {
            Bank user = new Bank("Money Manager");
            user.users.put(uname, pw);
            users.add(user);            
            JOptionPane.showMessageDialog(null, "Thank you! Welcome!", "New User Signup", JOptionPane.QUESTION_MESSAGE);  
         }
         // Go to main menu

      }
   }
    
    public static boolean validateLogin(){
        return true;
    }
    
    public static String getMenu(){
        String[] menu = {"Add Bank Account", "New Transaction", "Search Transaction History", "Generate Report", "Quit"};  
        String menuStr = "";
        for(int i = 0; i < menu.length; i++){
            menuStr += (i+1)  + ") " + menu[i] + "\n";
        }
        return menuStr;      
    }

    public static String getAcctMenu(){
        String accttype = "What type of Account you want to add? \n 1: Saving Acct\n 2: Checking Acct\n 3: Credit Card";
        return accttype;
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
    
    public static void loadData(LinkedList<Bank> users) throws FileNotFoundException, IOException {
      // prepopulate date from input file
      Bank user;
      String filepath = "./prepop.txt";
      
      File file = new File(filepath);
      Scanner scan = new Scanner(file);
      String line = "";
      
      while (scan.hasNextLine()) {
         line = scan.nextLine();
         Scanner scanLine = new Scanner(line);
         scanLine.useDelimiter(",");
         String uname = scanLine.next().trim();
         //System.out.println(uname);
         String pw = scanLine.next().trim();
         //System.out.println(pw);
         String acctType = scanLine.next().trim();
         //System.out.println(acctType);
         double bal = Double.parseDouble(scanLine.next().trim());
         //System.out.println(bal);
         
         // Pre populate user
         
         user = new Bank("Money Manager", bal);
         user.users.put(uname, pw);
         user.addCheckingAcc(uname, pw, bal);
         users.add(user);

         /*
         users.addLast(new Bank("Money Manager", bal));
         users.getFirst().users.put(uname, pw);
         */
         //System.out.println(user.users.entrySet());
      }
    }
    
    public static void addBankAcc(Bank currentUser) {
      int choice = 0;
      double balance = 0;
      do {
         try {
            choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose account type:\n 1) Checking\n 2) Savings\n 3) Credit", "Existing User Login", 
                     JOptionPane.QUESTION_MESSAGE));
            if (choice < 1 || choice > 3) {
               throw new NumberFormatException();
            }
            else {
               do {
                  balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter initial balance: ", "Existing User Login", 
                     JOptionPane.QUESTION_MESSAGE));
                  if (balance < 0) {
                     throw new NumberFormatException("Balance must be a positive number");
                  }
               } while(balance < 0);
               switch(choice) {
                  case 1:
                     //currentUser.addCheckAcc(currentUser.users.getKey(), currentUser.users.getValue(), 1000.00);
                     break;
                  case 2:
                     break;
                  case 3:
                     break;
               }
            }
         }
         catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Choice must be between 1 and 3. Please try again.");
         }
      } while(choice < 1 || choice > 3);    
    }
    
    public static void newTransction(Account acct) {
      int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose available account:\n 1) Checking\n 2) Savings\n 3) Credit", "Existing User Login", 
                     JOptionPane.QUESTION_MESSAGE));       
    }
    
    public static void getBankAcct() {  // return Account
    
    }
    
    public static void receipt() {
    
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
                        break;
                     case 2: // Search by transaction category
                        do  {
                           category = Integer.parseInt(JOptionPane.showInputDialog(null, "Search by:\n 1) Deposits\n 2) Withdrawals"));
                           if (category < 1 || category > 2) {
                              throw new NumberFormatException();
                           }
                        } while (category < 1 || category > 2);
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
    
    public static void historyReport() {
    
    }
    
    public static void generateReport() {
      // toString()s
    }
}