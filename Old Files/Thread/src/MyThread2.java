public class MyThread2 extends Thread{
    SharedResources sharedResources;

    public MyThread2(SharedResources sr){
        sharedResources=sr;
    }

    @Override
    public void run() {
        sharedResources.notifyMethod();
    }
}
