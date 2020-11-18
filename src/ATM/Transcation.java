package ATM;

import java.util.Date;

public class Transcation {
    //Amount of transc.
    private double amount;

    //Time when transcation occured
      private Date timeStamp;

    // Transcation description
      private String memo = " ";

      //Account in which transc occured
      private Account inAccount;


      public Transcation(double amount, Account inAccount){
          this.amount = amount;
          this.inAccount = inAccount;
          this.timeStamp = new Date();
          this.memo = " ";

      }
      public Transcation(double amount, String memo, Account inAccount){
          this(amount, inAccount);
          this.memo = memo;

      }
      public double getAmount(){
          return this.amount;

      }
      //transcation Summary
      public String getSummaryLine(){
          if(this.amount >= 0){
              return String.format("%s: #%.02f : %s", this.timeStamp.toString(),
                      this.amount, this.memo);
          }else{
              return String.format("%s : #(0.2f) : %s", this.timeStamp.toString(),
                      this.amount, this.memo);
          }
      }

}
