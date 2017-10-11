/**
 * Created by sebastianporling on 2017-09-29.
 */



import java.util.ArrayList;

public class BinarySearch {
    public BinarySearch() {
    }

    // return the index of the key in the sorted array a[]; -1 if not found
    public static int search(String key, ArrayList<Node> a) {
        return search(key, a, 0, a.size());
    }
     public static int search(String key, ArrayList<Node> a, int lo, int hi) {
         // possible key indices in [lo, hi)
         if (hi <= lo) return -1;
         int mid = lo + (hi - lo) / 2;
         //  System.out.println(a.get(mid).word.word + " : "+ key);
         int cmp = a.get(mid).word.compareTo(key);
         if (cmp > 0) return search(key, a, lo, mid);
         else if (cmp < 0) return search(key, a, mid + 1, hi);
         else {
             // System.out.println(a.get(mid).word.word + " : "+ key);
             return mid;
         }
     }


    public static int sort(String key, ArrayList<Node> a) {
        return sort(key, a, 0, a.size());
    }

    public static int sort(String key, ArrayList<Node> a, int lo, int hi) {
        // possible key indices in [lo, hi)
        // Array is empty so add first.
        if (hi == 0) {
            return 0;
        }
        //  System.out.println(a.get(mid).word.word + " : "+ key);

        // If it doesn't exist add it last.
        if (hi <= lo) {
            return a.size() - 1;
        }

        // Compares the current mid with key
        int mid = lo + (hi - lo) / 2;
        int cmp = a.get(mid).word.compareTo(key);

        // if high is smaller <= to low or high is smaller that 2
        if (hi <= lo || hi < 2) {
            // if the comparing is less than 0 add it on the last index
            if (cmp < 0) {
                return a.size() - 1;
            }

            // if the comparing is bigger than 0 add it on the first index
            if (cmp > 0) {
                return 0;
            }

            // if the comparing is bigger than 0 and it is bigger than the mid -1 return mid as new index.
        } else if (cmp > 0 && a.get(mid - 1).word.compareTo(key) < 0) {
            // System.out.println(a.get(mid).word.word + " : "+ key);
            return mid;
        } else if (cmp > 0) return sort(key, a, lo, mid); // go left in array
        else if (cmp < 0) return sort(key, a, mid + 1, hi); // go right in array
        //System.out.println(a.get(mid).word.word + " : "+ key);
        // returns only if the key and a[mid] is the same.
        return mid;

    }
}

