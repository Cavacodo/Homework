package AlgorithemHomework.BestQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BestQueue {
    public static void main(String[] args) throws IOException {
        File file = new File("src/AlgorithemHomework/BestQueue/Input.txt");
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
        int[] queue = ls.get(0);
        Arrays.sort(queue);
        int totalWaitTime = 0;
        for(int i=0;i<queue.length;i++){
            totalWaitTime += queue[i]*(queue.length-i);
        }
        File ofile = new File("src/AlgorithemHomework/BestQueue/Output.txt");
        ofile.createNewFile();
        FileWriter fileWriter = new FileWriter(ofile);
        fileWriter.write(totalWaitTime/queue.length+"");
        fileWriter.flush();
        fileWriter.close();
    }
}
