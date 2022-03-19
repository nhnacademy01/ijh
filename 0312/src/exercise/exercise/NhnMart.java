package exercise.exercise;

import java.util.Scanner;

class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        mart.foodStand.getFoodStandInformation(); // 식품매대 정보
        System.out.print("\nNHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요. ex) 양파 2 계란 3\n>");
        BuyList buyList = inputBuyListFromShell();
        Customer jordan = new Customer(buyList);

        jordan.bring(mart.provideBasket());       // 장바구니를 챙긴다.
        jordan.pickFoods(mart.getFoodStand());    // 식품을 담는다.

        Counter counter = new Counter(jordan);    // 고객이 카운터에가서 계산한다 (고객정보를 담아감 ex)장바구니 등등)
        jordan.payTox(counter); // 카운터에서 계산한다.
    }

    private static BuyList inputBuyListFromShell() {
        // Scanner에서 buyList 만들기
        Scanner scanner = new Scanner(System.in);
        BuyList buyList = new BuyList();
        String[] inputBuyList = scanner.nextLine().split(" ");

        // buyList에 Shell에서 입력받은 목록 추가
        for (int i = 0; i < inputBuyList.length; i+=2) {
            buyList.add(new BuyList.Item(inputBuyList[i], Integer.parseInt(inputBuyList[i+1])));
        }
        return buyList;
    }
}

public class NhnMart {
    final FoodStand foodStand = new FoodStand();
    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        foodStand.add(new Food("양파", 1_000, 2));
        foodStand.add(new Food("계란", 5_000, 5));
        foodStand.add(new Food("파", 500,10));
        foodStand.add(new Food("사과", 2_000,20));
    }

    public Basket provideBasket() {
        return new Basket();
    }

    public FoodStand getFoodStand() {
        return foodStand;
    }

    public void giveCoupon(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("원하시는 쿠폰종류를 선택해주세요 (10%쿠폰: 1, 1000원쿠폰: 2)");
        int number = scanner.nextInt();
        if(number == 1)
            customer.persentDisCountCoupon++;
        else if (number == 2)
            customer.moneyDisCountCoupon++;
        System.out.println("쿠폰추가가 완료되었습니다.");
    }
}
