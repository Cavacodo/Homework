package Recursion;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.bfs(root);
    }
    //pre-order traverse
    public void dfs(TreeNode treeNode){
        if(treeNode == null) return;
        System.out.println(treeNode.val);
        dfs(treeNode.left);

        dfs(treeNode.right);
    }
    public void StackSimulatePre(TreeNode treeNode){
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(treeNode);
        while(!dq.isEmpty()){
            TreeNode tmp = dq.removeLast();
            System.out.println(tmp.val);
            if(tmp.right != null) dq.addLast(tmp.right);
            if(tmp.left != null) dq.addLast(tmp.left);
        }
    }
    public void StackSimulateMid(TreeNode treeNode){
        HashMap<TreeNode,Boolean> hashMap = new HashMap<>();
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(treeNode);
        while(!dq.isEmpty()){
            TreeNode tmp = dq.peekLast();
            while(tmp.left != null && !hashMap.getOrDefault(tmp.left,false)){
                dq.addLast(tmp.left);
                tmp = tmp.left;
            }
            TreeNode t = dq.pollLast();
            hashMap.put(t,true);
            System.out.println(t.val);
            while(t.right != null && !hashMap.getOrDefault(t.right,false)){
                if(t.left != null && !hashMap.getOrDefault(t.left,false)) break;
                dq.addLast(t.right);
                t = t.right;
            }
        }
    }
    public void StackSimulatedPost(TreeNode treeNode){
        Deque<TreeNode> dq = new LinkedList<>();
        HashMap<TreeNode,Boolean> hashMap = new HashMap<>();
        dq.addLast(treeNode);
        while(!dq.isEmpty()){
            TreeNode tmp = dq.peekLast();
            while(tmp.left != null && !hashMap.getOrDefault(tmp.left,false)){
                dq.addLast(tmp.left);
                tmp = tmp.left;
            }
            while(tmp.right != null && !hashMap.getOrDefault(tmp.right,false)){
                while (tmp.left !=null && !hashMap.getOrDefault(tmp.left,false)){
                    dq.addLast(tmp.left);
                    tmp = tmp.left;
                }
                if(tmp.right != null && !hashMap.getOrDefault(tmp.right,false)){
                    dq.addLast(tmp.right);
                    tmp = tmp.right;
                }
            }
            hashMap.put(dq.peekLast(),true);
            System.out.println(dq.pollLast().val);
        }
    }
    public void bfs(TreeNode treeNode){
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(treeNode);
        while(!dq.isEmpty()){
            TreeNode tmp = dq.poll();
            System.out.println(tmp.val);
            if(tmp.left != null) dq.addLast(tmp.left);
            if(tmp.right != null) dq.addLast(tmp.right);
        }
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(){}
    public TreeNode(int value){
        this.val = value;
    }
}