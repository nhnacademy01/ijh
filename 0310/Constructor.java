public class Constructor {
    public static void main(String[] args) {
        Dog snoopy = new Dog(); // !
        Cat tom = new Cat();    // OK
    }
}

class Dog {
    public Dog() {

    }
    // 매개변수가 있는 생성자 선언
    public Dog(String name) {
    }
}

class Cat {
    // 기본 생성자 선언
    public Cat() {
    }
}

class Money {
    long amount; // 액수
    String currency; // 통화

    public Money() {
        this(0L);   // !
    }

    public Money(long amount) {
        this(amount, "WON");    // !
    }

    public Money(long amount, String currency) {
        this.amount = amount;       // !
        this.currency = currency;   // !
    }

    public Money(Money origin) {
        this.amount = origin.amount;
    }

    public static void main(String[] args) {
        Money m1 = new Money(1_000L);
        Money m2 = new Money(m1);

        System.out.println(m2.amount);
    }
}

class Money2 {
    long amount;
    String currency;

    public Money2() {
        amount = 0L;
        currency = "WON";
    }
    public Money2(long a, String c) {
        amount = a;
        currency = c;
    }
    public static void main(String[] args) {
        Money amt1 = new Money(1_000, "WON");
        Money amt2 = new Money();

        System.out.printf("amt1 = %d %s%n", amt1.amount, amt1.currency);
        System.out.printf("amt2 = %d %s%n", amt2.amount, amt2.currency);
    }
}

class Money3 {
    long amount = 0L;
    String currency = "WON";
    static int count = 0;
    // 클래스 초기화 블럭
    static {
        System.out.println("클래스 초기화");
        count++;
    }
    // 인스턴스 초기화 블럭
    {
        System.out.println("인스턴스 초기화");
        amount = 10L;
        currency = "DOLLAR";
        count++;
    }
    public Money3() {
        System.out.println("생성자");
        amount = 1L;
        currency = "GOLD";
        count++;
    }
    public static void main(String[] args) {
        System.out.println("main 실행");
        Money3 money = new Money3();
        System.out.printf("money = %d %s%n", money.amount, money.currency);
        System.out.printf("calling count = %d%n", count);
    }
}