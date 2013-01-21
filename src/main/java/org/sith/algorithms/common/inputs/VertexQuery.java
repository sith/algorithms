package org.sith.algorithms.common.inputs;

import org.sith.algorithms.common.inputs.Input;

/**
 * Date: 11/22/12
 * Time: 8:05 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class VertexQuery implements Input {

    private final int x;
    private final int y;

    public VertexQuery(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
