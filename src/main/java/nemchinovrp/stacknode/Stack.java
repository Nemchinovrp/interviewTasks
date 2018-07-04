package nemchinovrp.stacknode;

public class Stack<T extends Comparable<T>> {
    private Node<T> lastItem;
    private int size;

    public Stack() {
    }

    /**
     * Get the item at the top of the stack
     * without removing it
     */
    public T peek() {
        return getLastItem().getData();
    }


    /**
     * Two cases:
     * 1. Stack is empty: simply set head to new node
     * 2. Stack is not empty:
     * Set newly inserted data as the lastItem (or top of the stack)
     * Update reference to point the new data to the previous lastItem.
     * <p>
     * lastItem --> null;
     * new head --> head;
     */
    public void push(T data) {
        if (isEmpty()) {
            addToEmptyStack(data);
        } else {
            addToNotEmptyStack(data);
        }
        incrementSize();
    }

    /**
     * Remove the element at the top of the stack
     *
     * @throws EmptyStackException
     */
    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("The stack is empty ...");
        }
        T lastData = getLastItem().getData();
        decrementSize();
        removeLastItem();
        return lastData;
    }


    /**
     * @return lastItem: the item that is at the top of the stack
     */
    private Node<T> getLastItem() {
        return lastItem;
    }

    private void removeLastItem() {
        Node<T> newLastItem = lastItem.getNextNode();
        // Check if the element to remove is
        // the last item on the stack
        if (newLastItem == null) {
            lastItem = null;
        } else {    // If there are more than one items on the stack
            lastItem = lastItem.getNextNode();
        }
    }

    /**
     * Add to an empty stack
     *
     * @param data
     */
    private void addToEmptyStack(T data) {
        this.lastItem = new Node<T>(data);
    }

    /**
     * This code will run with the assumption that the
     * stack is not empty
     *
     * @param data
     */
    private void addToNotEmptyStack(T data) {
        // Step 1. Create the reference to the current lastItem (before insertion)
        Node<T> prevLastItem = lastItem;
        // Step 2. set the lastItem to the new node created with inserted data
        lastItem = new Node<T>(data);
        // Step 3. Set the next node of the new lastItem to point at the previous last item.
        lastItem.setNextNode(prevLastItem);
    }

    public int size() {
        return this.size;
    }

    /**
     * Print all the items currently available on the stack
     */
    public void print() {
        Node<T> currentNode = lastItem;
        while (currentNode != null) {
            System.out.print(currentNode);
            System.out.print(" --> ");
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    private void incrementSize() {
        this.size++;
    }

    private void decrementSize() {
        this.size--;
    }

    /**
     * return <code>true</code> if empty
     */
    public boolean isEmpty() {
        return this.lastItem == null;
    }

}