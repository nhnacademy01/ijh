package money_package;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();

        accountList.add(new Account(new Money(1000, Money.Currency.WON),1.0f));
        accountList.add(new Account(new Money(30000, Money.Currency.WON),2.5f));
        accountList.add(new Account(new Money(500, Money.Currency.DOLLAR),10f));
        //accountList.add(new Account(new Money(-1000, Money.Currency.DOLLAR),2.5f)); // 음수돈
        //accountList.add(new Account(new Money(1000, Money.Currency.BITCOIN),2.5f)); // 지원하지않는 화폐

        for (Account account : accountList) {
            account.payInterest();
        }
    }
}

class Account {
    private Money balance;            // 잔액
    private final float interestRate; // 이자율

    public Account(Money money, float interestRate) {
        this.balance = money;
        this.interestRate = interestRate;
    }

    // 입금
    public void deposit(Money amount) {
        // 제약 조건
        this.balance = this.balance.add(amount);
    }

    // 출금
    public Money withdrawa(Money amount) {
        // 제약 조건
        this.balance = this.balance.subtract(amount);
        return this.balance;
    }

    // 이자 지급
    Money payInterest() {
        Money interest = calculateInterest();

        this.balance = this.balance.add(interest);
        return this.balance;
    }

    // 이자 계산
    private Money calculateInterest() {
        return new Money((int)Math.round(balance.getAmount()*interestRate*0.01),balance.getCurrency());
    }

    // 잔액조회
    public Money getBalance() {
        return balance;
    }
}

class Money {
    private long amount;
    private final Currency currency;

    public long getAmount() {
        return this.amount;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public Money(int amount, Currency currency) {
        if(amount < 0){
            System.out.println("예외발생! 음수 돈은 없음!");
            System.exit(0);
        }

        if(currency != Currency.WON && currency != Currency.DOLLAR) {
            System.out.println("예외발생! 달러랑 원만선택가능!");
            System.exit(0);
        }
        this.amount = amount;
        this.currency = currency;
    }

    public enum Currency {
        WON, DOLLAR, EN, BITCOIN
    }

    public String toString() {
        return amount + " " + currency;
    }

    public Money add(Money amount) {
        //todo currency 비교하기
        if(this.currency != amount.currency) {
            System.out.println("예외발생! 통화양식이 맞지않음!");
            return null;
        }
        amount.amount += this.amount;
        return amount;
    }

    public Money subtract(Money amount) {
        amount.amount -= this.amount;
        return amount;
    }
}