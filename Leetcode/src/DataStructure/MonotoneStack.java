package DataStructure;

import java.util.Deque;
import java.util.LinkedList;

/*
    单调栈，进入栈的元素由小到大排序
    LeetCode.739实战
 */
public class MonotoneStack {
    private Deque<Integer> mStack;
    public MonotoneStack(){
        mStack = new LinkedList<>();
    }
    public int getSize(){
        return mStack.size();
    }
    public boolean isEmpty(){
        return getSize()==0;
    }
    public void offer(int val){
        Deque<Integer> transfer = new LinkedList<>();
        if(mStack.isEmpty()){
            mStack.addLast(val);
        }
        else{
            if(val >= mStack.peekLast()) mStack.addLast(val);
            else{
                while(mStack.peekLast() > val){
                    transfer.addLast(mStack.removeLast());
                }
                mStack.addLast(val);
                while(!transfer.isEmpty()){
                    mStack.addLast(transfer.removeFirst());
                }
            }
        }
    }
    public int peek(){
        return mStack.peekLast();
    }
    public int poll(){
        return mStack.pollLast();
    }


    public static void main(String[] args) {
        MonotoneStack monotoneStack = new MonotoneStack();
        monotoneStack.offer(1);
        monotoneStack.offer(2);
        monotoneStack.offer(6);
        monotoneStack.offer(4);
        monotoneStack.poll();
        System.out.println(monotoneStack.poll());

    }
}