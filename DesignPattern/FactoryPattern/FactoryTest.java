package DesignPattern.FactoryPattern;

public class FactoryTest {
    public static void main(String[] args){
        ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("RECTANGLE");
        shape1.draw();

        Shape shape2 = factory.getShape("SQUARE");
        shape2.draw();

        Shape shape3 = factory.getShape("CIRCLE");
        shape3.draw();
    }
}
