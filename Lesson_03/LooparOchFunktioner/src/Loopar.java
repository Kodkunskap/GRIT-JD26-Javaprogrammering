import java.util.Random;
import java.util.Scanner;

public class Loopar {

    public static void main() {

        /*

                for - loop

         */

        /*

            for(
                init;       -   körs en gång, innan loopen startar
                condition;  -   kontrolleras när loopen skall starta - om sant, startar loopen
                count       -   anropas när loopen kört (efter varje loop)
           ) {

                    // Här skriver vi koden som skall loopa

           }

         */
        int sum = 0;
        for(
                int counter = 1;
                counter <= 10;
                counter++
        ) {
            sum = sum + counter;    // sum += counter;
        }
        System.out.println("Summan av talen mellan 1 och 10 blir " + sum);


        sum = 0;
        for( int i = 2; i <= 10; i+=2 ){
            // if(i % 2 == 0)
            sum += i;
        }
        System.out.println("Summan av talen mellan 1 och 10 blir " + sum);


        /*

            while() och do-while() loopar

            while(condition) {}

            do {} while(condition);

         */

        int goal = 1337;      // Summan vi letar efter
        int counter = 0;    // Detta är antalet loopar (additioner vi böhöver göra)
        sum = 0;            // Slutgiltiga summan

        while(sum <= goal) {
            sum = sum + counter;
            counter++;
        }

        System.out.println("Det tog " + counter + " loopar innan vi hittade summan " + sum);


        /*
            I kroppen av en loop dvs innom { } kan man avbryta eller hoppa till nästa
            loop/iteration med hjälpav:

            break;      - avbryt loopen
            continue;   - hoppa till nästa loop (kontrollera condition)


         */


        int maxTal = max(5, 1);
        System.out.println("Det största talet av 5 och 1 är: " + maxTal);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Vad är vårt start tal? ");
        int startNumber = scanner.nextInt();
        System.out.print("Vad är vårt slut tal? ");
        int endNumber = scanner.nextInt();
        countAndPrintSum(startNumber, endNumber);       // anropa vår egen funktion

        /*

            Exempel på hur man kan slumpa tal mellan 1 och 9 (bound = 10 är inte med i intervallet)

            Random random = new Random();
            int slumpatHeltal = random.nextInt(1, 10);
            double slumpatFlyttal = random.nextDouble(10.0);
        */
    }

    public static int max(int tal1, int tal2) {

        if (tal1 > tal2) {
            return tal1;
        }

        return tal2;
    }

    public static void countAndPrintSum(int start, int end) {

        int sum = 0;

        for (
                int counter = start;
                counter <= end;
                counter++
        ) {
            sum += counter;
        }

        System.out.printf(
                "Summan av talen mellan %d och %d blir %d\n",
                start, end, sum
        );
    }

}
