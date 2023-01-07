import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    //Constructor
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Convert Withdraw info to String
    public String toString(){
        return "Withdraw of: $" + amount + " Date:" + date + " into account: " + account;
    }
}
