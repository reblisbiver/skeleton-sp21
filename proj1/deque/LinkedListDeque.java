package deque;

public class LinkedListDeque<T> {
    private class TNode {
        private TNode prev;
        private T item;
        private TNode next;

        private TNode(T i, TNode n) {
            item = i;
            next = n;
        }
    }

    private TNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        TNode newTNode = new TNode(item, sentinel.next);
        sentinel.next = newTNode;
        newTNode.prev = sentinel;
        size++;
    }

    public void addLast(T item) {
        TNode newTNode = new TNode(item, sentinel);
        sentinel.prev.next = newTNode;
        newTNode.prev = sentinel.prev;
        sentinel.prev = newTNode;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int index = 0;
        TNode t = sentinel.next;
        while (index < size) {
            System.out.print(t.item + " ");
            t = t.next;
            index++;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T returnValue = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size--;
            return returnValue;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            T returnValue = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size--;
            return returnValue;
        }
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        } else {
            TNode t = sentinel.next;
            while (index > 0) {
                t = t.next;
                index--;
            }
            return t.item;
        }
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        } else {
            return getRecursiveHelper(sentinel.next, index);
        }
    }

    private T getRecursiveHelper(TNode current, int index) {
        if (index == 0) {
            return current.item;
        } else {
            return getRecursiveHelper(current.next, index - 1);
        }
    }
}
