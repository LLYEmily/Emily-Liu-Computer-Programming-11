import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    //Constructor
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    //Convert Deposit info to String
    public String toString(){
        return "Deposit of: $" + amount + " Date:" + date + " into account: " + account;
    }
}
