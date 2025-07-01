public class SLList {
    private class IntNode {
        private int item;
        private IntNode next;
        private IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        /* Your Code Here! */
        first.next = new IntNode(x, null);
    }

    /** Returns the number of items in the list using recursion. */
    public int size() {
        /* Your Code Here! */
        int size = 0;
        IntNode helper = first;
        helper.
        while(helper != null){
            size += 1;
            helper = helper.next;
        }
        return size;
    }

}