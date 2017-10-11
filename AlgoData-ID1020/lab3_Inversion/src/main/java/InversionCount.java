import java.util.Arrays;

/**
 * Created by sebastianporling on 2017-09-17.
 */
public class InversionCount<T extends Comparable<T>> {
    // takes in the unordered array, the left side and the right side of the array.
    private int merge( T[] arr, T[] left, T[] right) {
        int i = 0, j = 0, count = 0;
        //
        while (i < left.length || j < right.length) {
            // If no elements left in left-array, put the rest of the right-array in.
            if (i == left.length) {
                arr[i+j] = right[j];
                j++;
            // If no elements left in right-array, put the rest of the left-array in.
            } else if (j == right.length) {
                arr[i+j] = left[i];
                i++;
            // If the left element smaller than the right element put right in.
            } else if (left[i].compareTo(right[j]) <= 0) {
                arr[i+j] = left[i];
                i++;
            // if the left element is bigger than the right one it is an inversion. a[i] > a[j] = inversion and i < j
                // In case of mergesort here it is if left[i] > right[j] and i < j == Inversion
                // We have to take in count that it also will be the lenght of the left subarray - 1 inversions,
                // because left and right subarray are sorted, so all the remaining elements in the left-array (a[i], a[i+1] etc.)
                // is greater than a[j]
            } else {
                // If the left element is bigger that the right element put the right in.
                arr[i+j] = right[j];
                count += left.length-i;
                j++;
            }
        }
        return count;
    }
    // Takes in generic array and splits the array in the middle to two arrays, left and right.
    public int invCount(T[] arr) {
        if (arr.length < 2)
            return 0;

        int m = (arr.length + 1) / 2;
        T left[] = Arrays.copyOfRange(arr, 0, m);
        T right[] = Arrays.copyOfRange(arr, m, arr.length);

        return invCount(left) + invCount(right) + merge(arr, left, right);
    }

}
