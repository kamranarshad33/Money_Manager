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
   public static void existAcct() {
      System.out.println("Exisiting");
      // Gather User Info
   }
   
   // New Account path
   public static void newAcct() {
      System.out.println("New");
      if (JOptionPane.showConfirmDialog(null, "Create an account?") == JOptionPane.YES_OPTION) {
         System.out.println("createAcct()");
      }   
   }
}