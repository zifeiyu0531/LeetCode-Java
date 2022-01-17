package 牛客TOP100;

import java.util.*;

class Solution {
    /**
     * 
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int diff = target - num;
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff) + 1, i + 1 };
            } else {
                map.put(num, i);
            }
        }
        return new int[] { -1, -1 };
    }
}