import java.util.Scanner;

public class SwitchExpressions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("월을 입력하세요: ");
        int month = scanner.nextInt();

        switchConvertIf(month);
    }

    public static void switchConvertIf(int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            System.out.println(month + " has 31 days.");
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println(month + " has 30 days.");
        } else if (month == 2) {
            System.out.println(month + " has 28 or 29 days.");
        } else {
            System.out.println(month + " is not a month.");
        }
    }

    public static void printDaysInMonth(int month) {
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
}

class MemberGrade {
    public static void main(String[] args) {
        int memberGrade = 2;

        switch (memberGrade) {
            case 3:
                grantVip();
            case 2:
                grantGold();
            case 1:
                grantSilver();
                break;
            default:
                noBenefit();
        }
    }

    private static void grantVip() {
        System.out.println("Issue VIP coupons");
    }

    private static void grantGold() {
        System.out.println("Issue Gold coupons");
    }

    private static void grantSilver() {
        System.out.println("Issue Silver coupons");
    }

    private static void noBenefit() {
        System.out.println("no coupons");
    }
}

class WhoIsHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("이름을 입력하세요: ");
        String name = scanner.next();

        switch (name) {
            case "name":
                System.out.println("홍길동");
                break;
            case "nickname":
                System.out.println("의적");
                break;
            case "organization":
                System.out.println("활빈당");
                break;
            default:
                System.out.println("출력할 수 없는 입력값이에요.");
        }
    }
}