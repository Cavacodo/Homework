package AlgorithemHomework;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] t = {8,6,4,2,1,5};
        String c = "Abc,";
        System.out.println(c.toLowerCase());
    }
    public void sort(int[] A,int start,int end){
        if(start < end){
            int position = partition(A,start,end);
            sort(A,start,position-1);
            sort(A,position+1,end);
        }
    }

    /**
     *
     * 其实partition函数才是关键
     * 采用快慢指针的方式，让i作为快指针，每当走到的数比pivot小，就pointer++，pointer的值代表了几个数比pivot小
     * 当遇到比pivot小的值交换过来，防止原位置的值比pivot大造成不必要
     * 遍历完成之后pointer左侧的值都比pivot小，同时pointer右侧都比pivot大，pointer就是最终位置
     * 把pivot换过来
     *
     */
    public int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                swap(array,pointer,i);
                System.out.println("pointer is " + pointer + " i is " + i);
                pointer++;
            }
            System.out.println(Arrays.toString(array));
        }
        swap(array,high,pointer);
        return pointer;
    }

    public void swap(int[] A,int a,int b){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
