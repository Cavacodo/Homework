package DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;
public class minHeap {
    //优先队列实现：
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //默认最小堆
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1,i2)->i2.compareTo(i1)); //lamda表达式，左大于右

    public static void main(String[] args) {
        maxHeap.offer(1);
        maxHeap.offer(2);
        maxHeap.offer(5);
        maxHeap.offer(4);
        System.out.println(maxHeap.poll());
    }
}
