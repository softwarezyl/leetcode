package 题库;

/*
    给你两个下标从 0 开始的整数数组 player1 和 player2 ，分别表示玩家 1 和玩家 2 击中的瓶数。
    保龄球比赛由 n 轮组成，每轮的瓶数恰好为 10 。

    假设玩家在第 i 轮中击中 xi 个瓶子。玩家第 i 轮的价值为：

    如果玩家在该轮的前两轮的任何一轮中击中了 10 个瓶子，则为 2xi 。
    否则，为 xi 。
    玩家的得分是其 n 轮价值的总和。

    返回
    如果玩家 1 的得分高于玩家 2 的得分，则为 1 ；
    如果玩家 2 的得分高于玩家 1 的得分，则为 2 ；
    如果平局，则为 0 。
 */
public class L2660_保龄球游戏的获胜者 {

    // 方法1: 通过标志位来判断是否double
    public int isWinner(int[] player1, int[] player2) {
        int player1Sum = this.calculateSum(player1);
        int player2Sum = this.calculateSum(player2);

        System.out.println(player1Sum + " " + player2Sum);

        if (player1Sum > player2Sum) {
            return 1;
        }
        if (player2Sum > player1Sum) {
            return 2;
        }
        return 0;
    }

    private int calculateSum(int[] player) {
        boolean needDouble = false;
        int tenIdx = 0;
        int sum = 0;

        for (int i = 0; i < player.length; i++) {
            if (i > tenIdx + 2) {
                needDouble = false;
            }

            if (needDouble) {
                sum += (player[i] * 2);
            } else {
                sum += player[i];
            }

            // 维护needDouble 为true或者false
            if (player[i] == 10) {
                needDouble = true;
                tenIdx = i;
            }
        }
        return sum;
    }

    // 方法2: 正常通过下标判断
    public int isWinner2(int[] player1, int[] player2) {
        int p1 = score(player1);
        int p2 = score(player2);

        return p1 == p2 ? 0 : p1 > p2 ? 1 : 2;
    }

    private int score(int[] player) {
        int sum = 0;
        for (int i = 0; i < player.length; i++) {
            if ((i > 0 && player[i - 1] == 10) || i > 1 && player[i - 2] == 10) {
                sum += 2 * player[i];
            } else {
                sum += player[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        L2660_保龄球游戏的获胜者 test = new L2660_保龄球游戏的获胜者();

        int result = test.isWinner(new int[]{4, 10, 7, 9}, new int[]{6, 5, 2, 3});
        System.out.println(result);

        int result2 = test.isWinner(new int[]{3, 5, 7, 6}, new int[]{8, 10, 10, 2});
        System.out.println(result2);

        int result3 = test.isWinner(new int[]{9, 7, 10, 7}, new int[]{10, 2, 4, 10});
        System.out.println(result3);
    }
}
