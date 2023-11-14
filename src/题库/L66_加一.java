package 题库;

public class L66_加一 {

    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        L66_加一 test = new L66_加一();

        int[] result = test.plusOne(new int[]{9});
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
