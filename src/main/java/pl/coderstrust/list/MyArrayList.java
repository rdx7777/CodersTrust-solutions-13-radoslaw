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

    @Override // done
    public int size() {
        return size;
    }

    @Override // done
    public boolean isEmpty() {
        return size == 0;
    }

    @Override // done
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<Long> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() { // done
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override // done - but... what about WRONG OBJECT TYPE ???
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

    // extra added method
    // NOT TESTED YET !!!!!!!!!!!!!!
    public void increaseCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public boolean remove(Object o) {
        return false;
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
    public void clear() {

    }

    @Override
    public Long get(int index) {
        return null;
    }

    @Override
    public Long set(int index, Long element) {
        return null;
    }

    @Override
    public void add(int index, Long element) {

    }

    @Override
    public Long remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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
