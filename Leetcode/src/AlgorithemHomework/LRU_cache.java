package AlgorithemHomework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;



public class LRU_cache {
    private HashMap<Integer,Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LRU_cache(){}
    public LRU_cache(int capacity){
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            moveTohHead(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    public void put(int key,int value){
        if(size < capacity){
            if(map.containsKey(key)){
                map.get(key).val = value;
                moveTohHead(map.get(key));
                map.put(key,map.get(key));
            }
            else{
                size++;
                Node node = new Node(key,value);
                addToHead(node);
                map.put(key,node);
            }
        }
        else if(size == capacity){
            if(!map.containsKey(key)){
                Node tmp = tail.prev;
                map.remove(tmp.key);
                cutTail();
                Node n = new Node(key,value);
                addToHead(n);
                map.put(key,n);
            }
            else{
                map.get(key).val = value;
                moveTohHead(map.get(key));
                map.put(key,map.get(key));
            }
        }
    }

    private void moveTohHead(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        head.next.prev = node;
        node.prev = head;
        node.next = head.next;
        head.next = node;
    }
    private void addToHead(Node node){
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
    private void cutTail(){
        Node tmp = tail.prev;
        tmp.prev.next = tail;
        tail.prev = tmp.prev;
    }



}
class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(){}
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}