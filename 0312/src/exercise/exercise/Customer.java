package exercise.exercise;

import java.util.ArrayList;

public class Customer {
    private final BuyList buyList; // 고객의 구매 목록
    private Basket basket;         // 고객의 장바구니
    public int money = 20_000;     // 잔고
    public int persentDisCountCoupon = 1; // 10% 할인쿠폰
    public int moneyDisCountCoupon = 1;   // 1000원 할인쿠폰

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니를 챙김
    public void bring(Basket basket) {
        this.basket = basket;
    }

    public void pickFoods(FoodStand foodStand) {
        // 고객바스켓안에 foodStand - buylist 를 넣으면 됨
        ArrayList<Food> foods = new ArrayList<>();

        for (int i = 0; i < buyList.items.size(); i++) {
            for (int j = 0; j < foodStand.foods.size(); j++) {
                // 구매목록리스트의 이름과 매대에있는 4가지 품목중 이름과 같다면
                if(buyList.getName()[i].equals(foodStand.foods.get(j).getName())) {
                    // 구매목록에있는 품목갯수가 매대에 있는 품목갯수보다 많으면
                    if(buyList.getAmount()[i] > foodStand.foods.get(j).foodCount) {
                        System.out.println("진열된 상품의 갯수보다 더 많이 담으실 수 없습니다.");
                        return;
                    }
                    else
                        foods.add(new Food(buyList.getName()[i], foodStand.foods.get(j).getPrice(),buyList.getAmount()[i]));
                }
            }
        }
        basket.add(foods); // 조던 basket에 foods를 추가해줌
        foodStand.subtract(foods); // 매대에서는 빼줘야함
    }

    public Basket getBasket() {
        return this.basket;
    }

    public void payTox(Counter counter) {
        int price = counter.getPrice();
        if(counter.customer.getBasket().getFoods().size() == 0) {
            System.out.println("장바구니에 상품이 없습니다");
            return;
        }

        System.out.println("총 가격은 " + price + "원 입니다.");
        if (counter.customer.persentDisCountCoupon > 0) {
            if(counter.customer.moneyDisCountCoupon > 0) {
                price -= counter.getPrice() / 10;
                price -= 1000;
                counter.customer.persentDisCountCoupon--;
                counter.customer.moneyDisCountCoupon--;
            } else if (counter.customer.moneyDisCountCoupon == 0) {
                price = counter.getPrice() / 10;
                counter.customer.persentDisCountCoupon--;
            }
        } else if (counter.customer.persentDisCountCoupon == 0) {
            if(counter.customer.moneyDisCountCoupon > 0) {
                price -= 1000;
                counter.customer.moneyDisCountCoupon--;
            } else if (counter.customer.moneyDisCountCoupon == 0) {
                System.out.println("할인 가능한 쿠폰이 없습니다.");
            }
        }
        if(price < 0) {
            System.out.println("0원 이하로는 할인하실수 없습니다.");
            return;
        }
        System.out.println("할인 후 " + price + "원 입니다. 고맙습니다.");
        if(counter.customer.money - price < 0) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        System.out.println("고객님 결재 후 잔액: " + (counter.customer.money - price));
    }
}
