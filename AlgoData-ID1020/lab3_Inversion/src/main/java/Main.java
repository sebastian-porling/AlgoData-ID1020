
/**
 * Created by sebastianporling on 2017-09-17.
 */
public class Main {
    public static void main(String[] args) {
        // Declaring lists.
        LinkedList list = new LinkedList();
        InversionCount count = new InversionCount();

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
        Comparable[] arr = new Comparable[list.getSize()];
        // Putting the elements of the Linked List into an array.
        Node tmp = list.head;
        int i = 0;
        while (tmp != null){
            arr[i] = tmp.getData();
            tmp = tmp.getNext();
            i++;
        }
        // Printing the before and after of bubblesorting a linked list
        System.out.println("Before sorting: " + list);

        list.bubblesort();
        System.out.println("Sorted: " + list);

        // Printing the numbers of inversions and swaps
        System.out.println("Number of swaps: " + list.getSwapCount());

        // Resets the linked list with the same unordered list as before.
        list.reset();
        list.add(14);
        list.add(40);
        list.add(3);
        list.add(30);
        list.add(15);
        list.add(41);
        list.add(6);
        list.add(48);
        list.add(49);
        list.add(35);

        // Prints the inversions of the linked list.
        System.out.println("Number of inversions arr[] (n log n: " + count.invCount(arr));
        System.out.println("Number of inversions linked list (n^2): " + list.inversions());

    }
}
