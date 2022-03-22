package oop.oop4;

class Super {
    public static void main(String[] args) {
        Car car = new Car();
        car.speed = 10;
        System.out.println("speed = " + car.getSpeed());
    }
}
class Vehicle {
    int speed;
    int getSpeed() {
        return speed;   // this.speed
    }
}
class Car {
    int speed;

    public int getSpeed() {
        return this.speed;
    }
}