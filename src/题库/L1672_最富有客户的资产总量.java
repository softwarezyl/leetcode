package 题库;

public class L1672_最富有客户的资产总量 {

    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;

        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, sum);
        }
        return maxWealth;
    }
}
