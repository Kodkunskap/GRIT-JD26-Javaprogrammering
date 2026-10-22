/*
 Det finns mycket funktionalitet i Java - men för att få tillgång till den
 behöver vi göra den tillgänglig för vår klass. Det gör vi med import. Imports lägger
 man alltid i toppen på filen.
 */
import java.util.Scanner;

/*
    Detta är en kommentar i Java - den kan täcka flera rader och det som skrivs här
    ignoreras av kompilatorn.

    All kod i Java skapas i klasser - en klass innehåller egenskaper/attribut och
    metoder/funktioner.
 */

// En kommentar kan också skrivas så här och då är det bara denna raden som är
// ut kommenterad.
public class Main {

    /*
    main() är en speciell "funktion" som är den som körs när
    programmet startar.
    */
    public static void main() {

        System.out.println("Hello, World!");

        /*
        För att spara information använder vi variabler

        typ namn;

        typ namn = värde;

        */

        int age;                    // Heltal
        String name = "Martin";     // Sträng
        Double points = 0.0;        // Flyttal (decimaltal)

        // Variabler kan vi använda på olika sätt
        System.out.println("Hej " + name);

        /*
            För att läsa input från användaren använder vi Scanner

            Java är skiftläges känsligt dvs det spelar roll om man använder stora eller
            små bokstäver
         */
        System.out.println("Hur gammal är du?");
        Scanner scanner = new Scanner(System.in);   // "new" skapar en ny instans av klassen Scanner
        age = scanner.nextInt();    // Scanner har flera olika metoder beroende på om man vill läsa en sträng, int eller ett decimaltal

        System.out.println("Du är " + age + " år gammal!");

    }

}
