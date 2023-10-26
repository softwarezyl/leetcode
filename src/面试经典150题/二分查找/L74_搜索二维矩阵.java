package 面试经典150题.二分查找;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * <p>
 * 每行中的整数从左到右按非递减顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 */
public class L74_搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int len = matrix.length * matrix[0].length;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int idx1 = mid / matrix[0].length;
            int idx2 = mid % matrix[0].length;

            if (matrix[idx1][idx2] == target) {
                return true;
            } else if (matrix[idx1][idx2] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L74_搜索二维矩阵 test = new L74_搜索二维矩阵();

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean result = test.searchMatrix(matrix, target);
        System.out.println(result);

        int[][] matrix2 = {{1}};
        int target2 = 2;
        boolean result2 = test.searchMatrix(matrix2, target2);
        System.out.println(result2);
    }
}
