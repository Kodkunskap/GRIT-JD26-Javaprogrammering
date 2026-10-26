import java.util.Scanner;

public class Lesson02 {

    public static void main(String[] args) {

        // EN-rads kommentar

        /*

            Block-kommentar - över flera rader

         */

        int number = (int) Math.pow(2, 2);
        System.out.println(number);

        // Primitiva datatyper
        int myCounter = 1;
        long timerInMS = 999L;          // L betyder att talet 999 är av typen long
        final float PI = 3.141597f;     // f betyder att talet är en float, final betyder skrivskyddad
        double e = 2.7;
        char a = 'a';                   // Obs att vi använder ' (apostrof)
        boolean sunnyOutside = false;   // true eller false

        // Icke primitiva datatyper
        String name = "Martin";         // Obs vi använder "
        Integer age = 12;
        // Char, Double, Float, Boolean osv

        // Casts (byte av datatyp)
        // Widening Cast - från mindre datatyp till en större
        e = myCounter;


        // Narrowing Cast
        Double myLong = (double) timerInMS;

        String userInput = "67";
        int pinCode = Integer.parseInt(userInput);      // Konvertering från sträng till int
        System.out.println("User pincode: " + pinCode);

        age++;      // age = age + 1
        age += 10;  // age = age + 10

        /*
            -> Banken - ett exempel med if-satser och input/output <-
        */

        final int userPinCode = 1234;   // Detta är pinkoden - den är final så att den inte ändras av misstag
        double amount = 1000;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välkommen till Gritgotts bank!");
        System.out.print("Var vänlig mata in din pinkod: ");
        int enteredPinCode = scanner.nextInt();
        if (enteredPinCode == userPinCode) {    // Kontrollera om användaren angav rätt pin
            System.out.println("Välkommen!");
        } else {
            System.out.println("Tyvärr, du angav fel pin!");
            System.exit(-1);              // Avsluta programmet
        }

        System.out.printf("Ditt saldo är %.2f kronor\n", amount);
        System.out.print("Hur mycket vill du ta ut? ");
        double requestedWithdrawal = scanner.nextDouble();
        if (requestedWithdrawal <= amount) {    // Kontrollera att det finns pengar på kontot
            amount -= requestedWithdrawal;      // Minska beloppet i amount
        } else {
            System.out.println("Du har inte tillräckligt med deg!");
        }
        System.out.printf("Ditt saldo är %.2f kronor\n", amount);

    }

}
