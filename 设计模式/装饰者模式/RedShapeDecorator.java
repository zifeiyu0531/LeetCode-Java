package 设计模式.装饰者模式;

public class RedShapeDecorator extends ShapeDecorator{
    
    public RedShapeDecorator(Shape decoratedShape){
        super(decoratedShape);
    }

    @Override
    public void draw(){
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Boder: Red");
    }
}
