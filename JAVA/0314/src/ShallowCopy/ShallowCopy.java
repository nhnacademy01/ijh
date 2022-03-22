package ShallowCopy;

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        ScMoney amount = new ScMoney(10_000, "WON");
        ScAccount account = new ScAccount(1, amount, "hong");
        ScAccount replica = account.clone(); // shallow copy
        amount.value = 20_000;

        System.out.println(account);
        System.out.println(replica);
    }
}
class ScAccount implements Cloneable {
    int type;
    ScMoney amount;
    String depositor;
    public ScAccount(int type, ScMoney amount, String depositor) {
        this.type = type;
        this.amount = amount;
        this.depositor = depositor;
    }
    @Override
    protected ScAccount clone() throws CloneNotSupportedException {
        return (ScAccount) super.clone();
    }
    @Override
    public String toString() {
        return "ScAccount{" +
                "type=" + type +
                ", amount=" + amount +
                ", depositor='" + depositor + '\'' +
                '}';
    }
}
class ScMoney {
    long value;
    String currency;
    public ScMoney(long value, String currency) {
        this.value = value;
        this.currency = currency;
    }
    @Override
    public String toString() {
        return "ScMoney{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}