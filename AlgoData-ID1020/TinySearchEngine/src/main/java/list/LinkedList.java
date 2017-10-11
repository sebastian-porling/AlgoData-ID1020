package list;

import se.kth.id1020.util.Attributes;

/**
 * Created by sebastianporling on 2017-09-15.
 */
public class LinkedList {
    // Declare first node in the list, size and the number of swaps
    public Node head;
    private int size;
    private String property;
    private String direction;

    // Initialize the list
    public LinkedList(String property, String direction) {
        head = null;
        size = 0;
        if(!property.equals("") && direction.equals("")){
            this.property = property;
            this.direction = "asc";
        }
        if (property.equals("") && direction.equals("")){
            this.property = "popularity";
            this.direction = "asc";
        } else {
            this.property = property;
            this.direction = direction;
        }

    }

    // Adds a node to the list, if list is empty the first node = new node
    // If the list is not empty add the node last.
    public void add(Attributes data) {
        // Initialize new node and make temporary node we can loop through
        Node temp = new Node(data);
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
                if (direction.equals("asc")) {
                    // if the first value at the first index is bigger than next value it will swap
                    if (index == 0) {
                        if (property.equals("occurrence")) {
                            if (i.getData().occurrence - i.getNext().getData().occurrence > 0) {
                                swapped = true;
                                swap(i, i.getNext());
                            }
                        } else if (property.equals("popularity")) {
                            if (i.getData().document.popularity - i.getNext().getData().document.popularity > 0) {
                                swapped = true;
                                swap(i, i.getNext());
                            }
                        } else {
                            if (i.getFrequency() == 0){ i.setFrequency(frequency(i)); }
                            if (i.getNext().getFrequency() == 0){ i.getNext().setFrequency(frequency(i.getNext())); }
                            if (i.getFrequency() - i.getNext().getFrequency() < 0) {
                                swapped = true;
                                swap(i, i.getNext());
                            }
                        }

                    }
                    // If the first value is bigger than the second value it will swap them
                    if (property.equals("occurrence")) {
                        if (i.getNext().getData().occurrence - i.getNext().getNext().getData().occurrence > 0) {
                            swapped = true;
                            swap3(i, i.getNext(), i.getNext().getNext());
                        }
                    } else if (property.equals("popularity")) {
                        if (i.getNext().getData().document.popularity - i.getNext().getNext().getData().document.popularity > 0) {
                            swapped = true;
                            swap3(i, i.getNext(), i.getNext().getNext());
                        }
                    } else {
                        if (i.getNext().getFrequency() == 0){ i.getNext().setFrequency(frequency(i.getNext())); }
                        if (i.getNext().getNext().getFrequency() == 0){ i.getNext().getNext().setFrequency(frequency(i.getNext().getNext())); }
                        if (i.getNext().getFrequency() - i.getNext().getNext().getFrequency() < 0) {
                            swapped = true;
                            swap3(i, i.getNext(), i.getNext().getNext());
                        }
                    }
                } else {
                    // if the first value at the first index is bigger than next value it will swap
                    if (index == 0) {
                        if (property.equals("occurrence")) {
                            if (i.getData().occurrence - i.getNext().getData().occurrence < 0) {
                                swapped = true;
                                swap(i, i.getNext());
                            }
                        } else if (property.equals("popularity")) {
                            if (i.getData().document.popularity - i.getNext().getData().document.popularity < 0) {
                                swapped = true;
                                swap(i, i.getNext());
                            }
                        } else {
                            if (i.getFrequency() == 0){ i.setFrequency(frequency(i)); }
                            if (i.getNext().getFrequency() == 0){ i.getNext().setFrequency(frequency(i.getNext())); }
                            if (i.getFrequency() - i.getNext().getFrequency() < 0) {
                                swapped = true;
                                swap(i, i.getNext());
                            }
                        }

                    }
                    // If the first value is bigger than the second value it will swap them
                    if (property.equals("occurrence")) {
                        if (i.getNext().getData().occurrence - i.getNext().getNext().getData().occurrence < 0) {
                            swapped = true;
                            swap3(i, i.getNext(), i.getNext().getNext());
                        }
                    } else if (property.equals("popularity")) {
                        if (i.getNext().getData().document.popularity - i.getNext().getNext().getData().document.popularity < 0) {
                            swapped = true;
                            swap3(i, i.getNext(), i.getNext().getNext());
                        }
                    } else {
                        if (i.getNext().getFrequency() == 0){ i.getNext().setFrequency(frequency(i.getNext())); }
                        if (i.getNext().getNext().getFrequency() == 0){ i.getNext().getNext().setFrequency(frequency(i.getNext().getNext()));}
                        if (i.getNext().getFrequency() - i.getNext().getNext().getFrequency() < 0) {
                            swapped = true;
                            swap3(i, i.getNext(), i.getNext().getNext());
                        }
                    }
                }

                index++;
            }

            R--;
        }

    }

    // Counts the frequency of given word
    private int frequency( Node x ){
        int counter = 0;
        Node temp = head;
        while (temp.getNext() != null){
            if (temp.getData().document.equals(x.getData().document)){
                counter++;
            }
            temp = temp.getNext();
        }
        return counter;
    }

    // swaps the first element with the second if i > j
    private void swap( Node i, Node j){
        Node tmp = j.getNext();
        head = j;
        i.setNext(tmp);
        head.setNext(i);
    }

    // swaps if i > j
    private void swap3(Node i, Node j, Node k){
        Node tmp = k.getNext();
        i.setNext(k);
        k.setNext(j);
        j.setNext(tmp);
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
