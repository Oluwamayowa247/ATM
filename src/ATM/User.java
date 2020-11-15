package ATM;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    private String firstName;

    private String lastName;

    // the user unique id
    private String uuid;

    // the hash of the user's pin number
    private byte [] pinHash;

   private ArrayList<Account> accounts;


   public User(String firstName, String lastName, String pin, Bank theBank){
       this.firstName = firstName;
       this.lastName = lastName;

       //Store the pin's MD 5 hash
       try {
           MessageDigest md = MessageDigest.getInstance("MD5");
           this.pinHash = md.digest(pin.getBytes());
       } catch (NoSuchAlgorithmException e) {
           System.out.println("Error Caught NoSuchAlgorithmExeception");
           e.printStackTrace();
           System.exit(-1);
       }

       //get UUID for user
       this.uuid = theBank.getNewUserUUID();

  // Empty List of accounts
       this.accounts = new ArrayList<Account>();
       //Log Message
       System.out.printf("New User %s, %s with ID %s created.\n", lastName, firstName, this.uuid);
   }
   public void addAccount(Account onAcct){
       this.accounts.add(onAcct);
   }

    public String getUUID() {

    return this.uuid;
    }

    //Validating pin
    public boolean validatePin(String aPin){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error caught noSuchAlgorithmException");
            e.printStackTrace();
            System.exit(-1);
        }
        return false;

    }
}
