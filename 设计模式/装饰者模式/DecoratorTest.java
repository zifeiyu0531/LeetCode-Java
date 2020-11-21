package 设计模式.装饰者模式;

public class DecoratorTest {
    public static void main(String[] args) {
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
    
        redCircle.draw();
        redRectangle.draw();
    }
}
