public class App {

    public static void main() {

        /*
        ---------- ARV -----------
         */

        Parent p = new Parent(67);
        p.myMethod();
        System.out.println("p.x="+p.x);

        Child c = new Child(12, 13);
        c.myMethod();
        System.out.printf("c.x=%d c.y=%d \n", c.x, c.y);


        /*
        ----------- Bank Account Example --------------
         */
        BankAccount a = new BankAccount("Arne Anka");
        a.info();
        a.deposit(1000);
        a.withdraw(200);
        a.info();

        SavingsBankAccount s = new SavingsBankAccount(
                "Katniss Everdeen",
                0.04
        );
        s.deposit(1000);
        s.withdraw(200);
        s.info();  // 795
        s.addInterest();
        s.info();

        System.out.println(
                "Withdrawal fee is currently: " + SavingsBankAccount.WITHDRAWAL_FEE
        );

    }

}
