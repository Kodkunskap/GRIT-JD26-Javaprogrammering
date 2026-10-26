public class Lesson02 {

    public static void main(String[] args) {

        // EN-rads kommentar

        /*

            Block-kommentar - över flera rader

         */

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
        int pinCode = Integer.parseInt(userInput);      // Convertering från strång till int
        System.out.println("User pincode: " + pinCode);

        age++;      // age = age + 1
        age += 10;  // age = age + 10

    }

}
