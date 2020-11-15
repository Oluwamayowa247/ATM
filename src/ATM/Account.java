package ATM;

import java.util.ArrayList;

public class Account {

    // name of account
    private String name;

    //account ID
    private String uuid;

    // User Object that owns the account
    private User holder;

    // list of transcations for this account
    private ArrayList<Transcation> transcations;

    public Account(String name, User holder, Bank theBank){
     // set Account name
     this.name = name;
     this.holder = holder;
     //get Account UUID
        this.uuid = theBank.getNewAccountUUID();

      // init trans
         this.transcations = new ArrayList<Transcation>();

         //add account to holder and bank list
          holder.addAccount(this);
          theBank.addAccount(this);
    }

    //account uuid
    public String getUUID() {
        return this.uuid;
    }


}
