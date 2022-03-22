public class CharTypes {
    public static void main(String[] args) {
        char a = 'a';
        String b = "cc";
        char c = '홍';
        char e = '\u2374';
        char f = (char) -1;
        char g = 65_535;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        System.out.println("g = " + g);
    }
}
