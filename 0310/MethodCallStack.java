public class MethodCallStack {
    public static void main(String[] args) {
        System.out.println("main 시작");  // (1)
        driveCar();
        System.out.println("main 끝");   // (7)
    }

    static void driveCar() {
        System.out.println("    driveCar 시작");  // (2)
        putOnSeatbelt();
        // (4)
        pushGasPedal();
        System.out.println("    driveCar 끝");   // (6)
    }

    static void putOnSeatbelt() {
        System.out.println("        putOnSeatbelt 호출"); // (3)
    }

    static void pushGasPedal() {
        System.out.println("        pushGasPedal 호출");  // (5)
    }
}

class NumberWrapper {
    int value; // 기본형 primited type

    public static void main(String[] args) {
        NumberWrapper n = new NumberWrapper();
        n.value = 1;
        changeTo(n.value, 2);
        System.out.println("changed n.value = " + n.value);
        changeTo(n, 2);
        System.out.println("changed n = " + n.value);
    }

    static void changeTo(int value, int newValue) {
        value = newValue;
    }

    static void changeTo(NumberWrapper n, int newValue) {
        n.value = newValue;
    }
}

class Factorial {
    public static void main(String[] args) {
        //System.out.println(factorial(20));
        System.out.println(factorial2(5));

    }

    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
    static int factorial2(int n) {
        while (true) {
            if(n==1) {
                break;
            }
            n *= n-1;
        }
        return n;
    }
}