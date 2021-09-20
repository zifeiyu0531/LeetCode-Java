package DesignPattern.ObserverPattern;

public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal state:" + Integer.toOctalString(subject.getState()));
    }
}
