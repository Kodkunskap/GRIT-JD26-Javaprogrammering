import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Samlingstyper {

    public static void main() {
        Scanner scanner = new Scanner(System.in);

        //javaArrays(scanner);
        //javaArrayList();
        javaHashMap();
    }

    private static void javaArrays(Scanner scanner) {

        /*

            En array är en lista av lika datatyper

            Vi definierar en array med hjälp av []. Den kan då initieras med
            hjälp av {}-parenteser.

         */

        //int[] lottoRad = { 12, 19, 1, 31, 16, 8, 8 };
        int[] lottoRad = new int[7];
        System.out.println("Ange 7 lottonummer: ");
        for (int i = 0; i < lottoRad.length; i++) {
            lottoRad[i] = scanner.nextInt();
        }

        boolean giltigLottoRad = true;
        for(
                int index = 0;
                index < lottoRad.length;
                index++
        ) {
            // Kontrollera en plats i array:n - är den i intervallet
            if(lottoRad[index] < 1 || lottoRad[index] > 31) {
                giltigLottoRad = false;
                break;  // Om lottoraden är felaktig avbryt for-loopen.
            }
        }

        for(int index = 0; index < lottoRad.length - 1; index++) {
            // Spara värdet på plats index i en tillfälligvariabel (för läsbarhetens skull)
            final int numberToCompare = lottoRad[index];
            for( int k = index + 1; k < lottoRad.length; k++) {  // Loopa över resten av arrayn
                if(numberToCompare == lottoRad[k]) {
                    giltigLottoRad = false;
                    break;
                }
            }
        }

        if(giltigLottoRad) {
            System.out.println("Lottoraden är giltig!");
        } else {
            System.out.println("Lottoraden är ogiltig");
        }

    }

    private static void javaArrayList() {

        // Skapar en ny tom lista
        ArrayList<String> bilar = new ArrayList<String>();

        // Stoppa in strängar i listan
        bilar.add("Suzuki");        // 0
        bilar.add("Landrover");     // 1
        bilar.add("Tesla");         // 2
        bilar.add("Volvo");         // 3

        System.out.println("På plats 4 med index 3 har vi: " + bilar.get(3) );

        bilar.set(1, "Hummer");     // Landrover -> Hummer

        bilar.remove(2);      // Raderar postion 2 (Tesla)

        // for(int i=0; i < bilar.size(); i++)
        for(String s : bilar) {
            System.out.println(s + ": " + s.length());
        }

        bilar.clear();      // Töm listan

        /*
                CRUD
                ----
                Create  : .add()
                Read    : .get()
                Update  : .set()
                Delete  : .remove()
         */
    }

    private static void javaHashMap() {

        /*
            Kan tolkas som en tabell

            Landskod | Land
            -------------------------
            46       | Sverige
            45       | Danmark
            35       | Italien
            999      | Fulköpien

         */
        HashMap<Integer, String> countries = new HashMap<Integer, String>();
        countries.put(46, "Sverige");
        countries.put(45, "Danmark");
        countries.put(35, "Italien");
        countries.put(999, "Fulköpien");
        System.out.println(countries);

        Integer input = 999;
        System.out.println(
                "Det ringde från " + input + " samtalet kommer från " +
                        countries.get(input)    // Ge mig landet kopplat till "input"
        );

        countries.remove(35);
        System.out.println(countries);

    }

}
