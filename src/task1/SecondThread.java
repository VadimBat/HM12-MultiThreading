package task1;

public class SecondThread extends Thread {
    @Override
    synchronized public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("5 seconds passed");
        }
    }
}
