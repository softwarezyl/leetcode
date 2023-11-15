package 题库;

public class L896_单调数列 {

    public boolean isMonotonic(int[] nums) {
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                inc = false;
            }
            if (nums[i] < nums[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }

    public static void main(String[] args) {
        L896_单调数列 test = new L896_单调数列();

        System.out.println(test.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(test.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(test.isMonotonic(new int[]{1, 3, 2}));
        System.out.println(test.isMonotonic(new int[]{5, 3, 2, 4, 1}));
    }
}
