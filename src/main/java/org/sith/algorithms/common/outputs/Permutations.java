package org.sith.algorithms.common.outputs;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 11/22/12
 * Time: 8:57 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class Permutations<T> implements Output {

    private final List<SingleResult<T>> results = new ArrayList<>();


    public void addResult(SingleResult<T> result) {
        results.add(result);
    }

    public List<SingleResult<T>> getResults() {
        return results;
    }

    public static class SingleResult<T> {
        private final T[] array;

        public SingleResult(T[] array) {
            this.array = array;
        }

        public T[] getArray() {
            return array;
        }
    }


}
