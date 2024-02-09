package DataStructure;

import com.sun.source.tree.Tree;

import java.util.TreeMap;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("apple");
        System.out.println(trie.contains("apple"));
        System.out.println(trie.isPrefix("app"));
    }
    private class TreeNode{
        public boolean isWord;
        public TreeMap<Character,TreeNode> next;
        public TreeNode(){
            this(false);
            next = new TreeMap<>();
        }
        public TreeNode(boolean isWord){
            this.isWord = isWord;
        }
    }
    private TreeNode root;
    private int size;
    public Trie(){
        this.root = new TreeNode();
        this.size = 0;
    }
    public int getSize(){
        return size;
    }
    public void add(String str){
        TreeNode cur = root;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(cur.next.get(c) == null){
                //新建节点
                cur.next.put(c, new TreeNode());
            }
            //否则，就直接走到该节点位置即可
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            //确定cur是新的单词
            cur.isWord = true;
            size++;
        }
    }
    public boolean contains(String str){
        TreeNode cur = root;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(cur.next.get(c) == null) return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
    public boolean isPrefix(String prefix){
        TreeNode cur = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null) return false;
            cur = cur.next.get(c);
        }
        return true;
    }

}

