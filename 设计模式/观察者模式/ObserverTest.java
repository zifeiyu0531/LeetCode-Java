package 设计模式.观察者模式;

public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        subject.setState(10);
        subject.setState(20);
    }
}
