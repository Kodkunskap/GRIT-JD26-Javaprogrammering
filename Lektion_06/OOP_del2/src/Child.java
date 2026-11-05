public class Child extends Parent {

    int y;

    Child(int x, int y) {
        super(x);
        this.y = y;
        System.out.printf(
                "This is the constructor of the Child-class (x: %d, y: %d)\n",
                x, y
        );
    }

    Child() {
        super(0);
        y = 0;
    }


    public void myMethod() {
        super.myMethod();
        y = y + 2;
        System.out.println("This is the method of the Child-class");
    }

}
