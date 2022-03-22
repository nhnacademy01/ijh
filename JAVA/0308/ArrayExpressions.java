import java.util.Random;

public class ArrayExpressions {
    public static void main(String[] args) {
        //SumAvg();
        //TenUnderSearch();
        DotArt();
    }

    static void ArrayDefault() {
        byte[] bytes = new byte[1];
        short[] shorts = new short[1];
        int[] ints = new int[1];
        long[] longs = new long[1];
        float[] floats = new float[1];
        double[] doubles = new double[1];
        char[] chars = new char[1];
        boolean[] booleans = new boolean[1];
        String[] strings = new String[1];

        System.out.println("bytes[0] = " + bytes[0]);
        System.out.println("shorts[0] = " + shorts[0]);
        System.out.println("ints[0] = " + ints[0]);
        System.out.println("longs[0] = " + longs[0]);
        System.out.println("floats[0] = " + floats[0]);
        System.out.println("doubles[0] = " + doubles[0]);
        System.out.println("chars[0] = " + chars[0]);
        System.out.println("booleans[0] = " + booleans[0]);
        System.out.println("strings[0] = " + strings[0]);
    }

    static void SumAvg() {
        int sum = 0;
        float avg = 0.0f;

        int[] scores = {90, 75, 62, 80, 100};

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        avg = (float) sum / scores.length;

        System.out.println("sum = " + sum);
        System.out.println("avg = " + avg);
    }

    static void BubbleSort() {
        int[] numbers = new int[10];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(20) + 1;
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    static void TenUnderSearch() {
        int[] numbers = new int[100];
        Random random = new Random();
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(20) + 1;
            if (numbers[i] <= 10) {
                count++;
            }
        }

        System.out.printf("10이하인 수는 %d개 입니다.", count);
    }

    static void DotArt() {
        final int size = 40;
        boolean[][] canvas = new boolean[size][size];
        Random random = new Random();

        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = random.nextBoolean();
            }
        }
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                System.out.print(canvas[i][j] ? "*" : " ");
            }
            System.out.println();
        }
    }
}
