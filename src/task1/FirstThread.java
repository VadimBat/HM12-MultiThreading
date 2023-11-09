package task1;

public class FirstThread extends Thread {
    @Override
    synchronized public void run() {
        long sessionStartTime = System.currentTimeMillis();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Session duration = " + (System.currentTimeMillis() - sessionStartTime) / 1000 + " sec");
        }
    }
}
