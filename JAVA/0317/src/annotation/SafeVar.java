package annotation;

import java.util.Arrays;

public class SafeVar {
    public static <T> T[] toArray(T... elements) {
        return elements; // unsafe! 애초에 varargs의 배열을 그대로 던지면 안됨.
    }
    public static <T> T[] broken(T seed) {
        T[] objs = toArray(seed, seed, seed);   // 런타임 시에 정해짐
        System.out.println("objs.class = " + objs.getClass());
        return objs;
    }
    public static void main(String[] args) {
        // Safe
        String[] strs = toArray("Welcome", "NHN", "Academy");   // 컴파일 때 String[] 으로 정해짐
        System.out.println(Arrays.toString(strs));
        System.out.println("strs.class = " + strs.getClass());

        // Unsafe
//        String[] forest = broken("Tree"); // ClassCastException
//        Integer[] busy = broken(1);       // ClassCastException
    }
}
