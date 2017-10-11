/**
 * Created by sebastianporling on 2017-09-15.
 */
public class Node<T extends Comparable<T>>{
    // Declare the variables of node
    private Node next;
    private T data;
    // Initialize the values and pointers for node.
    public Node(){ this(null,null);}
    public Node(T data) {
        this(data, null);
    }
    public Node(T data, Node next) {
        this.next = next;
        this.data = data;
    }
    // Getters and setter for data and pointers.
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

}

