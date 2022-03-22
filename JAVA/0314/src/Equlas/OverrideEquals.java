package Equlas;

public class OverrideEquals {
    public static void main(String[] args) {
        Car c1 = new Car(10);
        Car c2 = new Car(10);

        System.out.println("c1 == c2?: " + (c1 == c2));
        System.out.println("c1 equals c2?: " + c1.equals(c2));
    }
}

class Car {
    int speed;

    public Car(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return this.speed == car.speed;
    }
}