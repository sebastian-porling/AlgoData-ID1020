import edu.princeton.cs.introcs.StdOut;

/**
 * Created by sebastianporling on 2017-09-04.
 */
public abstract class ErrorPascal implements Pascal{

    public int binom(int n, int k) {
        if (0 > k || k > n){
            StdOut.println("Invalid value");
        }
        return 0;
    }

    public void printPascal(int n) {
        if (n < 0){
            StdOut.println("Invalid value");
        }
    }
}
