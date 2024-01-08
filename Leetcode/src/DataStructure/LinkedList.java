package DataStructure;
/*
    双向链表，含有pre,next指针
 */

public class LinkedList{
    static class Node{
        private int val;
        private Node pre;
        private Node next;
        public Node(int val){
            this.val = val;
        }
        public int getVal(Node node){
            return node.val;
        }
        public Node getPre(Node node){
            return node.pre;
        }
        public Node getNext(Node node){
            return node.next;
        }

    }

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(){
        head = null;
        tail = null;
        length = 0;
    }
    public void addLast(Node node){
        if(head == null){
            head = node;
            tail = node;
            length = 1;
        }
        else{
            tail.next = node;
            node.pre = tail;
            tail = node;
            length++;
        }
    }
    public void addFirst(Node node){
        if(head == null){
            addLast(node);
        }
        else{
            node.next = head;
            node.pre = null;
            head = node;
            length++;
        }
    }
    public boolean isEmpty(){
        return length == 0;
    }

    public void deleteFirst(){
        if(!isEmpty()){
            Node node = head.next;
            node.pre = null;
            head = node;
        }
    }

    public void deleteLast(){
        if(!isEmpty()){
            Node node = tail.pre;
            node.next = null;
            tail = node;
        }
    }
    public boolean deleteAt(int index){
        Node cur = head;
        int count = 0;
        if(index<0 || index>=length) return false;
        while(cur!=null){
            if(count == index){
                Node pre = cur.pre;
                Node next = cur.next;
                pre.next = next;
                if(next!=null) next.pre = pre;
                break;
            }
            cur = cur.next;
            count++;
        }
        return true;
    }
    public int getVal(int index){
        Node cur = head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        return cur.val;
    }
    public void clear(){
        head.next = null;
        head.val = 0;
        tail = head;
    }
    public void showAll(){
        Node node = head;
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.addFirst(new Node(3));
        ls.addLast(new Node(4));
        ls.addLast(new Node(5));
        ls.getVal(2);
        ls.showAll();
        ls.deleteAt(2);
        ls.showAll();

    }
}
