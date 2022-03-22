public class ForExpressions {
    public static void main(String[] args) {
        Gugudan();
        //RepeatFor();
        // printAtoZ
//        for(int i =65; i<=70; i++){
//            printAtoZ(i);
//        }
    }

    public static void PrintDaysInMonth(int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println(month + " has 31 days.");
                break;
            case 4: case 6: case 9: case 11:
                System.out.println(month + " has 30 days.");
                break;
            case 2:
                System.out.println(month + " has 28 or 29 days.");
                break;
            default:
                System.out.println(month + " is not a month.");
                break;
        }
    }

    public static void PrintAtoZ(int ascii){
        char ch = (char)ascii;
        System.out.println(ch);
    }

    public static void RepeatFor() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Gugudan() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %2d%n", i, j, i * j);
            }
            System.out.println("---------------");
        }
    }
}
