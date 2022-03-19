package generic;

import java.util.Stack;

abstract class AnimalCage {
    public static void main(String[] args) {
        Cage<Dog> dogCage = new Cage<>();
        dogCage.add(new Dog());
        System.out.println(dogCage.get());

        Cage<Cat> catCage = new Cage<>();
        catCage.add(new Cat());
        System.out.println(catCage.get());
        // catCage.add(new Dog());  // 컴파일 오류
        // Cage<String> stringCage = new Cage<>(); // 컴파일 오류

        Cage<Animal> animalCage = new Cage<>();
        animalCage.add(new Dog());  // Dog도 가능하고,
        animalCage.add(new Cat());  // Cat도 가능
        System.out.println(animalCage.get());
        System.out.println(animalCage.get());
    }
    public abstract void cry();
}
class Dog extends Animal {
    @Override
    public void cry() {
        System.out.println("Woof!");
    }
}
class Cat extends Animal {
    @Override
    public void cry() {
        System.out.println("Nyan~");
    }
}
class Cage<T extends Animal> {  // Bounded Type Parameter
    private Stack<T> animals = new Stack<>();

    public void add(T animal) {
        animals.push(animal);
    }

    public T get() {
        return animals.pop();
    }
}
abstract class Animal {
    public abstract void cry();
}