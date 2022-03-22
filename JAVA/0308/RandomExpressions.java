import java.util.Random;
import java.util.Scanner;

public class RandomExpressions {
    public static void main(String[] args) {
        // RandomGenerator();

        GuessNumber();
    }

    public static void RandomGenerator() {
        Random random = new Random();
        int result = random.nextInt();
        System.out.println("Random number: " + result);

        for (int i = 0; i < 20; i++) {
            int result10 = random.nextInt(10) + 1;  // 1~10
            System.out.println("Random number(1~10): " + result10);
        }
    }

    public static void GuessNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int inputnum;
        int result20 = random.nextInt(20) + 1;  // 1~20

        do {
            System.out.printf("%d//숫자를 맞춰주세요. (1~20): ", result20);
            inputnum = scanner.nextInt();

            if(inputnum > result20) {
                System.out.println("더 작은 값이에요.");
            } else if (inputnum < result20) {
                System.out.println("더 큰 값이에요.");
            } else {
                System.out.printf("%d 정답입니다.", inputnum);
                break;
            }
        } while(true);
    }
}
