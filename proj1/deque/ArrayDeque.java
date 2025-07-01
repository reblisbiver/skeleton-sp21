package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int head;
    private int end;
    private int size;

    private int currentSize = 8;

    public ArrayDeque() {
        items = (T[]) new Object[currentSize];
        head = 0;
        end = 1;
        size = 0;
    }

    public void addFirst(T item) {
        items[head] = item;
        head = (head - 1) % currentSize;
        size++;
        resize();
    }

    public void addLast(T item) {
        items[end] = item;
        end = (end + 1) % currentSize;
        size--;
        resize();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 1; i <= size; i++) {
            System.out.print(items[(head + 1) % currentSize] + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        head = (head + 1) % currentSize;
        size--;
        T returnItem = items[(head - 1) % currentSize];
        resize();
        return returnItem;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        end = (end - 1) % currentSize;
        size--;
        T returnItem = items[(end + 1) % currentSize];
        resize();
        return returnItem;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[(head + 1 + size) % currentSize];
    }

    private void resize() {
        if (currentSize > 8 && size < 0.25 * currentSize) {
            T[] newItems = (T[]) new Object[currentSize / 2];
            if (head + size > currentSize) {
                System.arraycopy(items, (head + 1) % currentSize, newItems, 0, currentSize - head - 1);
                System.arraycopy(items, 0, newItems, currentSize - head - 1, size - currentSize + head + 1);
            } else {
                System.arraycopy(items, head, newItems, 0, size);
            }
            currentSize = currentSize / 2;
            head = currentSize - 1;
            end = size;
            items = newItems;
        }
        if (size == currentSize) {
            T[] newItems = (T[]) new Object[currentSize * 2];
            if (head + size > currentSize) {
                System.arraycopy(items, (head + 1) % currentSize, newItems, 0, currentSize - head - 1);
                System.arraycopy(items, 0, newItems, currentSize - head - 1, size - currentSize + head + 1);
            } else {
                System.arraycopy(items, head, newItems, 0, size);
            }
            currentSize = currentSize * 2;
            head = currentSize - 1;
            end = size;
            items = newItems;
        }
    }
}
