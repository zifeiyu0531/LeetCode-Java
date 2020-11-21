package 设计模式.观察者模式;

public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex state:" + Integer.toHexString(subject.getState()));
    }
}
