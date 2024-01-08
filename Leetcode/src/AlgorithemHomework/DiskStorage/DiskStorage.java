package AlgorithemHomework.DiskStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DiskStorage {
    public static void main(String[] args) throws IOException {
        File file = new File("src/AlgorithemHomework/DiskStorage/Input.txt");
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
        int[] arr = ls.get(1);
        int len = ls.get(0)[0];
        int sum = 0;
        for(int i:arr){
            sum+=i;
        }
        double[] darr = new double[len];
        for(int i=0;i<len;i++){
            darr[i] = (double) arr[i]/(double) sum;
        }
        Arrays.sort(darr);
        double tans = 0.0;
        int left = 1;
        int right = 1;
        int mid = darr.length/2;
        double[] dist = new double[darr.length];
        dist[mid] = darr[darr.length-1];
        int cnt = 0;
        for(int i=darr.length-2;i>=0;i--){
            if(cnt == 0) dist[mid-left++] = darr[i];
            else if(cnt == 1) dist[mid+right++] = darr[i];
            else if(cnt == 2) dist[mid+right++] = darr[i];
            else if(cnt == 3) dist[mid-left++] = darr[i];
            cnt++;
            if(cnt == 4) cnt = 0;
        }
        System.out.println(Arrays.toString(dist));
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                tans+=dist[i] * dist[j] * Math.abs(i-j);
            }
        }
        String ans = new String("");
        File ofile = new File("src/AlgorithemHomework/DiskStorage/Output.txt");
        ofile.createNewFile();
        FileWriter fileWriter = new FileWriter(ofile);
        fileWriter.write(ans+tans);
        fileWriter.flush();
        fileWriter.close();
    }
}
