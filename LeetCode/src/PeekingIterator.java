import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/21 22:05
 */

public class PeekingIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int nextIndex = 0;

    public PeekingIterator(Iterator<Integer> iterator) {
        list = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    @Override
    public boolean hasNext() {
        if (nextIndex <= list.size() - 1) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return list.get(nextIndex++);
        }
        throw new NoSuchElementException();
    }

    public Integer peek() {
        if (hasNext()) {
            return list.get(nextIndex);
        }
        throw new NoSuchElementException();
    }
}
