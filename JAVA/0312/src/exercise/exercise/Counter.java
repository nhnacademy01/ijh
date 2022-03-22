package exercise.exercise;

public class Counter {
    // 고객의 장바구니
    final Customer customer;

    public Counter(Customer customer) {
        this.customer = customer;
    }

    public int getPrice() {
        int totalPrice=0;

        for (int i = 0; i < customer.getBasket().getFoods().size(); i++) {
            totalPrice += customer.getBasket().getFoods().get(i).getFoodCount() * customer.getBasket().getFoods().get(i).getPrice();
        }
        return totalPrice;
    }
}
