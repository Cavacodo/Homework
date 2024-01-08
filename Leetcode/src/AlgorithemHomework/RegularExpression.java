package AlgorithemHomework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RegularExpression {
    static List<String> ans = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        File f = new File("src/Input3.txt");
        Scanner sc = new Scanner(f);
        List<String> exec = new LinkedList<>();
        List<String> non_exec = new LinkedList<>();
        while(sc.hasNext()){
            String[] tmp = sc.nextLine().split(" ");
            if(tmp[1].equals("+")){
                exec.add(tmp[0]);
            }
            else if(tmp[1].equals("-")){
                non_exec.add(tmp[0]);
            }
        }
        int[] used = new int[exec.size()];
        backtracking(exec,non_exec,used,"*");
        System.out.println(ans);
        String tmp = ans.get(0);
        for(int i=1;i<ans.size();i++){
            if(tmp.length()>ans.get(i).length()){
                tmp = ans.get(i);
            }
        }
        int sum = 0;
        int head=0;
        int tail=0;
        for(int i=0;i<exec.size();i++){
            if(exec.get(i).contains(tmp)) sum++;
            if(exec.get(i).substring(0,tmp.length()).equals(tmp)) head++;
            else if ((exec.get(i).length()-tmp.length()-1)>=0 && exec.get(i).substring(exec.get(i).length()-tmp.length()-1,exec.get(i).length()).equals(tmp)) tail++;
        }
        if(head!=exec.size() && tail!=exec.size()) tmp="*"+tmp+"*";
        if(head==exec.size() && tail!=exec.size()) tmp=tmp+"*";
        if(head!=exec.size() && tail==exec.size()) tmp="*"+tmp;
        File file = new File("src/Output3.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(sum+"");
        fileWriter.write("\r\n");
        fileWriter.write(tmp);
        fileWriter.flush();
        fileWriter.close();

    }
    private static String longestCommonSubsequence(String s1,String s2){
        if(s1.equals(s2)) return s1;
        if(s1.equals("*")) return s2;
        else if(s2.equals("*")) return s1;
        String s = new String("");
        for(int i=0;i<s1.length();i++){
            if(s2.contains(s1.charAt(i)+"")){
                s+=s1.charAt(i);
            }
        }
        return s;
    }
    private static String subSeq(String s1, String s2){
        return longestCommonSubsequence(s1,s2).length() > longestCommonSubsequence(s2,s1).length() ? longestCommonSubsequence(s2,s1) : longestCommonSubsequence(s1,s2);
    }
    private static boolean check(String target,List<String> pattern){
        if(pattern.equals("*")) return true;
        for(int i=0;i<pattern.size();i++){
            if(subSeq(pattern.get(i),target).length()!=0) return true;
        }
        return false;
    }
    private static void backtracking(List<String> exec,List<String> non_exec,int[] used,String s1){
        for(int i=0;i<exec.size();i++){
            if(used[i] == 1) continue;
            used[i] = 1;
            String s = subSeq(exec.get(i),s1);
            s=deOverlap(s,non_exec);
            if(s.length()!=0) ans.add(s);
            backtracking(exec,non_exec,used,s);
            used[i] = 0;
        }
    }
    private static String deOverlap(String s,List<String> non_exec){
            for(int i=0;i<s.length();i++){
                if(check(s.charAt(i)+"",non_exec)){
                    StringBuilder sb = new StringBuilder(s);
                    sb.deleteCharAt(i);
                    s = sb.toString();
                }
            }
        return s;
    }
}
