package list;

import se.kth.id1020.util.Attributes;

/**
 * Created by sebastianporling on 2017-09-15.
 */
public class Node{
    // Declare the variables of node
    private Node next;
    private Attributes data;
    private int frequency = 0;
    // Initialize the values and pointers for node.
    public Node(){ this(null,null);}
    public Node(Attributes data) {
        this(data, null);
    }
    public Node(Attributes data, Node next) {
        this.next = next;
        this.data = data;
    }
    // Getters and setter for data, pointer and frequency.
    public Attributes getData() {
        return this.data;
    }

    public void setData(Attributes data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public int getFrequency(){ return this.frequency; }

    public void setFrequency(int frequency){ this.frequency = frequency; }

}

