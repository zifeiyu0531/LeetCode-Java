package DesignPattern.ObserverPattern;

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
