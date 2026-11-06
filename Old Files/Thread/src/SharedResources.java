public class SharedResources {
    synchronized public void waitingMethod(){
        System.out.println("Wait Method Begins");
        try {
            wait();
        }catch (Exception exp){
            exp.printStackTrace();
        }
        System.out.println("Wait Method Ends");
    }
    synchronized public void notifyMethod(){
        System.out.println("Notify Method begins");
        try {
            notify();
        }catch (Exception exp){
            exp.printStackTrace();
        }
        System.out.println("Notify Method Ends");
    }
}
