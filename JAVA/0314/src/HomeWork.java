class Money {
    private long amount;
    private Currency currency;

    public enum Currency {
        WON, DOLLAR
    }

    public String toString() {
        return amount + " " + currency;
    }

    public static class InvalidMoneyException extends Throwable {
        public InvalidMoneyException(String s) {

        }
    }
}

public class HomeWork {
    private Money balance;
    private float interestRate;

    public static void main(String[] args) {
        Money money = new Money();
    }

//    // 입금
//    public Money deposit(Money amount) {
//        // 제약 조건
//        this.balance = this.balance.add(amount);
//        return this.balance;
//    }
//
//    // 출금
//    public Money withdrawal(Money amount) {
//        // 제약 조건
//        this.balance = this.balance.substract(amount);
//        return this.balance;
//    }
//
//    // 이자 지급
//    Money payInterest() {
//        Money interest = cacluateInterest();
//        this.balance = this.balance.add(interest);
//        return this.balance;
//    }
//
//    private Money cacluateInterest() {
//        // TODO
//    }

}
//class Bank {
//    List<Account> accounts = new ArrayList<>();
//
//    Account openAccount(Customer customer, Money initMoney) {
//
//    }
//
//    public void payInterestOnAllAccounts() {
//        for(Account account : accounts) {
//            account.payInterest();
//        }
//    }

//}
