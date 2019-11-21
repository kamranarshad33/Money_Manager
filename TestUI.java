import javax.swing.JOptionPane;

public class TestUI {
   
   public static void main(String[] args) {
      String start = "Welcome to the Money Manager! \n\n Do you have an existing account?";
      
      // Different methods based on existing or new account path?
      if (JOptionPane.showConfirmDialog(null, start) == JOptionPane.YES_OPTION) {
         existUser();
      }
      else {
         newUser();
      }

   }
   
   // Existing Account path
   public static void existUser() { // validate + return validated Acct obj to main?
      System.out.println("Existing"); // testcheck
      // Gather User Info
      String uname = "";
      String pw = "";
      boolean valid = false;
      do {
         uname = JOptionPane.showInputDialog(null, "Enter username: ", "Existing User Login", JOptionPane.QUESTION_MESSAGE);
         pw = JOptionPane.showInputDialog(null, "Enter password: ", "Existing User Login", JOptionPane.QUESTION_MESSAGE);
         /*
            // Bank = placeholder for correct object
            if (Bank.validateUser(uname, pw) {
               valid = true;
               JOptionPane.showMessageDialog(null, "Welcome back, " + uname + "!", "Existing User Login");
            }
            else {
               if (JOptionPane.showConfirmDialog(null, "Would you like to try again? ", "Existing User Login", YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                  existUser();
               }
            }
         */
         valid = true;
      } while(!valid);
      // Go to main menu
   }
   
   // New Account path
   public static void newUser() {
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
         if (Bank.validateUser(uname, pw)) {
            JOptionPane.showMessageDialog(null, "This account already exists. Taking to Existing User Login.", "New User Signup");
            existUser();
         }
         else {
            Bank.addUser(uname, pw) method implement?
            JOptionPane.showMessageDialog(null, "Thank you! Welcome, " + uname + "!", "New User Signup");  
         }
         // Go to main menu
         */
      }
   }
}