package org.sith.algorithms.common;

import org.sith.algorithms.common.inputs.Input;
import org.sith.algorithms.common.outputs.Output;

/**
 * Date: 11/22/12
 * Time: 8:00 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public interface Generator<I extends Input, O extends Output> {

    public O generate(I input);

}
