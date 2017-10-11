
import list.*;
import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.*;

import java.util.ArrayList;

import java.util.List;


/**
 * Created by sebastianporling on 2017-09-27.
 */

public class TinySearchEngine implements TinySearchEngineBase {

    // Declaring and initializing lists.
    private ArrayList<Node> al;
    private BinarySearch find;

    public TinySearchEngine() {
        al = new ArrayList<Node>();
        find = new BinarySearch();
    }

    // Takes in word and the attribute which as associated with word. And adds them with binarysearch to list.
    // Doesn't add duplicates of the same attribute and adds the different attribute of the same word to another list.
    public void insert(Word word, Attributes attr) {
        // Create a node with new word and its attribute
        Node x = new Node(word);
        x.insertAttr(attr);

        // Looks for the index of the word.
        int index = find.sort(x.word.toLowerCase(), al);

        // If there are no elements in the array add it.
        if (al.size() == 0) {

            al.add(index, x);

            // If the word exists already add the attributes.
        } else if (al.get(index).compareTo(x) == 0) {

            Node temp = al.get(index);
            temp.insertAttr(attr);
            al.set(index, temp);

        } else {

            al.add(index, x);

        }

    }

    private boolean isSorted(ArrayList<Node> test) {
        boolean sorted = true;
        for (int i = 0; i < test.size() - 4; i++) {
            if (test.get(i).compareTo(test.get(i + 1)) < 0) sorted = false;
        }
        return sorted;
    }

    // Takes in a query. Splits it and search for the asked words. And sorts the documents as the query asked for.
    public List<Document> search(String query) {
        // Initializing arrays. And splitting up the query
        String[] words = query.split(" ");
        String keys[] = new String[words.length];

        String property = "";
        String direction = "";

        // Putting in words in the array keys, and putting property and direction into strings.
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("orderby")) {
                if (words[i + 1] == null) {
                    System.err.println("Property of your wished order is missing.");
                    return null;
                } else {
                    property = words[i + 1];
                }

                if (words[i + 2] != null) {
                    direction = words[i + 2];
                }

                break;
            } else {
                keys[i] = words[i];
            }
        }

        // Printing out property, direction and the asked words to query.
        System.out.println("Property: " + property);
        System.out.println("Direction: " + direction);
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                System.out.println("Word " + i + " : " + keys[i]);
            }
        }

        List<Attributes> list = new ArrayList();

        // Goes through all words and adding the words document-objects to a list.
        // Then adds the list to another list.
        for (String key : keys) {

            if (key != null) {

                // Gets the index for the searched key/word
                int index = find.search(key.toLowerCase(), al);

                // If the index is -1 it means that the word does not exist.
                // Prints that it doesn't exist and returns null
                if (index == -1) {

                    System.err.println(key + " does not exist.");
                    return null;

                    // If it does exist
                } else {

                    // Add all of the keys attributes to a list.
                    for (int j = 0; j < al.get(index).attr.size(); j++) {
                        list.add(al.get(index).attr.get(j));
                    }
                }
            }
        }

        // Adds all the elements of arraylist to the linked list
        System.out.println(list.size() + " elements to sort.");
        LinkedList sortedList = new LinkedList(property, direction);
        for (Attributes aList : list) {
            //System.out.println(aList.document);
            sortedList.add(aList);
        }


        // sorting
        sortedList.bubblesort();

        // Adds the result of the sorting to an arraylist.
        List<Document> res = new ArrayList<Document>();
        list.Node tempN = sortedList.head;
        while (tempN != null) {
            if (!res.contains(tempN.getData().document)) {
                res.add(tempN.getData().document);
            }
            tempN = tempN.getNext();
        }


        // Resets the linkedlist
        sortedList.head = null;

        return res;
    }
}
