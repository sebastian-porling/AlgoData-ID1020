/**
 * Created by sebastianporling on 2017-09-15.
 */
public class LinkedList<T extends Comparable<T>> {
    // Declare first node in the list, size and the number of swaps
    public Node head;
    private int size;
    private int swapCount;
    private int numberInv;

    // Initialize the list
    public LinkedList() {
        head = null;
        size = 0;
        numberInv = 0;
    }

    // Adds a node to the list, if list is empty the first node = new node
    // If the list is not empty add the node last.
    public void add(T data) {
        // Initialize new node and make temporary node we can loop through
        Node temp = new Node<T>(data);
        Node curr = head;

        // If list is empty first node equals new node
        if (head == null) {
            head = temp;
        } else {
            // Else go through list till the last node
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            // new node to the end of the list
            curr.setNext(temp);
        }
        // Size gets bigger as the list gets bigger
        this.size++;
    }

    // Returns size of list
    public int getSize() {
        return this.size;
    }

    // Bubblesort sorts the array o(n^)
    public void bubblesort() {
        // Initialize R and boolean for swapping
        int R = this.size - 2;
        boolean swapped = true;

        // Checks if the length of list is bigger or equals to 0, and checks if it has swapped
        while (R >= 0 && swapped) {
            swapped = false;
            int index = 0;
            // Loops through the first node
            for (Node i = head; i.getNext().getNext() != null; i = i.getNext()) {
                // if the first value at the first index is bigger than next value it will swap
                if (index == 0){
                    if (i.getData().compareTo(i.getNext().getData()) > 0){
                        swapped = true;
                        swap(i, i.getNext());
                    }
                }
                // If the first value is bigger than the second value it will swap them
                if (i.getNext().getData().compareTo(i.getNext().getNext().getData()) > 0) {
                    swapped = true;
                    swap3(i, i.getNext(), i.getNext().getNext());
                }

                index++;
            }

            R--;
        }
    }

    // swaps the first element with the second if i > j
    private void swap(Node i, Node j){
        Node tmp = j.getNext();
        head = j;
        i.setNext(tmp);
        head.setNext(i);
        swapCount++;
    }

    // swaps if i > j
    private void swap3(Node i, Node j, Node k){
        Node tmp = k.getNext();
        i.setNext(k);
        k.setNext(j);
        j.setNext(tmp);
        swapCount++;
    }

    // returns the number of swaps
    public int getSwapCount(){
        return swapCount;
    }

    // Resets the linked list
    public void reset(){
        head = null;
    }

    // Counts the number of inversions.
    public int inversions() {
        Node curr = this.head;
        int count = 0;
        // loops through the first pointer
        while(curr != null) {
            Node inner = curr.getNext();
            // Loops through the second pointer
            while (inner != null) {
                // If the second pointers value is bigger than first pointers value ++ index.
                if (inner.getData().compareTo(curr.getData()) < 0) {
                    count++;
                }

                inner = inner.getNext();
            }

            curr = curr.getNext();
        }

        return count;
    }

    int getNodeSize(Node n){
        int nodeSize = 0;
        while (n != null){
            n = n.getNext();
            nodeSize++;
        }
        return nodeSize;
    }
    Node sortedMerge(Node a, Node b)
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.getData().compareTo(b.getData()) <= 0)
        {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
        }
        else
        {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
            numberInv = numberInv + (getNodeSize(getMiddle(a))) ;

        }
        return result;

    }

    Node mergeSort(Node h)
    {
        // Base case : if head is null
        if (h == null || h.getNext() == null)
        {
            return h;
        }

        // get the middle of the list
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.getNext();

        // set the next of middle node to null
        middle.setNext(null);

        // Apply mergeSort on left list
        Node left = mergeSort(h);

        // Apply mergeSort on right list
        Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list
    Node getMiddle(Node h)
    {
        //Base case
        if (h == null)
            return h;
        Node fastptr = h.getNext();
        Node slowptr = h;

        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null)
        {
            fastptr = fastptr.getNext();
            if(fastptr!=null)
            {
                slowptr = slowptr.getNext();
                fastptr=fastptr.getNext();
            }
        }
        return slowptr;
    }

    public int betterInversion(){
        Node head = this.head;
        mergeSort(head);

        return numberInv;
    }
    // returns list as a string
    public String toString() {
        String list = "";
        list += "[" + this.head.getData() + "]";

        Node curr = head.getNext();
        while (curr != null){
            list += "[" + curr.getData() + "]";
            curr = curr.getNext();
        }

        return list;

    }
}
