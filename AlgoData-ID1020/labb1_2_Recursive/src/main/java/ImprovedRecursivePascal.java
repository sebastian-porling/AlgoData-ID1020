import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.Stopwatch;

/**
 * Created by sebastianporling on 2017-08-31.
 */
// Lab1 1_2 Make a program that has to recursive methods printPascal and binom.
// The program should be able to write pascals upside down and rightside up.
// This version should have a memory structure and better performance
public class ImprovedRecursivePascal {
    // swap is a boolean for swapping the triangle.
    // arr is an array which consists of the calculated values of binom.
    public boolean swap = false;
    public int[][] arr;
    public Counter counter = new Counter("Operations");

    public int binom(int n, int k){
        if (n == k){
            counter.increment();
            arr[n][k] = 1;
            return 1;
        } else if(k == 0 ) {
            counter.increment();
            arr[n][0] = 1;
            return 1;
        } else if(arr[n][k] == 0) {
            counter.increment();
            return arr[n][k] = (arr[n-1][k-1] = binom(n - 1, k - 1)) + (arr[n-1][k] = binom(n - 1, k));
        }
        else {
            return arr[n][k];
        }
    }
    public void printPascal(int n){

        if (n < 0){
            return;
        }
        if (!swap){
            counter.increment();
            printPascal(n - 1);
        }
        for (int i = 0; i <= n ; i++){
            if (i <= n/2) {
                StdOut.print(binom(n, i) + " ");
            } else {
                StdOut.print(arr[n][n-i] + " ");
            }
        }

        StdOut.println();

        if (swap){
            counter.increment();
            printPascal(n - 1);
        }

    }
    public static void main(String[] args) {
        ImprovedRecursivePascal rp = new ImprovedRecursivePascal();

        StdOut.println("How many rows?(Int)");

        while (!StdIn.isEmpty()) {

            int rows = StdIn.readInt();
            StdOut.println("Do you want it upside-down? (true/false)");
            rp.swap = StdIn.readBoolean();

            Stopwatch stopwatch = new Stopwatch();
            rp.arr = new int[rows+1][rows/2+1];
            rp.printPascal(rows);

            StdOut.println(rp.counter.tally());

            double time = stopwatch.elapsedTime();
            StdOut.println(time);

            StdOut.println("How many rows?(Int)");
        }
    }

}
