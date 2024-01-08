package AlgorithemHomework;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Cruiser {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Input2.txt");
        Scanner sc = new Scanner(file);
        List<int[]> ls = new LinkedList<>();
        while(sc.hasNext()){
            String[] tmp = sc.nextLine().split(" ");
            int[] it = new int[tmp.length];
            for(int i=0;i<tmp.length;i++){
                it[i] = Integer.parseInt(tmp[i]);
            }
            ls.add(it);
        }
        ls.remove(0);
        int[] dp = new int[ls.size()];
        for(int i=dp.length-1;i>=0;i--){
            cheapestWay(dp,i,ls);
        }
        File ofile = new File("src/Output2.txt");
        ofile.createNewFile();
        FileWriter fileWriter = new FileWriter(ofile);
        fileWriter.write(dp[0]+"");
        fileWriter.flush();
        fileWriter.close();
    }
    private static void cheapestWay(int[] dp,int cur,List<int[]> list){
        int len = list.get(cur).length;
        dp[cur] = list.get(cur)[len-1];
        for(int i=0;i<dp.length-cur-1;i++){
            dp[cur] = Math.min(dp[cur],list.get(cur)[i]+dp[cur+i+1]);
        }
    }
}
