package SE;

public class A implements CallBack {
    private B b;
    public A(B b){
        this.b = b;
    }
    public void ask(){
        b.ans(this);
    }
    public void asyncAsk(){
        System.out.println("异步回调提问：");
        new Thread(()->b.ans(this)).start();
        System.out.println("新线程开始");
    }
    @Override
    public void callback(String s) {
        System.out.println("收到答案是"+s);
    }
    public static void main(String[] args) {
        B b = new B();
        A a = new A(b);
        a.asyncAsk();
    }
}
class B{
    public void ans(CallBack callBack){
        System.out.println("正在计算～～～～");
        try{
            System.out.println("容我想想先～～～");
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("算出来是50");
        callBack.callback("50");
    }
}
