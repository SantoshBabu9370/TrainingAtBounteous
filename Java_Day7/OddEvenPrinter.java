package Java_Day7;
import java.util.concurrent.atomic.AtomicInteger;
class Printer {
    private final AtomicInteger number = new AtomicInteger(1);
    private final int max;
    public Printer(int max) {
        this.max = max;
    }
    public void printOdd() {
        while (number.get() <= max) {
            if (number.get() % 2 != 0) {
                System.out.println("Odd: " + number.getAndIncrement());
            }
        }
    }
    public void printEven() {
        while (number.get() <= max) {
            if (number.get() % 2 == 0) {
                System.out.println("Even: " + number.getAndIncrement());
            }
        }}}
public class OddEvenPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer(10);
        Thread oddThread = new Thread(printer::printOdd);
        Thread evenThread = new Thread(printer::printEven);
        oddThread.start();
        evenThread.start();
    }
}

