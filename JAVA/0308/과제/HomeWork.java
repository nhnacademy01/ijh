import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {

    }
}

// 1. TicTacToe
class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3]; // 판 배열

        // 알 초기화
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }

        do {
            System.out.print("사용자 턴(x y): ");
            int userX = scanner.nextInt();
            int userY = scanner.nextInt();
            if (board[userX][userY] == ' ') {
                board[userX][userY] = 'O';
            } else {
                System.out.println("이미 놓여있는 자리입니다 다시 놓으세요.");
                continue;
            }

            DrawBoard(board);
            WinCheck(board);
            PlayComputer(board);
            DrawBoard(board);
            WinCheck(board);
        } while (true);
    }

    static void DrawBoard(char[][] board) {
        // 바둑판
        for (int i = 0; i < board.length; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }
    }

    static void PlayComputer(char[][] board) {
        Random ran = new Random();
        int comX,comY;
        System.out.println("컴퓨터 턴");

        do {
            comX = ran.nextInt(2);
            comY = ran.nextInt(2);
            if (board[comX][comY] != ' ') {
                continue;
            } else {
                board[comX][comY] = 'X';
                break;
            }
        } while (true);
    }

    static void WinCheck (char[][] board) {
        int userCount = 0, comCount=0;

        // 가로승리
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (board[i][j] == 'O') {
                    userCount++;
                } else if (board[i][j] == 'X') {
                    comCount++;
                }
            }
            if (userCount == 3) {
                System.out.println("유저가 이겼습니다!");
                System.exit(0);
            } else if (comCount == 3) {
                System.out.println("컴퓨터가 이겼습니다!");
                System.exit(0);
            }
            userCount=0;
            comCount=0;
        }

        // 세로승리
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (board[j][i] == 'O') {
                    userCount++;
                } else if (board[j][i] == 'X') {
                    comCount++;
                }
            }
            if (userCount == 3) {
                System.out.println("유저가 이겼습니다!");
                System.exit(0);
            } else if (comCount == 3) {
                System.out.println("컴퓨터가 이겼습니다!");
                System.exit(0);
            }
            userCount=0;
            comCount=0;
        }

        // 대각승리
        for (int i = 0; i <= 2; i++) {
            if (board[i][i] == 'O') {
                userCount++;
            } else if (board[i][i] == 'X') {
                comCount++;
            }
        }
        if (userCount == 3) {
            System.out.println("유저가 이겼습니다!");
            System.exit(0);
        } else if (comCount == 3) {
            System.out.println("컴퓨터가 이겼습니다!");
            System.exit(0);
        }
        userCount=0;
        comCount=0;
        for (int i = 0; i <= 2; i++) {
            if (board[i][board.length-i-1] == 'O') {
                userCount++;
            } else if (board[i][board.length-i-1] == 'X') {
                comCount++;
            }
        }
        if (userCount == 3) {
            System.out.println("유저가 이겼습니다!");
            System.exit(0);
        } else if (comCount == 3) {
            System.out.println("컴퓨터가 이겼습니다!");
            System.exit(0);
        }
    }
}

// 2. 4칙 연산기
class Calculation {
    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("어떤 연산을 하실 건가요? (+,-,*,/)");
        char operator = scanner.next().charAt(0); // 연산자 입력받음

        System.out.println("피 연산자 2수를 입력하세요.");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("올바른 연산자를 입력해주십시오.");
                return;
        }
        System.out.printf("%d %c %d = %d입니다.", num1, operator, num2, result);
    }
}

// 3. 4칙 연산 누산기
class accumulation {
    public static void main(String[] args) {
        int result = 0;
        int num1 = 0;
        int num2 = 0;
        char operator;
        Scanner scanner = new Scanner(System.in);

        System.out.println("어떤 연산을 하실 건가요? (+,-,*,/)");
        operator = scanner.next().charAt(0); // 연산자 입력받음

        System.out.println("피 연산자 2수를 입력하세요.");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        result = Calculate(num1, num2, operator);
        System.out.printf("%d %c %d = %d입니다.%n", num1, operator, num2, result);

        do {
            System.out.println("어떤 연산을 계속 하실건가요? (+,-,*,/)");
            operator = scanner.next().charAt(0); // 연산자 입력받음
            System.out.println("수를 입력하세요.");
            num1 = result;
            num2 = scanner.nextInt();
            result = Calculate(num1, num2, operator);
            System.out.printf("%d %c %d = %d입니다.%n", num1, operator, num2, result);
        } while (true);
    }

    static int Calculate(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;
        }

        return result;
    }
}

// 4. 주사위 게임
class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userCount = 0; // 유저수
        int diceCount = 0; // 주사위수

        System.out.println("참가자 수를 입력하세요.");
        userCount = scanner.nextInt();
        System.out.println("사용하실 주사위 갯수를 입력하세요.");
        diceCount = scanner.nextInt();
        int userDiceSum[] = new int[userCount]; // 유저가 돌린주사위값을 전부 합산할 배열

        PlayGame(userDiceSum,diceCount,userCount);
    }

    static void PlayGame(int userDiceSum[], int diceCount, int usercount) {
        int winnerDice=0;
        int winner = 0;
        int drawCount =0;
        Random random = new Random();
        System.out.println("주사위를 굴렸습니다.");


        // 주사위 굴리는 작업
        // user수당 dice갯수만큼(2중for문)
        for (int i = 0; i < usercount ; i++) {
            for (int j = 0; j < diceCount; j++) {
                userDiceSum[i] += random.nextInt(6)+1;
            }
        }

        winnerDice = userDiceSum[0]; // 초기값 설정
        // 주사위합산 값 비교
        for (int i = 0; i < usercount; i++) {
            if(winnerDice < userDiceSum[i]) {
                winnerDice = userDiceSum[i];
                winner = i;
            }
            for (int j = 0; j <= i; j++) {
                if(userDiceSum[i] == userDiceSum[j]) {
                    drawCount++;
                }
            }
            System.out.printf("user%d의 결과값은 %d 입니다.%n",i+1, userDiceSum[i]);
        }
        if(drawCount > usercount) {
            System.out.println("무승부 입니다.");
        } else {
            System.out.printf("승리자는 user%d 입니다!!", winner+1);
        }
    }
}

// 5. 가위바위보 게임
class RockPaperScissors {
    public static void main(String[] args) {
        int user = 0, computer = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (user == computer) {
            System.out.print("가위(1) 바위(2) 보(3): ");
            user = scanner.nextInt();
            computer = random.nextInt(3) + 1;

            switch (user) {
                case 1:
                    System.out.println("당신은 가위(1)입니다.");
                    break;
                case 2:
                    System.out.println("당신은 바위(2)입니다.");
                    break;
                case 3:
                    System.out.println("당신은 보(3)입니다.");
                    break;
            }
            switch (computer) {
                case 1:
                    System.out.println("컴퓨터는 가위(1)입니다.");
                    break;
                case 2:
                    System.out.println("컴퓨터는 바위(2)입니다.");
                    break;
                case 3:
                    System.out.println("컴퓨터는 보(3)입니다.");
                    break;
            }

            Play(user, computer);

            if (user == computer) {
                System.out.println("비겼습니다. 다시 합니다.");
            }
        }
    }

    static void Play(int user, int computer) {
        if (user > computer) {
            System.out.println("이겼습니다!");
        } else if (user < computer) {
            System.out.println("졌습니다 ㅠㅠ");
        }
    }
}

// 6. 로또번호 추첨기
class Lotto {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            lotto[i] = random.nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    i--;
                }
            }
        }

        for (int i = 0; i < lotto.length; i++) {
            System.out.print(lotto[i] + " ");
        }
    }
}

// 7. CardGame
class CardGame {
    public static void main(String[] args) {
        // 1~52
        int[][] card = {
                {1,2,3,4},
                {1,2,3,4,5,6,7,8,9,10,11,12,13}
        };
        int[] joker = {14,14}; // 53~54
        int[][] player1 = new int[2][2];
        int[][] player2 = new int[2][2];

        SelectCard(player1,player2,card,joker);

    }
    // 00 01 10 11
    static void SelectCard(int[][] player1, int[][] player2, int[][] card, int[] joker) {
        Random random = new Random();
        int tempNum;
        int[] tempCard = new int[4];
        for (int i = 0; i < tempCard.length; i++) {
            tempNum = random.nextInt(54);
            for (int j = 0; j < i; j++) {
                if(tempCard[j] == tempNum) {
                    i--;
                } else {
                    tempCard[i] = tempNum;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            player1[0][i] = random.nextInt(14);
            player2[0][i] = random.nextInt(14);

            if (player1[0][i] != 14) {
                player1[i][0] = random.nextInt(4);
            }

            if (player2[0][i] != 14) {
                player2[i][0] = random.nextInt(4);
            }
        }

    }
}