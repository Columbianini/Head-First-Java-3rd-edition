package Chapter8;

public class MyCheck {
    public static void main(String[] args) {
        // According to the result, 
        // subclass could still access to base class's private member through inherited public getter or setter function

        MyBaseClass myClass = new MySubClass(); // MySubClass myClass = new MySubClass;
        myClass.setNumber(2);
        System.out.println(myClass.getNumber());
    }
}
