import java.util.*;

class Solution {

    public void sort(Character[] array){
        Arrays.sort(array, new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2){
                return o1 - o2;
            }
        });
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        Character[] array = {'c', 'd', 'a', 'f', 'b', 'e'};
        solution.sort(array);
        System.out.println(Arrays.toString(array));
    }
}