
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import java.net.URL;
import java.util.*;

/**
 * Created by sebastianporling on 2017-09-20.
 */
public class Main {
    public static void main(String[] args) {
        TST tst = new TST();

        URL url = ClassLoader.getSystemResource("kap1.txt");

        if (url != null) {
            System.out.println("Reading from: " + url);
        } else {
            System.out.println("Couldn't find file: kap1.txt");
        }

        In input = new In(url);

        while (!input.isEmpty()) {
            String line = input.readLine().trim().toLowerCase();
            String[] words = line.split("(\\. )|:|,|;|!|\\?|( - )|--|(\' )| ");
            String lastOfLine = words[words.length - 1];

            if (lastOfLine.endsWith(".")) {
                words[words.length - 1] = lastOfLine.substring(0, lastOfLine.length() - 1);
            }

            for (String word : words) {
                String word2 = word.replaceAll("\"|\\(|\\)", "");

                if (word2.isEmpty()) {
                    continue;
                }

                //System.out.println(word2);
                tst.put(word2);
            }
        }
        StdOut.println("\nValue of 'a': " + tst.get("a"));
        StdOut.println("\nCount of 'a': " + tst.count("a"));
        StdOut.println("\n" + tst.distinct("a") + " Distinct words that start with 'a'");
        wordsWithHigtest(tst);
        wordsWithLowest(tst);
        mostCommonLetter(tst);
        longestPrefix(tst);

    }
    public static void wordsWithHigtest(TST trie){
        PriorityQueue<TST.IterateTrie.Entry> highestFreq = new PriorityQueue<TST.IterateTrie.Entry>(10);
        ArrayList<String> prefix2 = new ArrayList<String>();
        Iterator<TST.IterateTrie.Entry> itr = trie.iterator(" ");
        while (itr.hasNext()) {
            TST.IterateTrie.Entry entr = itr.next();
            if (entr.getValue() > 0) {
                highestFreq.add(entr);
                if (entr.getKey().length() > 2 && !prefix2.contains(entr.getKey())) {
                    prefix2.add(entr.getKey().substring(0, 2));
                }
                if (highestFreq.size() > 10) { highestFreq.poll(); }
            }
        }
        System.out.println("\nTen of the most common words are: " + highestFreq);

    }
    public static void wordsWithLowest(TST trie){
        PriorityQueue<TST.IterateTrie.Entry> lowestFreq = new PriorityQueue<TST.IterateTrie.Entry>(10, Collections.reverseOrder());
        ArrayList<String> prefix2 = new ArrayList<String>();
        Iterator<TST.IterateTrie.Entry> itr = trie.iterator(" ");
        while (itr.hasNext()) {
            TST.IterateTrie.Entry entr = itr.next();
            if (entr.getValue() > 0) {
                lowestFreq.add(entr);
                if (entr.getKey().length() > 2 && !prefix2.contains(entr.getKey())) {
                    prefix2.add(entr.getKey().substring(0, 2));
                }
                if (lowestFreq.size() > 10) { lowestFreq.poll(); }

            }
        }
        System.out.println("\nTen of the least common words are: " + lowestFreq);

    }
    public static void longestPrefix(TST trie){
        int mostWords = 0;
        String prefix = "";
        for (char i = 97; i < 123; i++) {
            for (char j = 97; j < 123; j++) {
                String bla = i + "" + j;
                int current = trie.count(bla);
                if (mostWords < current){
                    prefix = i + "" + j;
                    mostWords = current;
                }
            }

        }
        StdOut.println("\nPrefix with highest frequency: " + prefix );
    }
    public static void mostCommonLetter(TST trie){
        int mostWords = 0;
        char ch = 'a';
        for (char i = 97; i < 123; i++) {
            String bla = "" + i;
            int current = trie.distinct(bla);

            if (mostWords < current){
                ch = i;
                mostWords = current;
            }
        }
        StdOut.println("\nMost common letter: " + ch);
    }
}

