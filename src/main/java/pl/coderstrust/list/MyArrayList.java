package pl.coderstrust.list;

import java.util.*;

public class MyArrayList<T> implements List<T> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int MAXIMUM_CAPACITY = 2_000_000_000;
    private int size;
    private Object elements[];

    public MyArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T element) {
        if (size == MAXIMUM_CAPACITY) {
            return false;
        }
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
        return true;
    }

    private void increaseCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return Arrays.stream(elements)
                    .limit(size)
                    .anyMatch(e -> e == null);
        }
        return Arrays.stream(elements)
                .limit(size)
                .filter(e -> e != null)
                .anyMatch(e -> e.equals(o));
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public void clear() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be lower than 0.");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index cannot be greater than list size.");
        }
        return (T) elements[index];
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public T set(int index, T element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Passed index cannot be lower than 0.");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Passed index cannot be greater than list size.");
        }
        T exchangedValue = (T) elements[index];
        elements[index] = element;
        return exchangedValue;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Passed index cannot be lower than 0.");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Passed index cannot be greater than list size.");
        }
        if (size == MAXIMUM_CAPACITY) {
            throw new IndexOutOfBoundsException("List cannot be greater than its maximum capacity.");
        }
        if (size == elements.length) {
            increaseCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Passed index cannot be lower than 0.");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Passed index cannot be greater than list size.");
        }
        T removedValue = (T) elements[index];
        uncheckedRemove(index);
        return removedValue;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i] == null) {
                    uncheckedRemove(i);
                    return true;
                }
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elements[i])) {
                    uncheckedRemove(i);
                    return true;
                }
        }
        return false;
    }

    private void uncheckedRemove(int index) {
        int lengthOfCopiedData = size - index - 1;
        if (lengthOfCopiedData > 0) {
            System.arraycopy(elements, index + 1, elements, index, lengthOfCopiedData);
        }
        elements[size] = null;
        size--;
        if (size <= elements.length / 4) {
            decreaseCapacity();
        }
    }

    private void decreaseCapacity() {
        int newSize = elements.length / 4 + 1;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public Iterator<T> iterator() {
        return new Itrtr();
    }

    private class Itrtr implements Iterator<T> {
        int cursor;
        int lastRet = -1;

        Itrtr() {
        }

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked") // ***************** delete? *****************
        public T next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = MyArrayList.this.elements;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (T) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            try {
                MyArrayList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
