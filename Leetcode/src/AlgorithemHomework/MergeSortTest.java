package AlgorithemHomework;

import java.util.*;

public class MergeSortTest {
    static int[] arr = new int[]{7,6,5,4,3,2,1};
    static List<List<Integer>> ans = new LinkedList<>();
    public static void main(String[] args) {
        int seg = (int)Math.sqrt(arr.length);
        List<Integer> ls = new LinkedList<>();
        for(int i=seg*seg;i<arr.length;i++){
            ls.add(arr[i]);
        }
        sort(0,arr.length-1);
        ans.add(new LinkedList<>(ls));
        System.out.println(ans);
    }
    public static void sort(int start, int end){
        if(start>=end) return;
        int seg = (int)Math.sqrt(end-start+1);
        for(int i=0;i<seg;i++){
            sort(start+i*seg,start+(i+1)*seg-1);
        }
        List<Integer> tmp = new LinkedList<>();
        merge(arr,start,(start+end)/2,end);
        for(int i=start;i<=end;i++){
            if(start==0 && end==arr.length-1) break;
            tmp.add(arr[i]);
        }
        if(tmp.size()!=0)  ans.add(new LinkedList<>(tmp));
    }
    public static void merge(int[] A, int start, int mid, int end) {
        int[] temp = new int[A.length];// 临时数组
        int k = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            // 从两个数组中取出较小的放入临时数组
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (i <= mid) {
            temp[k++] = A[i++];
        }
        while (j <= end) {
            temp[k++] = A[j++];
        }
        // 将临时数组中的内容拷贝回原数组中 （left-right范围的内容）
        for (int m = 0; m < k; m++) {
            A[m + start] = temp[m];
        }
    }

}
