import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class TimeTest {


    private int elementsQuantity;
    private int testQuantity;
    private long totalTime;
    private long startTime;
    private long endTime;
    private long result;




    public TimeTest(int elementsQuantity, int testQuantity) {
        this.elementsQuantity = elementsQuantity;
        this.testQuantity = testQuantity;
    }


    public long populateTestForCollection(Collection<Integer> collection) {

        totalTime = 0;

        for (int i = 0; i < testQuantity; i++) {
            collection.clear();
            startTime = System.nanoTime();

            for (int j = 0; j < elementsQuantity; j++) {
                collection.add(j);
            }

            endTime = System.nanoTime();
            result = endTime - startTime;
            totalTime += result;
        }
        return totalTime / testQuantity;
    }


    public long addIndexTestForList(List<Integer> list, int valueAndPosition) {

        totalTime = 0;

        for (int i = 0; i < testQuantity; i++) {
            startTime = System.nanoTime();
            list.add(valueAndPosition, valueAndPosition);
            endTime = System.nanoTime();
            result = endTime - startTime;
            totalTime += result;
        }
        return totalTime / testQuantity;
    }


    public long addTestForSet(Set<Integer> set) {

        totalTime = 0;

        for (int i = 0; i < testQuantity; i++) {
            startTime = System.nanoTime();
            set.add(elementsQuantity++);
            endTime = System.nanoTime();
            result = endTime - startTime;
            totalTime += result;
        }
        return totalTime / testQuantity;
    }


    public long removeTestForList(Collection<Integer> collection, int value) {

        totalTime = 0;

        for (int i = 0; i < testQuantity; i++) {
            startTime = System.nanoTime();
            collection.remove(value);
            endTime = System.nanoTime();
            result = endTime - startTime;
            totalTime += result;
        }
        return totalTime / testQuantity;
    }



    public long getTestForList(List<Integer> list, int position) {

        totalTime = 0;

        for (int i = 0; i < testQuantity; i++) {
            startTime = System.nanoTime();
            list.get(position);
            endTime = System.nanoTime();
            result = endTime - startTime;
            totalTime += result;
        }
        return totalTime / testQuantity;
    }


    public long removeTestForSet(Set<Integer> set) {

        totalTime = 0;

        for (int i = 0; i < testQuantity; i++) {
            startTime = System.nanoTime();
            set.remove(elementsQuantity++);
            endTime = System.nanoTime();
            result = endTime - startTime;
            totalTime += result;
        }
        return totalTime / testQuantity;
    }


    public long containsTestForCollection(Collection<Integer> collection, int value) {

        totalTime = 0;

        for (int i = 0; i < testQuantity; i++) {
            startTime = System.nanoTime();
            collection.contains(value);
            endTime = System.nanoTime();
            result = endTime - startTime;
            totalTime += result;
        }
        return totalTime / testQuantity;
    }


    public long iteratorAddTestForList(List<Integer> list, int value) {

        ListIterator<Integer> iterator = list.listIterator(value);

        totalTime = 0;

        for (int i = 0; i < testQuantity; i++) {
            startTime = System.nanoTime();
            iterator.add(value);
            endTime = System.nanoTime();
            result = endTime - startTime;
            totalTime += result;
        }
        return totalTime / testQuantity;
    }


    public long iteratorRemoveTestForList(List<Integer> list, int value) {

        ListIterator<Integer> iterator = list.listIterator(value);

        totalTime = 0;

        for (int i = 0; i < testQuantity; i++) {
            startTime = System.nanoTime();
            iterator.next();
            iterator.remove();
            endTime = System.nanoTime();
            result = endTime - startTime;
            totalTime += result;
        }
        return totalTime / testQuantity;
    }
}

