package org.sith.algorithms.common.inputs;

import java.util.Arrays;

/**
* Date: 11/29/12
* Time: 9:50 PM
*
* @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
*/
public class Dial {
    Integer[] phoneNumber;

    public Dial(Integer... phoneNumber) {
        this.phoneNumber = new Integer[phoneNumber.length + 1];
        System.arraycopy(phoneNumber,0, this.phoneNumber,1,phoneNumber.length );
    }

    public Integer[] getPhoneNumber() {
        return phoneNumber;
    }
}
