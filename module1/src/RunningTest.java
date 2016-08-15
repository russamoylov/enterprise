import java.io.IOException;

public class RunningTest {
    public static void main (String [] args) throws IOException {
        try {
            TestImpl smallAmount = new TestImpl(100, 10000);
            smallAmount.runTest();
            smallAmount.printResults();
            smallAmount.writeResults();

            TestImpl middleAmount = new TestImpl(100, 100000);
            middleAmount.runTest();
            middleAmount.printResults();
            middleAmount.writeResults();

            TestImpl bigAmount = new TestImpl(100, 1000000);
            bigAmount.runTest();
            bigAmount.printResults();
            bigAmount.writeResults();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

