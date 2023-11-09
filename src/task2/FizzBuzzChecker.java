package task2;

import java.util.function.IntConsumer;

public class FizzBuzzChecker {
    private int n;
    private int i = 1;

    public FizzBuzzChecker(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public boolean isFizz() {
        if (i % 3 == 0 && i % 5 != 0) {
            return true;
        }
        return false;
    }

    public boolean isBuzz() {
        if (i % 5 == 0 && i % 3 != 0) {
            return true;
        }
        return false;
    }

    public boolean isFizzBuzz() {
        if (i % 3 == 0 && i % 5 == 0) {
            return true;
        }
        return false;
    }

    public void printFizz() {
        if (i == n) {
            System.out.println("fizz");
        } else {
            System.out.print("fizz, ");
        }
    }

    public void printBuzz() {
        if (i == n) {
            System.out.println("buzz");
        } else {
            System.out.print("buzz, ");
        }
    }

    public void printFizzBuzz() {
        if (i == n) {
            System.out.println("fizzbuzz");
        } else {
            System.out.print("fizzbuzz, ");
        }
    }

    public void printNumber() {
        if (i == n) {
            System.out.println(i);
        } else {
            System.out.print(i + ", ");
        }
    }

    public synchronized void fizzBuzz(Runnable printFizzBuzz) {
        while (i <= n) {
            if (isFizzBuzz()) {
                printFizzBuzz.run();
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void fizz(Runnable printFizz) {
        while (i <= n) {
            if (isFizz()) {
                printFizz.run();
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void buzz(Runnable printBuzz) {
        while (i <= n) {
            if (isBuzz()) {
                printBuzz.run();
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void number(IntConsumer printNumber) {
        while (i <= n) {
            if (!isFizzBuzz() && !isFizz() && !isBuzz()) {
                printNumber.accept(i);
                i++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
