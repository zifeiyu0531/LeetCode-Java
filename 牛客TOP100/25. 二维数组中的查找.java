package 牛客TOP100;

class Solution {
    public boolean Find(int target, int[][] array) {
        int i = array.length - 1, j = 0;
        while (i >= 0 && j < array[0].length) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
