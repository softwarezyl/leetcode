package 题库;

public class L275_H指数II {

    public int hIndex(int[] citations) {
        int hVal = 0;
        int n = citations.length - 1;

        while (n >= 0 && citations[n] > hVal) {
            hVal++;
            n--;
        }
        return hVal;
    }

    // TODO 二分法

}
