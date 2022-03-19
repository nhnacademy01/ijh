package Exception;

public class MultiException {
    public static void main(String[] args) {
        someMethod(new String[]{"NHN","1"});
        someMethod(new String[]{});
        someMethod(new String[]{"NHN","Academy"});
    }
    static void someMethod(String[] strs) {
        int num = 0;
        try {
            num = Integer.parseInt(strs[1]);
        } catch (ArrayIndexOutOfBoundsException aie) {
            System.out.println("catch ArrayIndexOutOfBoundsException" + aie);
        } catch (NumberFormatException nfe) {
            System.out.println("catch NumberFormatException" + nfe);
        }
        System.out.println("num = " + num);
    }


}
