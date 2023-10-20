package 题库;

public class L2525_根据规则将箱子分类 {

    public String categorizeBox(int length, int width, int height, int mass) {
        int maxL = Math.max(length, Math.max(width, height));
        long volume = 1L * length * width * height;

        String result = "";

        // Bulky
        if(maxL >= 10000 || volume >= 1000000000){
            result = "Bulky";
        }

        // Heavy
        if(mass >= 100){
            if(result.equals("Bulky")){
                result  = "Both";
            }else{
                result = "Heavy";
            }
        }
        if(result.equals("")){
            return "Neither";
        }
        return result;
    }

    public static void main(String[] args) {
        L2525_根据规则将箱子分类 test = new L2525_根据规则将箱子分类();
        String result = test.categorizeBox(2909, 3968, 3272, 727);
        System.out.println(result);
    }
}
