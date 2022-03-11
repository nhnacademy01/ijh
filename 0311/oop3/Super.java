package oop.oop3;
public class Super {
    public static void main(String[] args) {
        Car car = new Car(); // Car클래스의 객체 생성
        car.drive(); // drive라는 기능은 car라는 class의 고유메소드
        car.speedUp(); // car
        System.out.println("car speed: " + car.getSpeed());

        SuperCar scar = new SuperCar();
        scar.drive();
        scar.speedUp();
        System.out.println("scar speed: " + scar.getSpeed());
       // scar.boosterOn();
        System.out.println("scar speed: " + scar.getSpeed());
    }
}
class Vehicle {
    private int speed;

    void drive() {
        System.out.println("Drive Vehicle");
    }

    void speedUp() {
        speed++;
    }

    int getSpeed() {
        return this.speed;
    }

}

class Car extends Vehicle {
    @Override
    void speedUp() {
        super.speedUp();
        super.speedUp();
    }
}

class SuperCar extends Car {
    public static final int MAX_SPEED = 300;
    @Override
    void speedUp() {
        super.speedUp();
        super.speedUp();
    }
    void boosterOn() {
        //
        // speed = MAX_SPEED;
    }
}
