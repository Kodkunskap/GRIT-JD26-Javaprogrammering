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

    }

}
