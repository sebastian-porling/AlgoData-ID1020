import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.Stopwatch;

/**
 * Created by sebastianporling on 2017-09-04.
 */
public class Driver {
    public static void main(String[] args) {
        RecursivePascal rp = new RecursivePascal();
        IterativePascal ip = new IterativePascal();

        StdOut.println("How many rows?(Int)");

        while (!StdIn.isEmpty()) {
            int rows;
            while (true){
                rows = StdIn.readInt();
                if (rows < 0){
                    StdOut.println("Wrong value");
                }else {
                    break;
                }
            }

            StdOut.println("Do you want it upside-down? (true/false)");
            rp.swap = StdIn.readBoolean();
            ip.swap = rp.swap;



            rp.arr = new int[rows+1][rows/2+1];
            ip.arr = new int[rows+1][rows/2+1];

            StdOut.println("Do you want to run it Recursive?(y/n)");
            String rori = StdIn.readString();
            Stopwatch stopwatch = new Stopwatch();
            if (rori.equals("y")){
                rp.printPascal(rows);
            } else if (rori.equals("n")){
                ip.printPascal(rows);
            } else {
                StdOut.println("Wrong input");
            }

            double time = stopwatch.elapsedTime();

            StdOut.println(time);
            StdOut.println("How many rows?(Int)");
        }
    }
}
