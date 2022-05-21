package 牛客TOP100;

class Solution {
    public int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < array[right]) {
                right = mid;
            } else if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return array[left];
    }
}
