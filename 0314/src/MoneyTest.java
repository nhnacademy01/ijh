public class MoneyTest {
    long amount;
    String currency;

    public MoneyTest(long amount, String currency) {
        if (amount < 0L) {   // 돈이 음수가 될 수 있나?
            throw new IllegalArgumentException("Money is not negative. " + amount);
        }
        this.amount = amount;
        this.currency = currency;
    }

    public static void main(String[] args) {
        MoneyTest moneyTest = new MoneyTest(-1_000, "WON");
    }
}
