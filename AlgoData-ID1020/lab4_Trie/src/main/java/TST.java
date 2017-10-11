import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sebastianporling on 2017-09-20.
 */
public class TST
{
     Node root = new Node(); // root of trie

    public class Node
    {
        char c;                                 // character
        HashMap<Character, Node> children;      // HashMap with child nodes
        Integer val;                            // value associated with string
        public Node(){
            children = new HashMap<Character, Node>();
            val = 0;
        }
    }
    // Putting new word into tree
    public void put(String key){
        put(root, key, 0);
    }
    // Putting in new word starting from the first node
    private void put(Node current, String key, int index){
        //If the node has reached the end of the word put it into the map
        if (index == key.length()){
            current.val = current.val + 1;
            return;
        }
        char ch = key.charAt(index);
        Node node = current.children.get(ch);

        // If the node does not exist in map then crete one and put it into the map
        if (node == null){
            node = new Node();
            node.c = ch;
            node.val = 0;
            current.children.put(ch, node);
        }
        put(node, key, index + 1);
    }
    // Get the value of the asked word
    public Integer get(String key){
        Node x = get(root, key, 0);
        if (x == null) return null;
        // Return the value of the word
        return  x.val;
    }
    private Node get(Node current, String key, int index){
        // If the word doesn't exist return null
        if (current == null) return null;
        // Search for the word by splitting up the characters one by one. Starting with the first
        char c = key.charAt(index);
        Node node = current.children.get(c);
        // If the child node is null return null
        // If we have not reached the end of the length of the word start with the next one.
        // If the last character is the same as the last node return node
        if (node == null) return null;
        if (index < key.length() - 1) return get(node, key, index + 1);
        else if (c == node.c) return node;
        else return null;
    }
    // Count the frequency of all the word with the asked prefix
    public int count(String prefix){
        Node x = get(root, prefix, 0);
        if (x == null) return 0;
        // return prefix value + the childrens value
        return x.val + count(x);

    }

    private int count(Node current){
        int count = 0;
        // If there are no more letters return 0
        if (current == null) return 0;
        // Look through every child if they are not null then add there value to the counter
        for (char i = 0; i < 255; i++) {
            Node c = current.children.get(i);
            if (c != null){
                count += c.val;
            }
            count += count(c);
        }
        return count;
    }

    // Search for how many words there are with the asked prefix
    public int distinct(String prefix){
        Node x = get(root, prefix, 0);
        return distinct(x);
    }

    private int distinct(Node current){
        int count = 0;
        // If there are no more letters return 0
        if (current == null) return 0;
        // Look through all children and add 1 for all of them.
        for (char i = 0; i < 255; i++) {
            Node c = current.children.get(i);
            if (c != null){
                if (c.val > 0) count += 1;
            }
            count += distinct(c);
        }
        return count;
    }
    // Make a iterator
    public Iterator iterator(String prefix) {
        return new IterateTrie(prefix, root);
    }

    public class IterateTrie implements Iterator<Map.Entry<String, Integer>> {
        // root in this case is the node of the prefix
        String prefix;
        Node root;
        //
        private int nodesToVisit;
        private int nodesVisited;

        public IterateTrie(String prefix, Node head){
            this.prefix = prefix;
            this.root = head;

        }
        // Checks if there are nodes left to visit.
        public boolean hasNext() {
            // Check if we get null by calling next
            Entry next = next();
            nodesToVisit--;

            return next != null;
        }
        // Helper method to call next, and advancing through the iterator
        public Entry next(){
            nodesToVisit++;
            nodesVisited = -1;

            return next(root, prefix);
        }
        // Visit a child node of a given node and return its entry with key-value.
        // Advance to a new child at every iteration
        private Entry next(Node current, String key){
            // Visiting a node
            nodesVisited++;
            // When we have visited the planned nodes to visit
            // Then return an Entry with Key and Value to the recursive call
            if(nodesVisited == nodesToVisit){
                return new Entry(key, current.val);
            }
            // Visit recursively all the valid children of the node and return the entry
            for (char c = 97; c < 123; c++){
                if (current.children.get(c) != null){
                    Entry next = next(current.children.get(c), key + c);

                    if(next != null) return next;
                }
            }
            // No more children nodes to visit the return null
            return null;
        }
        public class Entry implements Map.Entry<String, Integer>, Comparable<Entry>{
            public String key;
            public Integer value;

            public Entry(String key, Integer value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String getKey() {
                return key;
            }

            @Override
            public Integer getValue() {
                return value;
            }

            @Override
            public Integer setValue(Integer value) {
                this.value = value;
                return null;
            }

            @Override
            public String toString() {
                return key + "=" + value;
            }

            public int compareTo(Entry etr) {
                if (this.value < etr.value) return -1;
                else if (this.value == etr.value) return 0;
                else return 1;
            }

        }

        public void remove() {

        }

    }

}
