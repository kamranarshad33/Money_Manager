/**
   Follows the flow of the first part of the UI in ManagementApp
*/
import javax.swing.JOptionPane;

public class TestUI {
   
   public static void main(String[] args) {
      startMenu();  
      //int option = Main Menu();

   }
   
   public static void startMenu(){
      String start = "Welcome to the Money Manager! \n\n Do you have an existing account?";
      String info[] = new String[2];
      // Different methods based on existing or new account path?
      if (JOptionPane.showConfirmDialog(null, start) == JOptionPane.YES_OPTION) {
         //info = login();
         login(); // Existing user
      }
      else if (JOptionPane.showConfirmDialog(null, start) == JOptionPane.NO_OPTION) {
         signup(); // New user
         if (JOptionPane.showConfirmDialog(null, "Would like to sign in?") == JOptionPane.YES_OPTION) {
            //info = login();
            login(); // Existing user
         }
         else{
            quit();
         }  
      }
      else {
         quit();
      }
   }
   
   // Existing Account path
   public static void login() { // validate + return validated Acct obj to main?
      System.out.println("Existing"); // testcheck
      // Gather User Info
      //String uname = "";
      //String pw = "";
      String[] info = new String[2]; //uname = info[0] & pw = info[1];
      boolean valid = false;
      do {
         info[0] = JOptionPane.showInputDialog(null, "Username: ", "Existing User Login", JOptionPane.QUESTION_MESSAGE);
         info[1] = JOptionPane.showInputDialog(null, "Password: ", "Existing User Login", JOptionPane.QUESTION_MESSAGE);
         /*
            // Bank = placeholder for correct object
            if (Bank.validateUser(uname, pw) {
               valid = true;
               JOptionPane.showMessageDialog(null, "Welcome back, " + uname + "!", "Existing User Login");
            }
            else {
               if (JOptionPane.showConfirmDialog(null, "Would you like to try again? ", "Existing User Login", YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                  login();
               }
            }
         */
         //valid = true;
      } while(!valid);
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
         // Bank = placeholder for correct object
         boolean continueFlag = false;
         do{
            //flag reset
            continueFlag = false;
            //unsuccessful creation
            if (Bank.validateUser(uname, pw)) {
               JOptionPane.showMessageDialog(null, "This account already exists. Please try a different username.");
               continueFlag = JOptionPane.showConfirmDialog(null, "Would you like to try again?") == JOptionPane.YES_OPTION);
            }
            //successful creation
            else {
               addUser(uname, pw) //this is an app method, not a bank method. write to file?
               JOptionPane.showMessageDialog(null, "Thank you! Welcome, " + uname + "!", "Your account has been created."); 
               
            }
         }while(!continueFlag);
         // Go to main menu
         */
      }
      
   }
   
   public static void quit(){
      JOptionPane.showMessageDialog(null, "Thank you for using the Money Managing App");
      System.exit(0);
   }
}   