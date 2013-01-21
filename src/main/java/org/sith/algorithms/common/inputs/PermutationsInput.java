package org.sith.algorithms.common.inputs;

import org.sith.algorithms.common.inputs.Input;

/**
 * Date: 11/22/12
 * Time: 8:56 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class PermutationsInput implements Input {

    private final Integer[] value;

    public PermutationsInput(Integer[] value) {
        this.value = value;
    }

    public Integer[] getValue() {
        return value;
    }
}
