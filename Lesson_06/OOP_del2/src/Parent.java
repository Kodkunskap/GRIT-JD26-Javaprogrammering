public class Parent {

    public int x;

    Parent(int x) {
        this.x = x;
        System.out.println("This is the constructor of the Parent-class (x: " + x + ")");
    }

    public void myMethod() {
        x++;
        System.out.println("This is the method of the Parent-class (x: " + x + ")");
    }

}
