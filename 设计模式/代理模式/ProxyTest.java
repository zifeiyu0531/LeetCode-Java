package 设计模式.代理模式;

public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("1.jpg");

        image.display();
    }
}
