import edu.princeton.cs.introcs.StdOut;

/**
 * Created by sebastianporling on 2017-09-04.
 */
// This class is the iterative version of the pascals triangle assignment we got in lab 1.
// Just as the improved version of RecursivePascal this also saves the values of binom in an array and only do half of the calculations.
// It mirrors the array at the printout
public class IterativePascal extends ErrorPascal implements Pascal{
    // swap is a boolean which swaps the triangle printout if it is true.
    // arr[][] is an integer array which consists of the values of binom().
    public boolean swap = false;
    public int[][] arr;

    // binom calculates the value in pascals triangle at (n, k).
    public int binom(int n, int k) {
            if (k == 0){
                arr[n][0] = 1;
            }
            else if (k == n){
                arr[n][k] = 1;
            }
            else if(n%2 == 0 && k == n/2){
                arr[n][k] = arr[n-1][k-1] *2;

            } else{
                arr[n][k] = arr[n-1][k-1] + arr[n-1][k];

            }

        return arr[n][k];
    }

    // printPascal takes in the number of rows you want to print out.
    // It sends the number of rows you want to calculate to binom and prints them.
    public void printPascal(int n) {

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= i/2; k++) {
                binom(i, k);
            }
        }
        if (swap){
            for (int i = 0; i <= n; i++) {
                for (int k = 0; k <= i; k++) {
                    if (k <= i/2) {
                        StdOut.print(arr[i][k] + " ");
                    } else {
                        StdOut.print(arr[i][i - k] + " ");
                    }
                }
                StdOut.println();
            }
        } else {
            for (int i = n; i >= 0; i--) {
                for (int k = 0; k <= i; k++) {
                    if (k <= i/2) {
                        StdOut.print(arr[i][k] + " ");
                    } else {
                        StdOut.print(arr[i][i-k] + " ");
                    }
                }
                StdOut.println();
            }
        }
    }
}
