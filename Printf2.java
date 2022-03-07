public class Printf2 {
    public static void main(String[] args) {
        String url = "nhnacademy.com";

        float f = 10.f;
        double d = 1.23456789d;

        System.out.println("[12345678901234567890]");
        System.out.printf("[%s]%n", url);
        System.out.printf("[%20s]%n", url);
        System.out.printf("[%-20s]%n", url);
        System.out.printf("[.8%s]%n", url);

        System.out.printf("f = %f, %e, %g%n", f,f,f);
        System.out.printf("d = %f%n", d);
        System.out.printf("d = %15.10f%n", d);
    }
}
