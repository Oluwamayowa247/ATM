package ATM;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;


    public Bank(String BankName){
        this.name = BankName;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();

    }

   //user Id
    public String getNewUserUUID(){
    String uuid;
        Random rng = new Random();
        int len= 6;
        boolean nonUnique;
        do{
            // uuid generation
            uuid = "";
            for(int c = 0; c<len; c++){
                 uuid += ((Integer)rng.nextInt(10)).toString();

            }
            //check for uniqueness
            nonUnique = false;
            for(User u : this.users){
                if(uuid.compareTo(u.getUUID()) == 0 ){
                    nonUnique = true;
                    break;
                }
            }

        }
        while (nonUnique);


        return uuid;
    }
    public String getNewAccountUUID(){
        String uuid;
        Random rng = new Random();
        int len= 10;
        boolean nonUnique;
        do{
            // uuid generation
            uuid = " ";
            for(int c = 0; c<len; c++){
                uuid += ((Integer)rng.nextInt(10)).toString();

            }
            //check for uniqueness
            nonUnique = false;
            for(Account a : this.accounts){
                if(uuid.compareTo(a.getUUID()) == 0 ){
                    nonUnique = true;
                    break;
                }
            }
        }
        while (nonUnique);

        return uuid;
    }
    public void addAccount(Account onAcct){

        this.accounts.add(onAcct);
    }
    public User addUser(String firstName, String lastName, String pin){
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);
        //create savings account
        Account newAccount = new Account("Savings", newUser, this);
        return newUser;
    }
    public User userLogin(String userID, String pin){
        //search through list of user
        for(User u : this.users){
            //check for userID
//            System.out.println( u.getUUID().length());
//            System.out.println( userID.length());
//

            if(u.getUUID().compareTo(userID)== 0 && u.validatePin(pin)){
                System.out.println(u.getUUID());
                return u;
            }
        }
        return null;
    }

    public String getName(){
     return this.name;
 }
}
