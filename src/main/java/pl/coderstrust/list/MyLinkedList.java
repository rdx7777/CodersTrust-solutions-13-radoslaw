package pl.coderstrust.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

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

    public boolean add(T element) {
        if (first == null) {
            first = new Node<>(element);
            last = first;
        } else {
            Node<T> previousLast = last;
            last = new Node<>(element);
            last.previous = previousLast;
            previousLast.next = last;
        }
        size++;
        return true;
    }

    public int size() {
        return this.size;
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
        for (int i = index; i > 0; i--) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            }
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public boolean remove(T elementToRemove) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Passed value cannot be applied to empty list.");
        }
        Node<T> currentNode = first;
        if (elementToRemove == null) {
            while (currentNode != null) {
                if (currentNode.element == null) {
                    uncheckedRemove(currentNode);
                    return true;
                }
                currentNode = currentNode.next;
            }
        } else {
            while (currentNode != null) {
                if (elementToRemove.equals(currentNode.element)) {
                    uncheckedRemove(currentNode);
                    return true;
                }
                currentNode = currentNode.next;
            }
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
        } else {
            last = currentNode.previous;
        }
        size--;
    }

    public boolean add(int index, T element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Passed index cannot be lower than 0.");
        }
        if (index > size()) {
            throw new IndexOutOfBoundsException("Passed index cannot be greater than list size.");
        }
        // adding to empty list
        if (first == null && index == 0) {
            first = new Node<>(element);
            last = first;
            size++;
            return true;
        }
        Node<T> nodeAtIndex = getNode(index);
        // adding at the end of the list
        if (nodeAtIndex == null) {
            Node<T> previousLast = last;
            last = new Node<>(element);
            last.previous = previousLast;
            previousLast.next = last;
            size++;
            return true;
        }
        // adding at the beginning of the list
        if (nodeAtIndex.previous == null) {
            Node<T> previousFirst = first;
            first = new Node<>(element);
            first.next = previousFirst;
            previousFirst.previous = first;
            size++;
            return true;
        }
        // adding between existing nodes
        Node<T> newNode = new Node<>(element);
        Node<T> previous = nodeAtIndex.previous;
        previous.next = newNode;
        newNode.previous = previous;
        newNode.next = nodeAtIndex;
        nodeAtIndex.previous = newNode;
        size++;
        return true;
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private Node<T> current = first;
        private Node<T> lastReturned;

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

    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }
        Node<T> currentNode = first;
        if (element == null) {
            while (currentNode != null) {
                if (currentNode.element == null) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        } else {
            while (currentNode != null) {
                if (element.equals(currentNode.element)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }
}
