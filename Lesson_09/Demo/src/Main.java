import utils.TextUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    public void run() {

        boolean running = true;
        while(running) {
            System.out.println();
            System.out.println("==== Lektion 9 ====");
            System.out.println(" 1. Package Demo");
            System.out.println(" 2. String Demo");
            System.out.println(" 3. Date and Time Demo");
            System.out.println(" 4. Try-Catch Demo");
            System.out.println(" 5. Input Demo");
            System.out.println(" 6. Throw exception Demo");

            System.out.println(" 0. Avsluta");
            System.out.print("Välj > ");

            String val = scanner.nextLine();

            switch(val) {
                case "1" -> packageDemo();
                case "2" -> stringDemo();
                case "3" -> dateAndTimeDemo();
                case "4" -> tryCatchDemo1();
                case "5" -> inputDemo();
                case "6" -> throwMethods();

                case "0" -> running = false;
                default -> System.out.println("Ogiltigt val, försök igen!");
            }
        }

    }

    public static void throwMethods() {

        try {
            setAge(-5);
        } catch (IllegalArgumentException ex) {
            System.out.println("Fel: " + ex.getMessage());
        }

    }

    private static int age;

    private static void setAge(int newAge) {
        if (newAge < 0) {
            throw new IllegalArgumentException("Åldern kan inte vara negativ");
        }
        age = newAge;
    }

    private void inputDemo() {
        int tal = 0;
        boolean running = true;

        do {
            System.out.print("Ange ett tal mellan 1 och 10: ");
            String temp = scanner.nextLine();

            try {
                tal = Integer.parseInt(temp);
            } catch (NumberFormatException e) {
                System.out.println("Du måste ange ett giltigt tal!");
            }

            if (tal >= 1 && tal <= 10) {

                running = false;
            }

        } while(running);

    }

    private void tryCatchDemo1() {
        int[] numbers = { 0, 1, 2, 3 };
        System.out.print("Ange en position i vår array> ");
        String indexStr = scanner.nextLine();
        try {
            int index = Integer.parseInt(indexStr);
            int value = numbers[index];
            System.out.println("Värdet på position " + index + " är " + value);

            //System.out.println(TextUtils.shout(null)); // Denna kommer alltid att generera (kasta) ett undantag
        } catch(NumberFormatException e) {
            System.out.println("Du måste ange ett tal!");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Talet måste ligga mellan 0 och " + (numbers.length-1));
        } finally {
            System.out.println("Nu är try-catchen färdig!");
        }
    }


    private void dateAndTimeDemo() {

        LocalDate today = LocalDate.now();
        LocalDate christmasEve = LocalDate.of(today.getYear(), 12, 24);
        long dateToChristmasEve = ChronoUnit.DAYS.between(today, christmasEve);
        //System.out.printf("Det är i dag %d dagar kvar till julafton!\n", dateToChristmasEve);

        LocalTime timeRightNow = LocalTime.now();
        LocalTime kalleAnka = LocalTime.of(15, 5, 0);
        long minutes = ChronoUnit.MINUTES.between(timeRightNow, kalleAnka);
        System.out.printf("Det är i dag %d dagar och %d minuter kvar till julafton!\n", dateToChristmasEve, minutes);

    }


    private void stringDemo() {
        String a = "Hej";
        System.out.print("Skriv Hej: ");
        String b = scanner.nextLine();

        System.out.printf("%s = %s? %b\n", a, b, (a == b));
        System.out.printf("\"%s\".equals(\"%s\")? %b\n", a, b, a.equals(b));
    }

    private void packageDemo() {
        System.out.print("Please enter your message: ");
        String message = scanner.nextLine();
        //System.out.println("Your message is: " + utils.TextUtils.shout(message));
        System.out.println("Your message is: " + TextUtils.shout(message));
    }

    public static void main() {
        try {
            new Main().run();
        } catch (Exception e) {
            System.out.println("Något gick fel i programmet!");
            System.out.println("Felet var: " + e.getMessage());
        }
    }
}
