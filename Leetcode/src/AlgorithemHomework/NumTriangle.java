package AlgorithemHomework;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NumTriangle {
    public static void main(String[] args) throws IOException {
        File f = new File("src/Input1.txt");
        Scanner sc = new Scanner(f);
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
        for(int i=ls.size()-2;i>=0;i--){
            maxVal(ls.get(i+1),ls.get(i));
        }
        int ans = ls.get(0)[0];
        File file = new File("src/Output1.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(ans+"");
        fileWriter.flush();
        fileWriter.close();
    }
    private static void maxVal(int[] arr,int[] target){
        int[] ans = new int[arr.length-1];
        for(int i=0;i<arr.length-1;i++){
            ans[i] = Math.max(arr[i],arr[i+1]);
            target[i] += ans[i];
        }
    }
}
