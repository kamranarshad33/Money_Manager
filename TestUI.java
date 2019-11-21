import javax.swing.JOptionPane;

public class TestUI {
   
   public static void main(String[] args) {
      String start = "Welcome to the Money Manager! \n\n Do you have an existing account?";
      
      // Different methods based on existing or new account path?
      if (JOptionPane.showConfirmDialog(null, start) == JOptionPane.YES_OPTION) {
         existAcct();
      }
      else {
         newAcct();
      }

   }
   
   // Existing Account path
   public static void existAcct() { // validate + return validated Acct obj to main?
      // Gather User Info
      String uname = "";
      String pw = "";
      boolean valid = false;
      do {
         uname = JOptionPane.showInputDialog(null, "Enter username: " + "hello", "Existing User", JOptionPane.QUESTION_MESSAGE);
         pw = JOptionPane.showInputDialog(null, "Enter password: ", "Existing User", JOptionPane.QUESTION_MESSAGE);
         /*
            // Bank = placeholder for correct object
            if (Bank.validateUser(uname, pw) {
               valid = true;
               JOptionPane.showMessageDialog(null, "Welcome back, " + uname + "!");
            }
            else {
               if (JOptionPane.showConfirmDialog(null, "Would you like to try again? ", "Existing User", YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                  existAcct();
               }
            }
         */
         valid = true;
      } while(!valid);
      System.out.println("Existing");
   }
   
   // New Account path
   public static void newAcct() {
      if (JOptionPane.showConfirmDialog(null, "Create an account?") == JOptionPane.YES_OPTION) {
         System.out.println("createAcct()");
      }
      System.out.println("New");   
   }
}