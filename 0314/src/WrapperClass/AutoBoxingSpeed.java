package WrapperClass;

public class AutoBoxingSpeed {
    static final int COUNT = 1000;
    public static void main(String[] args) {
        speedPrimitiveType();
        speedPrimitiveTypeAndWrapperClass();
        speedWrapperClass();
    }

    static void speedPrimitiveType() {
        int[] nums = new int[COUNT];    // !
        for (int i = 0; i < COUNT; i++) {
            nums[i] = i;
        }
        long startTime = System.nanoTime();
        int sum = 0;    // !
        for (int i = 0; i < COUNT; i++) {
            sum += nums[i];
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("speedPrimitiveType");
        System.out.printf("%10d%n", estimatedTime);
        System.out.println("---------------------------------");
    }

    private static void speedPrimitiveTypeAndWrapperClass() {
        Integer[] nums = new Integer[COUNT];    // !
        for (int i = 0; i < COUNT; i++) {
            nums[i] = i;
        }
        long startTime = System.nanoTime();
        int sum = 0;    // !
        for (int i = 0; i < COUNT; i++) {
            sum += nums[i];
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("speedPrimitiveTypeAndWrapperClass");
        System.out.printf("%10d%n", estimatedTime);
        System.out.println("---------------------------------");
    }

    private static void speedWrapperClass() {
        Integer[] nums = new Integer[COUNT];    // !
        for (int i = 0; i < COUNT; i++) {
            nums[i] = i;
        }
        long startTime = System.nanoTime();
        Integer sum = 0;    // !
        for (int i = 0; i < COUNT; i++) {
            sum += nums[i];
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("speedWrapperClass");
        System.out.printf("%10d%n", estimatedTime);
        System.out.println("---------------------------------");
    }
}
