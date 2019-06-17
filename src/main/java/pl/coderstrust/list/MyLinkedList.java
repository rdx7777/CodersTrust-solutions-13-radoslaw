package pl.coderstrust.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    private static class Node<T> {

        private T element;
        private Node<T> previous;
        private Node<T> next;

        Node(T element) {
            this.element = element;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T element) {
        if (first == null) {
            first = new Node<>(element);
            last = first;
        } else {
            Node<T> previousLast = last;
            last = new Node<>(element);
            last.previous = previousLast;
            previousLast.next = last;
        }
    }

    public int size() {
        int size = 0;
        Node<T> currentNode = first;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public T get(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Passed index cannot be applied to empty list.");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Passed index cannot be lower than 0.");
        }
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Passed index cannot be greater than list size.");
        }
        return getNode(index).element;
    }

    private Node<T> getNode(int index) {
        Node<T> currentNode = first;
        int currentIndex = index;
        while (currentIndex > 0) {
            if (currentNode == null) { // ******************** doubled condition == if(isEmpty()) in line 49 ***********
                throw new IndexOutOfBoundsException();
            }
            currentNode = currentNode.next;
            currentIndex--;
        }
        return currentNode;
    }

    public boolean remove(T elementToRemove) {
        if (isEmpty()) {
                throw new IndexOutOfBoundsException("Passed value cannot be applied to empty list.");
        }
        Node<T> currentNode = first;
        while (currentNode != null) {
            if (elementToRemove == null) {
                if (currentNode.element == null) {
                    uncheckedRemove(currentNode);
                    return true;
                }
            } else {
                if (elementToRemove.equals(currentNode.element)) {
                    uncheckedRemove(currentNode);
                    return true;
                }
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    private void uncheckedRemove(Node<T> currentNode) {
        Node<T> previousNode = currentNode.previous;
        Node<T> nextNode = currentNode.next;
        if (previousNode != null) {
            previousNode.next = nextNode;
        } else {
            first = currentNode.next;
        }
        if (nextNode != null) {
            nextNode.previous = previousNode;
        }
    }

    public boolean add(int index, T element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Passed index cannot be lower than 0.");
        }
        // adding to empty list
        if (first == null && index != 0) {
            throw new IndexOutOfBoundsException("When adding to empty list passed index cannot be different than 0.");
        }
        if (first == null && index == 0) {
            first = new Node<>(element);
            last = first;
            return true;
        }
        if (first != null && index > size()) {
            throw new IndexOutOfBoundsException("Passed index cannot be greater than list size.");
        }
        Node<T> nodeAtIndex = getNode(index);
        // adding at the end of the list
        if (nodeAtIndex == null) {
            Node<T> previousLast = last;
            last = new Node<>(element);
            last.previous = previousLast;
            previousLast.next = last;
            return true;
        }
        // adding at the beginning of the list
        if (nodeAtIndex.previous == null) {
            Node<T> previousFirst = first;
            first = new Node<>(element);
            first.next = previousFirst;
            previousFirst.previous = first;
            return true;
        }
        // adding between existing nodes
        Node<T> newNode = new Node<>(element);
        Node<T> previous = nodeAtIndex.previous;
        previous.next = newNode;
        newNode.previous = previous;
        newNode.next = nodeAtIndex;
        nodeAtIndex.previous = newNode;
        return true;
    }

    public Iterator<T> iterator() {
        return new Itrtr();
    }

    private class Itrtr implements Iterator<T> {

        private Node<T> current = first;
        private Node<T> lastReturned;

        Itrtr() {
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T element = current.element;
            lastReturned = current;
            current = current.next;
            return element;
        }

        public void remove() {
            if (lastReturned != null) {
                uncheckedRemove(lastReturned);
            }
        }
    }
}
