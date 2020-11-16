package ATM;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank theBank = new Bank("The Amazing Bank");
        // add user
        User aUser = theBank.addUser("John", "Mike", "2222");
        //check account for user
        Account newAccount = new Account ("Checking",aUser, theBank);
//        aUser.addAccount(newAccount);
//        theBank.addAccount(newAccount);

        User ourUser;
        while(true){
            ourUser = Main.mainMenuPrompt(theBank, sc);
            Main.printUserMenu(ourUser, sc);


        }


    }

 public static User mainMenuPrompt(Bank theBank, Scanner sc) {
     String userID;
     String pin;
     User authUser;

     do {
         System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
         System.out.print("Enter User ID : ");
         userID = sc.nextLine();
         System.out.print("Enter Pin : ");
         pin = sc.nextLine();

//Validating user with pin and userId
         authUser = theBank.userLogin(userID, pin);
         if (authUser == null) {
             System.out.println("Incorrect User ID/pin combination, Please Don't Let me Swear For you");
         }
     } while (authUser == null);
     return authUser;
 }
 public static void printUserMenu(User theUser, Scanner sc){

// Summary of the user's account
     theUser.printAccountSummary();

    int choice;

    do {
        System.out.printf("Welcome %s, What would you like to do? ", theUser.getFirstName());
        System.out.println("1) Show Transcation History/n 2) Withdrawal\n 3) Deposit\n 4) Transfer \n 5) Quit ");
        System.out.println();
        System.out.print("Enter your choice : ");
        choice = sc.nextInt();

        if (choice < 1 || choice > 5) {
            System.out.println("Invalid Choice, Please Choose 1 - 5");

        }
    }
        while (choice < 1 || choice > 5) ;

        //process th choice
     switch (choice){
             case 1 :
               Main.showTransHistory(theUser, sc);
             break;
             case 2 :
               Main.withdrawFunds(theUser, sc);
             break;
             case 3 :
                 Main.depositFunds(theUser, sc);
                 break;
         case 4 :
             Main.transferFunds(theUser, sc);
             break;
     }
     //re display unless user quits
     if(choice != 5){
         Main.printUserMenu(theUser, sc);
     }

    }
 public static  void showTransHistory(User theUser, Scanner sc){
    int theAcct;

    do{
        System.out.printf("Enter the number (1-%d) of the account\n" + "Whose transcation do you want to see :"
                , theUser.numAccount());
        theAcct = sc.nextInt()-1;
        if(theAcct < 0 || theAcct >= theUser.numAccount()){
            System.out.println("Invalid Accounts!!!!!!");
        }
    }
    while (theAcct < 0 || theAcct >= theUser.numAccount());
    theUser.printAcctTranscHistory(theAcct);
 }

public static void transferFunds(User theUser, Scanner sc) {
    int fromAcct = 0;
    int toAcct;
    double amount;
    double acctBal;

    //to transfer
    do {
        System.out.printf("Enter the Number (1-%d) of the account\n" +
                "To transfer from :");
        fromAcct = sc.nextInt();
        if (fromAcct < 0 || fromAcct >= theUser.numAccount()) {
            System.out.println("Invalid Accounts !!!!");
        }
    }
    while (fromAcct < 0 || fromAcct >= theUser.numAccount());

    //getBalance
    acctBal = theUser.getAcctBalance(fromAcct);

         //Account to transfer to
    do {
        System.out.println("Enter the number (1-%d) of the account\n");
    }

    }
}



