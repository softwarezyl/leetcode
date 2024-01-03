package 题库;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * <p>
 * 示例 1：
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 */
public class L605_种花问题 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i - 1 > 0 && flowerbed[i - 1] == 1) {
                i++;
            } else if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) {
                i += 2;
            } else {
                n--;
                i += 2;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        L605_种花问题 test = new L605_种花问题();

        int[] flowerbed1 = new int[]{1, 0, 0, 0, 1};
        boolean result1 = test.canPlaceFlowers(flowerbed1, 1);
        System.out.println(result1);

        int[] flowerbed2 = new int[]{1, 0, 0, 0, 1};
        boolean result2 = test.canPlaceFlowers(flowerbed2, 2);
        System.out.println(result2);

        int[] flowerbed3 = new int[]{1, 0, 0, 0, 0, 1};
        boolean result3 = test.canPlaceFlowers(flowerbed3, 2);
        System.out.println(result3);

        int[] flowerbed4 = new int[]{1, 0, 0, 0, 1, 0, 0};
        boolean result4 = test.canPlaceFlowers(flowerbed4, 2);
        System.out.println(result4);

        int[] flowerbed5 = new int[]{0,0,1,0,0};
        boolean result5 = test.canPlaceFlowers(flowerbed5, 1);
        System.out.println(result5);
    }
}
