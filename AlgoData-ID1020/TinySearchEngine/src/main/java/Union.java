import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sebastianporling on 2017-09-29.
 */
// Not using anymore because it doesn't retain the sorted lists order
public class Union {
    // Union of two lists
    public <T> List<T> union(List<T> list1) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);

        return new ArrayList<T>(set);
    }
}
