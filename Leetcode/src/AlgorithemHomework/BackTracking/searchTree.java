package AlgorithemHomework.BackTracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class searchTree {
    public static void main(String[] args) throws IOException {
        searchTree searchTree = new searchTree();
        List<int[]> ls = searchTree.FileLoad();
        int[] stock = ls.get(1);
        int res = ls.get(0)[1];
        int len = stock.length;
        int[] used = new int[len];
        Solution solution = new Solution();
        solution.dfs(stock,used,res);
        int r = res - solution.minRes;
        searchTree.FileOutput(r + "");
    }
    public List<int[]> FileLoad() throws FileNotFoundException {
        File file = new File("src/AlgorithemHomework/BackTracking/Input.txt");
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
        return ls;
    }
    public void FileOutput(String ans) throws IOException {
        File ofile = new File("src/AlgorithemHomework/BackTracking/Output.txt");
        ofile.createNewFile();
        FileWriter fileWriter = new FileWriter(ofile);
        fileWriter.write(ans);
        fileWriter.flush();
        fileWriter.close();
    }

}
class Solution {
    protected int minRes = Integer.MAX_VALUE;
    public void dfs(int[] stock,int[] used,int res){
        if(res < 0){
            return;
        }
        for(int i=0;i<stock.length;i++){
            if(used[i] != 1){
                res -= stock[i];
                if(res >= 0) minRes = Math.min(minRes,res);
                used[i] = 1;
                dfs(stock,used,res);
                used[i] = 0;
                res += stock[i];
            }
        }
    }
}

