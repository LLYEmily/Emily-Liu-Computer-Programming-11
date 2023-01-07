import java.util.Date;
public class Main {
        public static void main(String[] args) {
            Customer Me = new Customer("Emily Liu", 12345, 1000, 3000);
            //Testing
            /* System.out.println("+666.0 Current balance in Checking: " + Me.deposit(666.0, new Date(), "Checking"));
            System.out.println("-200.0 Current balance in Checking: " + Me.withdraw(200.0, new Date(), "Checking"));
            System.out.println("-100000 Current balance in Checking: " + Me.withdraw(100000, new Date(), "Checking"));
            System.out.println("+888.0 Current balance in Saving: " + Me.deposit(888.0, new Date(), "Saving"));
            System.out.println("-600.0 Current balance in Saving: " + Me.withdraw(600.0, new Date(), "Saving"))
            System.out.println("-100000 Current balance in Saving: " + Me.withdraw(100000, new Date(), "Saving")); */

            //Display of Output
            //Deposit of: $400.0 Date: Sun Nov 04 00:00:00 PDT 2022 into account: Checking Current Balance in Checking is: $600.00

            //Test Deposit and Withdraw in 'Me''s Checking and Saving account
            //First Longer Version
            System.out.println("Deposit of: $666.0 | Date: " + new Date() + " | into account: Checking | Current Balance in Checking is: " + Me.deposit(666.0, new Date(), "Checking"));
            System.out.println("Deposit of: $888.0 | Date: " + new Date() + " | into account: Saving | Current Balance in Saving is: " + Me.deposit( 888.0, new Date(), "Saving"));
            System.out.println("Withdraw of: $520.0 | Date: " + new Date() + " | into account: Checking | Current Balance in Checking is: " + Me.withdraw(520.0, new Date(), "Checking"));
            System.out.println("Withdraw of: $1314.0 | Date: " + new Date() + " | into account: Saving | Current Balance in Saving is: " + Me.withdraw( 1314.0, new Date(), "Saving"));

            //Second Shorter Version
            Deposit checkingDeposit = new Deposit(123.0, new Date(), "Checking");
            Deposit savingDeposit = new Deposit(321.0, new Date(), "Saving");
            System.out.println(checkingDeposit.toString() + " Current Balance in Checking is: " + Me.deposit(123.0, new Date(), "Checking"));
            System.out.println(savingDeposit.toString() + " Current Balance in Saving is: " + Me.deposit(321.0, new Date(), "Saving"));
            Withdraw checkingWithdrew = new Withdraw(456.0, new Date(), "Checking");
            Withdraw savingWithdrew = new Withdraw(654.0, new Date(), "Checking");
            System.out.println(checkingWithdrew.toString() + " Current Balance in Checking is: " + Me.withdraw(456.0, new Date(), "Checking"));
            System.out.println(savingWithdrew.toString() + " Current Balance in Saving is: " + Me.withdraw(654.0, new Date(), "Saving"));

            //Test Overdraft in Checking and Saving Account
            System.out.println("Withdraw of: $10000000.0 | Date: " + new Date() + " | into account: Checking | Current Balance in Checking is: " + Me.withdraw( 10000000.0, new Date(), "Checking"));
            System.out.println("Withdraw of: $10000000.0 | Date: " + new Date() + " | into account: Saving | Current Balance in Saving is: " + Me.withdraw( 10000000.0, new Date(), "Saving"));

        }
}

