package DesignPattern.ProxyPattern;

public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("1.jpg");

        image.display();
    }
}
