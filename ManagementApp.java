//login info/check to map?
import java.util.LinkedList;
import java.io.BufferedReader;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ManagementApp{
    public static void main(String[] args){
        //Prepopulate bank/bankacc/usersacc/transactions
        try{
            JOptionPane.showMessageDialog(null, "Welcome to the Money Manager App.\n Please wait while the system to load up.");
            LinkedList<Bank> banks = new LinkedList<Bank>();
            AppUser user = populateData(banks);
            //sortBanks(banks);
            int option = mainMenu(user, banks);
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
         ///////////////////////////////////////////////////////////////////startMenu();  
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
        catch(FileNotFoundException e){
            System.out.println("Pre-population file was not found.");
        }   
        catch(IOException e){
            System.out.println("Input/Output stream could not be established.");
        }
   }   
    
    /* too complex
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
         ///*
         // this is to login to the application itself. bank login is dealt with in the bank obj.
         if (validateUser(uname, pw)) {
            JOptionPane.showMessageDialog(null, "Welcome back, " + uname + "!");
            return true;
         }
         else{
            JOptionPane.showMessageDialog(null, "Error: Login invalid. username or password is incorrect.");
            return false;
         }
         ////
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
         ///*
         // Bank = placeholder for correct object // this is to sign up for the application itself.
         if (Bank.validateUser(uname, pw)) {
            JOptionPane.showMessageDialog(null, "This account already exists. Try a different username.");
            
         }
         else {
            Bank.addUser(uname, pw) method implement?
            JOptionPane.showMessageDialog(null, "Thank you! Welcome, " + uname + "!" + " Your account has been created");  
         }
         // Go to main menu
         ////
      }
   }
    
    public static boolean validateLogin(){
        // to do
        return true;
    }
    
    public static boolean validateSignup(){
        //to do
        return true;
    }
    
    */
    public static int mainMenu(AppUser user, LinkedList<Bank> banks){
        String menu = getMenu();
        Bank[] madeBanks = sortBankNames(banks);
        String bankMenu = getBankNames(madeBanks);
        
        int menuOption = 0;
        do{
            menuOption = getMenuOption(menu, menu.length());
            Iterator<Account> it = null;
            switch(menuOption){
                case 1:
                    JOptionPane.showMessageDialog(null, "add bank account");
                    int bankNum = Integer.parseInt(JOptionPane.showInputDialog("Please choose the bank you account is associated with.\n" + bankMenu));
                    bankNum--;
                    Bank assocBank = madeBanks[bankNum];
                    LinkedList<Account> list = assocBank.getBankAcc();
                    it = list.iterator();
                    String accNumList = "";
                    while(it.hasNext()){
                        Account acc = it.next();
                        accNumList += acc.getAccNum() + "\n";
                                
                    }
                    String accNum = JOptionPane.showInputDialog("Please enter the account number associated with the account.\n" + accNumList);
                    try{
                        Account acc = locateBankAcc(assocBank, accNum);
                        user.setBankAcc(acc);
                        JOptionPane.showMessageDialog(null, "Account was added successfully.");
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "new transaction");
                    ArrayList<Account> bankAccs = user.getBankAccs();
                    it = bankAccs.iterator();
                    while(it.hasNext()){
                        Account curr = it.next();
                        
                    }
                    //getBankAcc(user); //choose which bank account to make the transaction with
                    //newTransaction(user); //make transaction (withdrawal, disposit)
                    //receipt(); //can be done at end of transaction instead
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "transaction history");
                    historySearch(user);
                    //historyReport() //reporting done at end of search instead
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "user report");
                    //generateReport(user);
                    break;
                case 5:
                    //JOptionPane.showMessageDialog(null, "quit");
                    quit();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option: Please choose a number between 1 and 5.");
                    break; 
            }
        }while(menuOption != 5);
        return menuOption;
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
                JOptionPane.showMessageDialog(null, "Error: Menu Option needs to be a number between 1 & 5");
            }
        }while(option < 1 || option > length);
        return option;
    }

    
    
    public static Bank[] sortBankNames(LinkedList<Bank> banks){
        Iterator<Bank> it = banks.iterator();
        int size = banks.size();
        Bank[] sort = new Bank[size];
        int count = 0;
        while(it.hasNext()){
            sort[count] = it.next();
            count++;
        }
        sort = insertionSort(sort);
        return sort;
    }
    
    public static Bank[] insertionSort(Bank[] sort){
        Bank temp;
        for(int i = 1; i < sort.length; i++){
            for(int j = i; j > 0; j--){
                if(sort[j].getBankName().compareTo(sort[j-1].getBankName()) < 0){
                    temp = sort[j];
                    sort[j] = sort[j-1];
                    sort[j-1] = temp;
                }
            }
        } 
        return sort;
    }
    
    public static String getBankNames(Bank[] sort){
        String banks = "";
        for(int i = 0; i < sort.length; i++){
            banks += (i + 1) + ") " + sort[i].getBankName() + "\n";
        }
        return banks;
    }
    
    public static Account locateBankAcc(Bank assocBank, String accNum){
        LinkedList<Account> bankAccs = assocBank.getBankAcc();
        Iterator<Account> it = bankAccs.iterator();
        Account acc = null;
        while(it.hasNext()){
            Account curr = it.next();
            if(curr.getAccNum().equalsIgnoreCase(accNum)){
                acc = curr;
            }
        }
        if(acc == null){
            throw new IllegalArgumentException("Account was not found.");
        }
        return acc;
    }
    
    /***********************************************************************************************/
    //search transactions
    /***********************************************************************************************/
    public static void historySearch(AppUser user) {
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
                        historyReport(date, user);
                        break;
                     case 2: // Search by transaction category
                        do  {
                           category = Integer.parseInt(JOptionPane.showInputDialog(null, "Search by:\n 1) Deposits\n 2) Withdrawals"));
                           if (category < 1 || category > 2) {
                              throw new NumberFormatException();
                           }
                        } while (category < 1 || category > 2);
                        historyReport(category, user);
                        break;
                  }
               }
            }
            catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "Error: Search Choice must be number 1 or 2.  Please try again.");
            }
        }while(option < 1 || option > 2);    
    }
    
    public static boolean validDate(String date) {
         if(date.length() != 8){
            JOptionPane.showMessageDialog(null, "Error: Date must be in format MM/DD/YY. Please try again.");
            return false;
         }
         else{
            for(int i = 0; i < date.length(); i++){
                if(i == 0){
                    if(date.charAt(i) != '0' && date.charAt(i) != '1'){
                        JOptionPane.showMessageDialog(null, "Error: The first number in the date must be 0 or 1. Please try again.");
                        return false;
                    }
                }
                else if(i != 2 && i != 5){
                    if(!Character.isDigit(date.charAt(i))){
                        JOptionPane.showMessageDialog(null, "Error: The date can only contain numbers and /. Please try again.");
                        return false;
                    }
                }
                else{
                    if(date.charAt(i) != '/'){
                        JOptionPane.showMessageDialog(null, "Error: The third and fifth character in the date must be a /. Please try again.");
                        return false;
                    }
                }
            }
            return true;
        }
    }
    
    public static void historyReport(String date, AppUser user) {
        String report = searchTransactions(date, user);
        writeReport(report);
    }
    
    public static void historyReport(int category, AppUser user) {
        String report = "";
        if(category == 1){
            //unless we are going to use W for withdrawal
            String type = "Withdrawal";
            report += searchTransactions(type, user);
        }
        else if(category == 2){
            //unless we are going to use D for deposit
            String type = "Deposit"; 
            report += searchTransactions(type, user);
        }
        writeReport(report);
    }
    
    public static String searchTransactions(String key, AppUser user){
        ArrayList<Account> userAccs = user.getBankAccs();
        Iterator<Account> it = userAccs.iterator();
        String data = "";
        while(it.hasNext()){
            Account currAcc = it.next();
            LinkedList<Transaction> transactions = currAcc.getTransactions();
            
            //type search
            if(!Character.isDigit(key.charAt(0))){
                for(Transaction curr : transactions){
                    if(curr.getTransType().equals(key)){
                        data += curr.toString() + "\n";
                    }
                }
            }
            //date search
            else{
                for(Transaction curr : transactions){
                    if(curr.getDate().equals(key)){
                        data += curr.toString() + "\n";
                    }
                }
            }
        }
        return data;
    }
    
    //write to file??
    public static void writeReport(String report){
        JOptionPane.showMessageDialog(null, report);   
    }
    
    /***********************************************************************************************/
    //quit the program
    /***********************************************************************************************/
    public static void quit(){
        JOptionPane.showMessageDialog(null, "Thank you for using the Money Management App.");
        System.exit(0);
    }
    
    /***********************************************************************************************/
    //populate data
    /***********************************************************************************************/
    public static AppUser populateData(LinkedList<Bank> banks) throws FileNotFoundException, IOException{ //Begin getTransactions
		
        // for testing purposes we already prepopulated a file
        String testpath = "pre-populate.txt";
        BufferedReader br = new BufferedReader(new FileReader(new File(testpath)));
		String line;
		Scanner scan = null;
		int count = 0;
        Bank bank = null; 
        Account bankAcc = null;
        AppUser userAcc = null;
		while((line = br.readLine()) != null) {
            count++;
            //System.out.println("Line " + count + ": " + line);
            switch (line.charAt(0)){
                case 'b'://bank
                    bank = createBank(line);
                    banks.add(bank);
                    break;
                case 'a'://bank acc
                    bankAcc = createBankAcc(line);
                    if(bankAcc instanceof CheckingAcc){
                        CheckingAcc temp = (CheckingAcc)bankAcc;
                        bank.addCheckingAcc(temp);
                    }
                    else if(bankAcc instanceof SavingsAcc){
                        SavingsAcc temp = (SavingsAcc)bankAcc;
                        bank.addSavingsAcc(temp);
                    }
                    //System.out.println(Math.random() * 10);
                    if(Math.random() * 10 > 5.5){
                        userAcc.setBankAcc(bankAcc);  
                    }
                    break;
                /*
                case 'i'://bank user info
                    createUserInfo(bank, line);
                    break;
                */
                case 't'://transaction
                    createTransaction(bankAcc, line);
                    break;
                case 'u'://user acc
                    userAcc= createUser(line);
                    break;
            }
        }
        return userAcc;
	}
    
    public static Bank createBank(String line){
        String[] data = line.split(",");
        ////string(bank name) and double(min balance)
        Bank bank = new Bank(data[1], Double.parseDouble(data[2]));
        return bank;
    }
    
    public static Account createBankAcc(String line){
        String[] data = line.split(",");
        Account bankAcc = null;
        if(data[1].equals("c")){
            //string(username) and double(balance)
            bankAcc = new CheckingAcc(data[2], Double.parseDouble(data[3]));
            
        }
        if(data[1].equals("s")){
            //string(username) and double(balance)
            bankAcc = new SavingsAcc(data[2], Double.parseDouble(data[3]));
        }
        return bankAcc;
    }
    
    /*
    public static void createUserInfo(Bank bank, String line){
        String[] data = line.split(",");
        bank.addUser(data[1], data[2]);
    }
    */
    
    public static void createTransaction(Account bankAcc, String line){
        String[] data = line.split(",");
        //double(amount), string(date), string(type)
        //System.out.println(data[1] + ", " + data[2] + ", " + data[3] );
        
        if(bankAcc instanceof SavingsAcc){
            SavingsAcc temp = (SavingsAcc)bankAcc;
            if(data[3].equalsIgnoreCase("Withdrawal")){
                temp.setWithdrawals();
                temp.setTransaction(new Transaction(Double.parseDouble(data[1]), data[2], data[3]));
            }
        }
        else{
            bankAcc.setTransaction(new Transaction(Double.parseDouble(data[1]), data[2], data[3]));
        }
    }
    
    public static AppUser createUser(String line){
        String[] data = line.split(",");
        //String(name), String(username), String(password)
        AppUser user = new AppUser(data[1], data[2], data[3]);
        return user;
    }
}