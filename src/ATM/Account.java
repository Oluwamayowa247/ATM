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
    private double balance;


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

    public String getSummaryLine() {

        //getBalance
        double balance = this.getBalance();

        //formatting summaryline
        if (this.balance >= 0) {
     return String.format("%s : #%.02f :%s",
             this.uuid, balance, this.name);

        }else {
            return String.format("%s : #(%.02f) :%s",
                    this.uuid, balance, this.name);
        }
    }
    public double getBalance(){
        double balance = 0;
        for(Transcation t : this.transcations){
            balance += t.getAmount();
        }
        return balance;
    }
     public void printTransHistory(){
        System.out.printf("\nTranscation History for account %s\n", this.uuid);
        for(int t = this.transcations.size()-1; t>=0; t--){
            System.out.print(this.transcations.get(t).getSummaryLine());
        }
        System.out.println();
     }
     public void addTranscation(double amount, String memo){
        Transcation newTransc = new Transcation(amount, memo, this);
        this.transcations.add(newTransc);


     }
    }



