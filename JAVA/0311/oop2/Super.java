package oop.oop2;

public class Super {
    public static void main(String[] args) {
        SuperCar2 scar = new SuperCar2();
    }
}

class Vehicle2 {
    public Vehicle2() {
        super();
        System.out.println("Vhicle 생성");
    }
}

class Car2 extends Vehicle2 {
    public Car2() {
        super();
        System.out.println("Car 생성");
    }

}

class SuperCar2 extends Car2 {
    // class 내에 아무것도 만들지 않아도, 컴파일러가 자동으로 super() 메소드와 같이 기본생성자를 만들어 준다
//    public SuperCar2() {
//        super();
//        System.out.println("SuperCar생성");
//    }
}