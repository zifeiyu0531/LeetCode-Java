import java.util.*;
class Solution {
    public static void main(String[] args) {
        Stack<Integer> list = new Stack<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        System.out.println(Arrays.toString(array));
    }
}