public class PrimitiveTypes {
    public static void main(String[] args) {
        PrimitiveTypes types = new PrimitiveTypes();
        types.bytes();
    }

    public  void bytes()
    {
        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;

        System.out.println("min byte = " + minByte);
        System.out.println("max byte = " + maxByte);

        int minByteMinus1 = (int) (minByte - 1);
        int maxBytePlus1 = (int) (maxByte + 1);

        System.out.println("min byte - 1 = " + minByteMinus1);
        System.out.println("max byte + 1 = " + maxBytePlus1);
    }

    public void defaultValues() {
    }
}
