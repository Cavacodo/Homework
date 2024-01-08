package AlgorithemHomework;

/**
 * 模拟乘法
 */
public class Simulation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //non-static method should be instanced before called in static method
        System.out.println(solution.multiply("123","456"));
    }
}
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ans = new int[len2+len1];
        for(int i=len1-1;i>=0;i--){
            int a = num1.charAt(i)-'0';
            for(int j=len2-1;j>=0;j--){
                int b = num2.charAt(j)-'0';
                ans[i+j+1] += a*b;
            }
        }
        for(int i=ans.length-1;i>0;i--){
            ans[i-1] += ans[i]/10;
            ans[i] %= 10;
        }
        String s = "";
        for(int i=0;i<ans.length;i++){
            if(ans[i] == 0 && i == 0) continue;
            s += ans[i];
        }
        return s;
    }
}
