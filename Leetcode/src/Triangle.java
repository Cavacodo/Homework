import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = new String[3];
        int[] vals = new int[3];
        for(int i=0;i<3;i++){
            strs[i] = sc.next();
            System.out.println("输入为:"+strs[i]);
            if(stringCheck(strs[i])){
                vals[i] = Integer.valueOf(strs[i]);
            }
            else{
                System.out.println("Integer Only, Negative Is Not Allowed");
                break;
            }
        }
        sc.close();
        identify(vals[0],vals[1],vals[2]);
    }
    public static void identify(int a,int b,int c){
        if(a>100 || a<1 ||b>100 || b<1 || c>100 || c<1){
            System.out.println("Invalid Input");
            return;
        }
        if(a+b>c && b+c>a && c+a>b){
            if(a==b && b==c){
                System.out.println("Isosceles");
            } else if (a==b || b==c || c==a) {
                System.out.println("Equilateral");
            }
            else{
                System.out.println("Scalene");
            }
        }
        else{
            System.out.println("NotATriangle");
        }
    }
    public static boolean stringCheck(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>'9' || s.charAt(i)<'0'){
                return false;
            }
        }
        return true;
    }
}
