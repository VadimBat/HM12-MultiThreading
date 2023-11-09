package task2;

public class FizzBuzzPrinterApp {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzzChecker checker = new FizzBuzzChecker(15);

        Thread A = new Thread(() -> {
            checker.fizz(checker::printFizz);
        });

        Thread B = new Thread(() -> {
            checker.buzz(checker::printBuzz);
        });

        Thread C = new Thread(() -> {
            checker.fizzBuzz(checker::printFizzBuzz);
        });

        Thread D = new Thread(() -> {
            checker.number(i -> checker.printNumber());
        });

        A.start();
        B.start();
        C.start();
        D.start();
        A.join();
        B.join();
        C.join();
        D.join();
    }
}
