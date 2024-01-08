package DataStructure;

import javax.swing.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class BinaryTree {
    /*
        节点类
     */
    private static class Node{
        private int value;
        private Node left;
        private Node right;
        private  int height;
        public Node(){
            this.value = 0;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node left,Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    //广度优先遍历
    public static void bfs(Node node){
        if(node == null) return;
        Deque<Node> dq = new LinkedList<>();
        dq.addLast(node);
        while(!dq.isEmpty()){
            Node tmp = dq.poll();
            System.out.println("value is : "+tmp.value);
            if(tmp.left != null) dq.addLast(tmp.left);
            if(tmp.right != null) dq.addLast(tmp.right);
        }
    }
    //深度优先遍历
    public static void dfs(Node node){
        if(node == null) return;
        //pre-order
        System.out.println(node.value);
        dfs(node.left);
        dfs(node.right);
        /*
            mid-order:
            dfs(node.left);
            System.out.println(node.value);
            dfs(node.right);

            post-order:
            dfs(node.left);
            dfs(node.right);
            System.out.println(node.value);
         */
    }
//插入成为平衡二叉树 res是除了跟节点外的节点 row存每一层节点
    public static void insert(Deque<Node> res,Deque<Node> row){
        while (!row.isEmpty()){
            Node tmp = row.poll();
            if(!res.isEmpty()){
                tmp.left = res.poll();
                row.add(tmp.left);
            }
            if(!res.isEmpty()){
                tmp.right = res.poll();
                row.add(tmp.right);
            }
        }
    }

    public static void main(String[] args) {
        Deque<Node> res = new LinkedList<>();
        Deque<Node> row = new LinkedList<>();
        Node root = new Node(0);
        for(int i=0;i<=5;i++){
            if(i==0) row.add(root);
            else res.add(new Node(i));
        }
        insert(res,row);
        bfs(root);

    }

}
