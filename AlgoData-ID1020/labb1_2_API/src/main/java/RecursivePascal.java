/**
 * Created by sebastianporling on 2017-09-04.
 */
import edu.princeton.cs.introcs.StdOut;
// Lab1 1_2 Make a program that has to recursive methods printPascal and binom.
// The program should be able to write pascals upside down and rightside up.
// This version should have a memory structure and better performance
public class RecursivePascal extends ErrorPascal implements Pascal{
    // swap is a boolean for swapping the triangle.
    // arr is an array which consists of the calculated values of binom.
    public boolean swap = false;
    public int[][] arr;

    // binom calculates the value in pascals triangle at (n, k).
    public int binom(int n, int k){
        super.binom(n, k);
        if (n == k){
            arr[n][k] = 1;
            return 1;
        } else if(k == 0 ) {
            arr[n][0] = 1;
            return 1;
        } else if(arr[n][k] == 0) {
            return arr[n][k] = (arr[n-1][k-1] = binom(n - 1, k - 1)) + (arr[n-1][k] = binom(n - 1, k));
        }
        else {
            return arr[n][k];
        }
    }

    // printPascal takes in the number of rows you want to print out.
    // It sends the number of rows you want to calculate to binom and prints them.
    public void printPascal(int n){
        super.printPascal(n);
        if (n < 0){
            return;
        }
        if (swap){
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

        if (!swap){
            printPascal(n - 1);
        }

    }
}
