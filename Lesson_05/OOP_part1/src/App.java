public class App {

    public static void main() {

        Car fiat = new Car(
                "Suzuki",
                "Samurai",
                "black",
                1986,
                90
        );

        fiat.accelerate(20);
        fiat.accelerate(30);
        fiat.accelerate(50);
        System.out.println("Fiat is now driving in " + fiat.currentSpeed + "km/h");

        fiat.brake(5);
        System.out.println("Fiat is now driving in " + fiat.currentSpeed + "km/h");

        fiat.honk();

        Car volvo = new Car(
            "Volvo",
            "XC90",
            "silver gray",
            2018,
            180
        );

        volvo.accelerate(75);
        volvo.brake(50);
        System.out.println("Volvo is now driving in " + volvo.currentSpeed + "km/h");

        /**
         *      User - example
         */
        User pelle = new User("Pelle");
        User anna = new User("Anna");
        System.out.println(pelle.toString());
        System.out.println(anna.toString());


        anna.follow(pelle);
        System.out.println(pelle.toString());
        System.out.println(anna.toString());

        System.out.println("Pelle är mer populär än Anna: " + pelle.isPopularThan(anna));
        System.out.println("Anna är mer poplulär än Pelle: " + anna.isPopularThan(pelle));

    }

}
