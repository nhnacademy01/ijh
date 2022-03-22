package oop.oop2;

public class Animal2 {
    public void cry() {
        // Nothing
    }
}

class Dog2 extends Animal2 {
    @Override
    public void cry() {
        System.out.println("Woof! Woof!");
    }
}

class Cat2 extends Animal2 {
    @Override
    public void cry() {
        System.out.println("Meow~");
    }
}