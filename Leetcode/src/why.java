

import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class why {


    public static void main(String[] args) {
        Map<int[],Boolean> map = new HashMap<>();
        int[] used = {0,0,0};
        map.put(used,true);
        used[0] = 1;
        map.put(used,true);
        for(var v : map.keySet()) System.out.println(Arrays.toString(v));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> set = new HashSet<>();
        for(int[] t : prerequisites){
            set.add(t[0]);
            set.add(t[1]);
        }
        int n = set.size();
        Deque<Integer> dq = new LinkedList<>();
        int[] inDegree = new int[n];
        int cnt = 0;
        for(int[] t : prerequisites){
            inDegree[t[1]]++;
        }
        for(int i=0;i<n;i++){
            if(inDegree[i] == 0) dq.addLast(i);
        }
        System.out.println(Arrays.toString(prerequisites[0]));
        while(!dq.isEmpty()){
            int tmp = dq.removeFirst();
            cnt++;
            for(int[] t : prerequisites){
                if(t[0] == tmp){
                    inDegree[t[1]]--;
                    System.out.println(inDegree[t[1]]);
                    if(inDegree[t[1]] == 0){
                        cnt++;
                    }
                }
            }
        }
        if(cnt != n) return false;
        return cnt<=numCourses ? true : false;

    }

}

