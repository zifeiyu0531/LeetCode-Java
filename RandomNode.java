public class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public RandomNode(int _val, RandomNode _next, RandomNode _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}