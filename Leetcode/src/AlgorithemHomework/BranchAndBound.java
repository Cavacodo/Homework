package AlgorithemHomework;

import DataStructure.BinaryTree;

import javax.swing.tree.TreeCellRenderer;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 纯傻逼做法还要模拟完全二叉树
 * 尝试模拟
 */
public class BranchAndBound {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {2,4,5,5};
        BranchAndBound branchAndBound = new BranchAndBound();
        TreeNode t = branchAndBound.treeNodify(a,b);
        System.out.println(branchAndBound.branchNBound(t,5));
    }
    public int branchNBound(TreeNode root,int maxW){
        int ans = 0;
        int curW = 0;
        Map<TreeNode,Integer> price = new HashMap<>();
        Map<TreeNode,Integer> space = new HashMap<>();
        Deque<TreeNode> dq = new LinkedList<>();
        price.put(root,0);
        space.put(root,maxW);
        dq.addLast(root);
        while(!dq.isEmpty()){
            TreeNode treeNode = dq.poll();
            if(treeNode.left == null || treeNode.right == null){
                ans = Math.max(ans,price.get(treeNode));
                continue;
            }
            price.put(treeNode.left,price.get(treeNode));
            space.put(treeNode.left,space.get(treeNode));
            dq.offer(treeNode.left);
            curW = space.get(treeNode);
            if(curW - treeNode.right.weight >= 0){
                dq.offer(treeNode.right);
                price.put(treeNode.right,price.get(treeNode)+treeNode.right.val);
                space.put(treeNode.right,curW- treeNode.right.weight);
            }
        }
        return ans;
    }
    public static void bfs(TreeNode node){
        if(node == null) return;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(node);
        int cnt = 0;
        while(!dq.isEmpty()){
            TreeNode tmp = dq.poll();
            System.out.println("value is : "+tmp.val + "weight is : "+tmp.weight + " "+cnt++);
            if(tmp.left != null) dq.addLast(tmp.left);
            if(tmp.right != null) dq.addLast(tmp.right);
        }
    }
    public TreeNode treeNodify(int[] nums,int[] values){
        TreeNode root = new TreeNode();
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(root);
        Map<TreeNode,Integer> map = new HashMap<>();
        map.put(root,0);
        int cnt = nums.length;
        while(!dq.isEmpty()){
            TreeNode t = dq.poll();
            TreeNode left = new TreeNode();
            int idx = map.get(t)<cnt ? map.get(t) : 0;
            TreeNode right = new TreeNode(nums[idx],values[idx]);
            int tag = map.get(t) + 1;
            map.put(left,tag);
            map.put(right,tag);
            if(tag <= cnt){
                t.left = left;
                t.right = right;
                dq.offer(left);
                dq.offer(right);
            }
        }
        return root;
    }
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        int weight;
        public TreeNode(){
            this.val = 0;
        }

        public TreeNode(int weight,int val){
            this.weight = weight;
            this.val = val;
        }
    }
}
