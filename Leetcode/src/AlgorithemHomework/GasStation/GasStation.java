package AlgorithemHomework.GasStation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GasStation {
    public static void main(String[] args) throws IOException {
        File file = new File("src/AlgorithemHomework/GasStation/Input.txt");
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
        int tank = ls.get(0)[0];
        int[] map = ls.get(1);
        int sum = 0;
        int stations = 0;
        for(int i=0;i<map.length;i++){
            if(map[i] > tank){
                stations = -1;
                break;
            }
            sum+=map[i];
            if(sum > tank){
                stations++;
                sum = map[i];
            }
        }
        String ans = new String("");
        if(stations == -1) ans += "No Solution";
        else ans+=stations;
        File ofile = new File("src/AlgorithemHomework/GasStation/Output.txt");
        ofile.createNewFile();
        FileWriter fileWriter = new FileWriter(ofile);
        fileWriter.write(ans);
        fileWriter.flush();
        fileWriter.close();
    }
}
