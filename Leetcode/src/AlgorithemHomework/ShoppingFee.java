package AlgorithemHomework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// TODO: 2023/12/12 实验报告
public class ShoppingFee {
    static int minFee = 0;
    static HashMap<Integer,Integer> buyList = new LinkedHashMap<>();
    static HashMap<Integer,Integer> priceList = new LinkedHashMap<>();
    static HashMap<int[][],Integer> discount = new LinkedHashMap<>();
    static List<int[][]> offerDetail = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        File f = new File("src/Input4.txt");
        Scanner sc = new Scanner(f);
        List<int[]> wishList = new LinkedList<>();
        while(sc.hasNext()){
            String[] tmp = sc.nextLine().split(" ");
            int[] it = new int[tmp.length];
            for(int i=0;i<tmp.length;i++){
                it[i] = Integer.parseInt(tmp[i]);
            }
            wishList.add(it);
        }
        int[] needBuy = new int[wishList.get(0)[0]];
        wishList.remove(0);
        File file = new File("src/offer.txt");
        Scanner scanner = new Scanner(file);
        List<int[]> offerList = new LinkedList<>();
        while(scanner.hasNext()){
            String[] tmp = scanner.nextLine().split(" ");
            int[] it = new int[tmp.length];
            for(int i=0;i<tmp.length;i++){
                it[i] = Integer.parseInt(tmp[i]);
            }
            offerList.add(it);
        }
        offerList.remove(0);

        for(int i=0;i<wishList.size();i++){
            needBuy[i] = wishList.get(i)[0];
            buyList.put(wishList.get(i)[0],wishList.get(i)[1]);
            priceList.put(wishList.get(i)[0],wishList.get(i)[2]);
        }
        for(int i=0;i<offerList.size();i++){
            int[][] tmp = new int[offerList.get(i)[0]][2];
            int row = 0;
            for(int j=1;j<offerList.get(i).length-1 && row<offerList.get(i)[0];j++){
                if(j%2!=0){
                    tmp[row][0] = offerList.get(i)[j];
                }
                else{
                    tmp[row][1] = offerList.get(i)[j];
                }
                if(j%2==0) row++;
            }
            offerDetail.add(tmp);
            discount.put(tmp,offerList.get(i)[offerList.get(i).length-1]);
        }
        cheapestPrice(needBuy);
        File file1 = new File("src/Output4.txt");
        file1.createNewFile();
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.write(minFee+"");
        fileWriter.flush();
        fileWriter.close();


    }
    private static void cheapestPrice(int[] needBuy){
        if(isZero(needBuy)) return;
        else{
            minFee+=offerCombo(needBuy);
            for(int i=0;i<needBuy.length;i++){
                if(buyList.get(needBuy[i])>0){
                    minFee+=buyList.get(needBuy[i])*priceList.get(needBuy[i]);
                }
            }
        }
    }
    private static int offerCombo(int[] needBuy){
        int val = 0;
        for(int i=offerDetail.size()-1;i>=0;i--){
            int[][] tmp = offerDetail.get(i);
            int cnt = 0;
            for(int j=0;j<tmp.length;j++){
                if(buyList.get(tmp[j][0])>=tmp[j][1]){
                    cnt++;
                }
            }
            if(cnt == tmp.length){
                for(int j=0;j<tmp.length;j++){
                    buyList.put(tmp[j][0],buyList.get(tmp[j][0])-tmp[j][1]);
                }
                val += discount.get(tmp);
            }
        }
        return val;
    }
    private static boolean isZero(int[] arr){
        int cnt = 0;
        for(int i:arr){
            cnt+=i;
        }
        return cnt==0;
    }


}
