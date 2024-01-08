package AlgorithemHomework;

import java.util.*;

public class Huffman {
    static HashMap<Character,String> hashMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        if(t > 26){
            System.out.println("太多辣！！！");
            return;
        }
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int[] dp = fibonacci(t);
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for(int i=0;i<t;i++){
            Node tmp = new Node(alphabet[i],dp[i]);
            queue.add(tmp);
            hashMap.put(tmp.Name,"");
        }
        while(queue.size()>1){
            Node left = queue.poll();
            Node right = queue.poll();
            Node head = new Node(' ',left.val+right.val);
            head.left = left;
            head.right = right;
            queue.offer(head);
        }
        Node root = queue.poll();
        bfs(root);
        for(int i=0;i<t;i++){
            System.out.println(alphabet[i] +" Huffman is "+ hashMap.get(alphabet[i]));
        }

    }
    public static int[] fibonacci(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        if(n == 1) return dp;
        dp[1] = 1;
        if(n > 2){
            for(int i=2;i<n;i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp;
    }
    public static void bfs(Node node){
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(node);
        while(!deque.isEmpty()){
            Node tmp = deque.poll();
            String st = hashMap.get(tmp.Name);
            if(st == null) st="";
            if(tmp.left != null){
                hashMap.put(tmp.left.Name,st+"0");
                deque.addLast(tmp.left);
            }
            if(tmp.right != null){
                hashMap.put(tmp.right.Name,st+"1");
                deque.addLast(tmp.right);
            }
        }
    }
    static class Node{
        char Name;
        Node left;
        Node right;
        int val;
        public Node(){new Node();}
        public Node(int val){this.val = val;}
        public Node(char c,int val){
            this.Name = c;
            this.val = val;
        }
        public int getVal(Node node){
            return node.val;
        }
    }
}
