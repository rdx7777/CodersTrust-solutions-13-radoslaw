package pl.coderstrust.list;

import java.util.*;

public class MyArrayList<Long> implements List<Long> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int MAXIMUM_CAPACITY = 2_000_000_000;
    private int size;
    private Object elements[];

    public MyArrayList() { // done
        elements = new Object[INITIAL_CAPACITY];
    }

    @Override // done with test
    public int size() {
        return size;
    }

    @Override // done with test
    public boolean isEmpty() {
        return size == 0;
    }

    @Override // done with test
    // what about WRONG OBJECT TYPE ???
    public boolean add(Long aLong) {
        if (size == MAXIMUM_CAPACITY) {
            return false;
        }
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = aLong;
        return true;
    }

    // extra added method **********************************************************************************************
    // NOT TESTED YET !!!!!!!!!!!!!! ***********************************************************************************
    public void increaseCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override // done with test
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) { // order matters, but WHY ?????????????????????????????????????????????????
//                if (elements[i].equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // done with test
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override // done with test
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override // done with test
    // is't interesting - BOTH VERSION ARE WORKING --- which is better ????????????????????????????????????????
    public void clear() {
//        elements = new Object[INITIAL_CAPACITY];
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override // done with test
    public Long get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be lower than 0.");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index cannot be greater than list size");
        }
        return (Long) elements[index];
    }

    @Override // done with test
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) { // order MATTERS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // done with test
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) { // order MATTERS... WHY ???????????????????????????????????????????????????
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // done with test
    public Long set(int index, Long element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Passed index cannot be lower than 0.");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Passed index cannot be greater than list size.");
        }
        Long exchangedValue = (Long) elements[index];
        elements[index] = element;
        return exchangedValue;
    }

    @Override
    public void add(int index, Long element) {

    }

    @Override
    public Long remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Iterator<Long> iterator() {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Long> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Long> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public ListIterator<Long> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Long> listIterator(int index) {
        return null;
    }

    @Override
    public List<Long> subList(int fromIndex, int toIndex) {
        return null;
    }
}
