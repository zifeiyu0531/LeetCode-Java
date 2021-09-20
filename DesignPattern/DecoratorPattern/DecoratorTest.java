package DesignPattern.DecoratorPattern;

public class DecoratorTest {
    public static void main(String[] args) {
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
    
        redCircle.draw();
        redRectangle.draw();
    }
}
