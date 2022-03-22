// 객체 사용
public class Account {
    public static void main(String[] args) {
        Account nhnAccount = new Account(); // 새 계좌 생성
        Account naverAccount = new Account(); // 새 계좌 생성
        nhnAccount.deposit(1_000L); // 객체에 1000 입금
        nhnAccount.withdraw(500L); // 객체에 500 출금
        System.out.println("amount = " + nhnAccount.getAmount()); // 잔액조회
    }
    private long amount = 0L; // 잔액 변수

    // 입금 메소드
    public void deposit(long depositAmt) {
        this.amount += depositAmt;
    }

    // 출금 메소드
    public void withdraw(long withdraw) {
        this.amount -= withdraw;
    }

    // 잔액조회 메소드
    public long getAmount() {
        return this.amount;
    }
}

// 클래스 변수와 인스턴스 변수
class Hammer {
    String model;
    int number;
    static int weight = 2_000;

    void printHammer(String name) {
        System.out.println(name + ": " + model + ", " + number + weight);
    }

    public static void main(String[] args) {
        System.out.println("weight = " + Hammer.weight);

        Hammer h1 = new Hammer();
        h1.model = "h1";
        h1.number = 1;

        Hammer h2 = new Hammer();
        h2.model = "h2";
        h2.number = 10;

        h1.printHammer("h1");
        h2.printHammer("h2");

        h2.number = 11;
        h2.weight = 1_000;

        h1.printHammer("h1");
        h2.printHammer("h2");
    }


}