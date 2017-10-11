import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Word;

import java.util.ArrayList;

/**
 * Created by sebastianporling on 2017-09-29.
 */
public class Node implements Comparable<Node>{

    //Word word;                      // Word contains word and PartOfSpeach
    String word;
    ArrayList<Attributes> attr;     // ArrayList with Attrubutes with contains Document(Name, Popularity), occurence.

    // Constructor adds new node
    public Node(Word word){
        this.word = word.word.toLowerCase();
        this.attr = new ArrayList<Attributes>();
    }

    // Inserts Attribute to list
    public void insertAttr(Attributes attr){
        this.attr.add(attr);
        if (this.attr.contains(attr)) ;
    }


    // Compares this node with o. Only compares the words.
    public int compareTo(Node o) {
        return this.word.compareTo(o.word);
    }
}