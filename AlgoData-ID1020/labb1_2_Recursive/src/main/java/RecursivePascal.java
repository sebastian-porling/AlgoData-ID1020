/**
 * Created by sebastianporling on 2017-08-31.
 */

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

// Lab1 1_2 Make a program that has to recursive methods printPascal and binom.
// The program should be able to write pascals upside down and rightside up.
public class RecursivePascal {
    // swap is a boolean for swapping the triangle.
    public boolean swap = false;
    Counter counter = new Counter("operations");

    // binom calculates the value in pascals triangle at (n,k)
    public int binom(int n, int k){
        if (n == k || k == 0){
            counter.increment();
            return 1;
        }
        else {
            counter.increment();
            return binom(n - 1, k - 1) + binom(n - 1, k);
        }

    }
    // printPascal loops through the rows, columns and prints it either first or last row.
    public void printPascal(int n){
        if (n < 0){
            return;
        }
        if (!swap){
            counter.increment();
            printPascal(n - 1);
        }
        for (int i = 0; i <= n ; i++) {
            StdOut.print(binom(n, n-i) + " ");
        }
        StdOut.println();

        if (swap){
            counter.increment();
            printPascal(n - 1);
        }
    }

    public static void main(String[] args) {
        // Implements all methods and variables to main
        RecursivePascal rp = new RecursivePascal();
        // Asks for input and direction of triangle and calls for printPascal
            StdOut.println("How many rows?(Int)");
            while (!StdIn.isEmpty()) {
                int rows = StdIn.readInt();
                StdOut.println("Do you want it upside-down? (true/false)");
                rp.swap = StdIn.readBoolean();
                rp.printPascal(rows);
                StdOut.println(rp.counter.tally());
                StdOut.println("How many rows?(Int)");
            }

    }
}
