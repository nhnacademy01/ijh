package WrapperClass;

public class Wrapper {
    public static void main(String[] args) {
        Boolean b = Boolean.valueOf(true);
        Character c = Character.valueOf('c');
        Byte by = Byte.valueOf(Byte.MAX_VALUE);
        Short s = Short.valueOf(Short.MAX_VALUE);
        Integer i = Integer.valueOf(128);
        Long l = Long.valueOf(Long.MAX_VALUE);
        Float f = Float.valueOf(Float.MAX_VALUE);
        Double d = Double.valueOf(Double.MIN_VALUE);

        Integer a = 10;

        System.out.println(a);
    }
}
