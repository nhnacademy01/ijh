package TryCatch;

public class Money {
    long amount;
    String currency;

    public static void main(String[] args) {
        Money money;

        try {
            money = new Money(-1000,"WON");
        } catch (InvalidMoneyException e) {
            e.printStackTrace();
        }
    }

    public Money(long amount, String currency) {
        if (amount < 0L) {   // 돈이 음수가 될 수 있나?
            throw new InvalidMoneyException("Money is not negative. " + amount);
        }
        if (!isSupportedCurrency(currency)) {   // 지원되지 않는 통화의 경우.
            throw new InvalidMoneyException("Not supported currency. " + currency);
        }
        this.amount = amount;
        this.currency = currency;
    }

    private boolean isSupportedCurrency(String currency) {
        return "WON".equals(currency) || "DOLLAR".equals(currency);
    }

    private static class InvalidMoneyException extends RuntimeException {
        public InvalidMoneyException(String s) {
            System.out.println(s);
        }
    }
}

