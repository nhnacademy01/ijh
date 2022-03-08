import java.util.Scanner;

public class WhileExpressions {
    public static void main(String[] args) {
       // FakeDos();
       // ForAndContinue();
        LabelGugudan();
    }

    static void FakeDos() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.print("> ");
            command = scanner.next();

            switch (command) {
                case "dir":
                    System.out.println(command + " 명령어를 실행했습니다.");
                    break;
                case "cp":
                    System.out.println(command + " 명령어를 실행했습니다.");
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("존재하지 않는 명령어입니다.");
                    break;
            }
        } while (!command.equals("quit"));
    }

    static void ForAndContinue() {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.println(i);
        }
    }

    static void LabelGugudan() {
        level: for (int i = 2; i <= 9; i++) { // level이라는 label을 달았어요.
            for (int j = 1; j <= 9; j++) {
                if (j == 6) {
//                    break level;
//                    break;
//                    continue level;
                    continue;
                }
                System.out.printf("%d * %d = %2d%n", i, j, i * j);
            }
            System.out.println("----------");
        }
    }
}
