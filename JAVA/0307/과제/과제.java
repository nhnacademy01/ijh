import java.util.Scanner;

class unicode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("input: ");
        char c = scanner.next().charAt(0);
        System.out.printf("\\u"+Integer.toHexString(c));
    }
}

class NameCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("input name: ");
        String name = scanner.nextLine();
        System.out.printf("input email: ");
        String email = scanner.nextLine();
        System.out.printf("input mobile: ");
        String mobile = scanner.nextLine();

        System.out.println("OK");
        System.out.printf("  name:%20s%n", name);
        System.out.printf(" email:%20s%n", email);
        System.out.printf("mobile:%20s%n", mobile);
    }
}

class ConvertInchCm{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("cm으로 변경할 inch를 입력하세요.");
        int inch = scanner.nextInt();
        System.out.printf("%d inch는 %.2f cm입니다.%n", inch, inch * 2.54f);

        System.out.println("inch로 변경할 cm를 입력하세요.");
        int cm = scanner.nextInt();
        System.out.printf("%d cm는 %.2f inch입니다.%n", cm, cm / 2.54f);
    }
}

class SwapAdvanced {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println("a: " + a + ", b: " + b);

        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("After swap. a: " + a + ", b: " + b);
    }
}