//package oop.oop2;
//
//import java.util.Random;
//
//public class Shape {
//    public static void main(String[] args) {
//        Random random = new Random();
//        Square s = new Square(1,1,20);
//        System.out.println(s.getArea());
//
//        Triangle triangle = new Triangle(5,4);
//        System.out.println(triangle.getArea());
//
//        Shape[] shapes = new Shape[] {
//                new Square(Point.random(), 10),
//                new Triangle(Point.random(), 10, 20),
//                new Rectangle(Point.random(), 10, 20) };
//        for(Shape s : shapes) {
//            printShape(s);
//        }
//    }
//
//    public int getArea(){
//        return 0;
//    }
//}
//
//class Triangle extends Shape {
//    private final int width;
//    private final int height;
//
//    public Triangle(int width, int height) {
//        this.width = width;
//        this.height = height;
//    }
//
//    public int getArea() {
//        return this.width * this.height / 2;
//    }
//}
//
//class Rectangle extends Shape {
//    Point position;
//    int width;
//}
//
//class Square extends Shape {
//    Point position;
//    int width;
//
//    public Square(int x, int y, int width) {
//        this.position = new Point(x,y);
//        this.width = width;
//    }
//
//    public int getArea() {
//        return width * width;
//    }
//}
//
//class Point {
//    int X;
//    int Y;
//
//    public Point(int x, int y) {
//        this.X=x;
//        this.Y=y;
//    }
//}