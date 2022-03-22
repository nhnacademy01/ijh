package Equlas;

public class StringEquals {
    public static void main(String[] args) {
        String s1 = "nhn-academy";
        String s2 = "nhn-academy";
        String ns1 = new String("nhn-academy");
        String ns2 = new String("nhn-academy");

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == ns1: " + (s1 == ns1));
        System.out.println("ns1 == ns2: " + (ns1 == ns2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equals(ns1): " + s1.equals(ns1));
        System.out.println("ns1.equals(ns2): " + ns1.equals(ns2));
    }
}