package 牛客TOP100;

class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int a = m - 1, b = n - 1, last = m + n - 1;
        while (b >= 0) {
            if (a < 0 || B[b] >= A[a]) {
                A[last] = B[b];
                b--;
            } else {
                A[last] = A[a];
                A[a] = 0;
                a--;
            }
            last--;
        }
    }
}