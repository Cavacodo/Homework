package AlgorithemHomework;

import java.util.PriorityQueue;

/**
 * 优先队列解决K路归并
 */
public class KWayMergeSort {
    public static void main(String[] args) {

    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class SolutionN{
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode l1, ListNode l2)->(l1.val - l2.val));
        ListNode ans = new ListNode();
        for(ListNode i : lists){
            while(i != null){
                queue.offer(i);
                i = i.next;
            }
        }
        ListNode cur = ans;
        while(!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return ans.next;
    }
}
