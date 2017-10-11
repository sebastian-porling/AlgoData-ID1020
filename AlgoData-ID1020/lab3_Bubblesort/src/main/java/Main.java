
/**
 * Created by sebastianporling on 2017-09-17.
 */
public class Main {
    public static void main(String[] args) {
        // Declaring lists.
        LinkedList list = new LinkedList();

        // Initializing list and array.
        /*
        list.add("b");
        list.add("a");
        list.add("h");
        list.add("c");
        list.add("k");
        list.add("u");
        list.add("e");
        list.add("h");
        list.add("t");
        list.add("a");
        */
        list.add(14); // 30 entries
        list.add(40);
        list.add(3);
        list.add(30);
        list.add(15);
        list.add(41);
        list.add(6);
        list.add(48);
        list.add(49);
        list.add(35);

        // Printing the before and after of bubblesorting a linked list
        System.out.println("Before sorting: " + list);

        list.bubblesort();
        System.out.println("Sorted: " + list);

    }
}
