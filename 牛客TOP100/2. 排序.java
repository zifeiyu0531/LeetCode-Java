package 牛客TOP100;

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     * 
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return;
        }
        int left = leftIdx, right = rightIdx;
        int key = arr[left];
        while (left < right) {
            while (left < right && key <= arr[right]) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && key >= arr[left]) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, leftIdx, left - 1);
        quickSort(arr, left + 1, rightIdx);
    }
}
