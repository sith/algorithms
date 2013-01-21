package org.sith.algorithms.common.inputs;

import org.sith.algorithms.datastructures.graph.Graph;

/**
 * Date: 11/29/12
 * Time: 9:30 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class GraphsInput implements Input {

    private Graph first;
    private Graph second;

    public GraphsInput(Graph first, Graph second) {
        this.first = first;
        this.second = second;
    }


    public Graph getFirst() {
        return first;
    }

    public Graph getSecond() {
        return second;
    }
}
