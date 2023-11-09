package task1;

public class MultiThreadApp {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new FirstThread();
        Thread thread2 = new SecondThread();

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
