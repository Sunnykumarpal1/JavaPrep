public class MyThread1 extends Thread {
    SharedResources sharedResources;
    public MyThread1(SharedResources sr){
        sharedResources=sr;
    }
    @Override
    public void run() {
        sharedResources.waitingMethod();
    }
}
