package ToString;

public class ToString {
    public static void main(String[] args) {
        Person2 p1 = new Person2("hong", 180);
        System.out.println(p1.toString());
    }
}
class Person2 {
    String name;
    int height;
    public Person2(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}