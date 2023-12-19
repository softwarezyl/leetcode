package 题库;

public class L1901_寻找峰值II {

    public int[] findPeakGrid(int[][] mat) {
        int left = 0;
        int right = mat.length - 1;
        while (left < right) {
            int i = (left + right) / 2;
            int j = this.maxOfRow(mat[i]);
            if (mat[i][j] > mat[i + 1][j]) {
                right = i;
            } else {
                left = i + 1;
            }
        }
        return new int[]{left, this.maxOfRow(mat[left])};
    }

    private int maxOfRow(int[] arr) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[idx]) {
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        L1901_寻找峰值II test = new L1901_寻找峰值II();

        int[][] arr = new int[][]{{2, 3, 4, 5}, {1, 2, 1, 6}, {10, 9, 8, 7}, {11, 1, 2, 1}, {12, 13, 14, 15}};
        int[] result = test.findPeakGrid(arr);
        System.out.println("result " + result[0] + " " + result[1]);
    }

}
