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

}

