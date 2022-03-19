package exercise.exercise;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FoodStand {
    final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    public void subtract(ArrayList<Food> foods) {
        // 인자로 받은 foods를 빼줘야함
        for (int i = 0; i < this.foods.size(); i++) {
            for (int j = 0; j < foods.size(); j++) {
                // 매대가 가지고있는 foods의 이름이랑 인자로 받은 foods의 이름이랑 같다면
                if(this.foods.get(i).getName().equals(foods.get(j).getName())) {
                    this.foods.get(i).foodCount -= foods.get(j).foodCount; // 매대foods의 갯수를 장바구니집어간만큼 빼줌
                    // 매대의 품목갯수가 0이되면
                    if(this.foods.get(i).foodCount <= 0) {
                        this.foods.remove(i);
                    }
                }
            }
        }

    }

    public void getFoodStandInformation() {
        System.out.println("[ 식품매대 ]");
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(foods.get(i).toString());
        }
    }
}
