package HashCode;

public class HashCode {
    public static void main(String[] args) {
        String s1 = "nhn-academy";
        String s2 = "nhn-academy";
        String ns1 = new String("nhn-academy");
        String2 s21 = new String2("nhn-academy");
        String2 s22 = new String2("nhn-academy");

        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode());
        System.out.println("ns1.hashCode(): " + ns1.hashCode());
        System.out.println("s21.hashCode(): " + s21.hashCode());
        System.out.println("s22.hashCode(): " + s22.hashCode());

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == ns1: " + (s1 == ns1));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(ns1): " + s1.equals(ns1));
        System.out.println("s21 == s22: " + (s21 == s22));
        System.out.println("s21.equals(s22): " + s21.equals(s22));
    }
}
class String2 {
    String value;
    public String2(String value) {
        this.value = value;
    }
}