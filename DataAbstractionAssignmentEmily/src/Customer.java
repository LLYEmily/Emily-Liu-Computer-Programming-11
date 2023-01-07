import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;
    //Constructor
    Customer(){
        accountNumber = 0;
        checkBalance = 0;
        savingBalance = 0;
        name = "";
    }
    //Constructor
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
    }
    //Deposit Method
    public double deposit(double amt, Date date, String account){
        new Deposit(amt, date, account);
        //using if to test if the deposit is for checking or saving
        if(account.equals(CHECKING)){
            //add the amount to the original
            this.checkBalance += amt;
            return checkBalance;
        }
        else if(account.equals(SAVING)){
            this.savingBalance += amt;
            return savingBalance;
        }
        return 0;
    }
    //Withdraw method
    public double withdraw(double amt, Date date, String account){
        new Withdraw(amt, date, account);
        //using if to test if the deposit is for checking or saving
        if(account.equals(CHECKING)){
            if(!checkOverdraft(amt, CHECKING)){
                //Minus the amount with the original
                this.checkBalance -= amt;
                return checkBalance;
            }
            else{
                //if the amount is overdraft in Checking return overdraft error
                System.out.println ("OVERDRAFT error: Checking account balance is below -$100.00");
            }
        } else if(account.equals(SAVING)){
            if(!checkOverdraft(amt, SAVING)){
                this.savingBalance -= amt;
                return savingBalance;
            }
            else{
                //if the amount is overdraft in Saving return overdraft error
                System.out.println("OVERDRAFT error: Savings account balance is below -$100.00");
            }
        }
        return 0;
    }
    //Check Overdraft Method
    private boolean checkOverdraft(double amt, String account){
        //if the Balance minus the amount is less than overdraft than it's true, otherwise false
        if(account.equals(CHECKING)){
            if((checkBalance - amt) < OVERDRAFT){
                return true;
            }
        }
        else if(account.equals(SAVING)){
            if((savingBalance - amt) < OVERDRAFT){
                return true;
            }
        }
        return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
