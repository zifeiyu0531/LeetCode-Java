import java.util.*;

class Solution {
    public static final Queue<Integer> queue = new LinkedList<>();
    public static final int MAX_COUNT = 10;
    public static int id = 0;

    public void producer() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (queue) {
                if (queue.size() == MAX_COUNT) {
                    try {
                        queue.wait();
                        System.out.println("缓冲区已满，暂停生产");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                queue.offer(id++);
                System.out.println("生产者生产商品：" + id);
                queue.notifyAll();
            }
        }
    }

    public void consumer() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (queue) {
                if (queue.size() == 0) {
                    try {
                        queue.wait();
                        System.out.println("缓冲区已空，暂停消费");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                queue.poll();
                System.out.println("消费者消费商品：" + id);
                queue.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        new Thread(() -> {
            solution.producer();
        }).start();

        new Thread(() -> {
            solution.consumer();
        }).start();
    }
}