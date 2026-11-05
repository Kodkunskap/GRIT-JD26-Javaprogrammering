public class App {

    public static void main() {

        BankAccount bankAccount = new BankAccount();

        System.out.println(bankAccount.getSaldo());

        /*
        ---------- ARV -----------
         */

        Parent p = new Parent(67);
        p.myMethod();
        System.out.println("p.x="+p.x);

        Child c = new Child(12, 13);
        c.myMethod();
        System.out.printf("c.x=%d c.y=%d \n", c.x, c.y);

    }

}
