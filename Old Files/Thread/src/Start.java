public class Start {
    public static void main(String[] args) {
        SharedResources sr=new SharedResources();
        Thread th1=new MyThread1(sr);
        /
        Thread th2=new MyThread2(sr);
        th1.start();
        th2.start();
    }
}
