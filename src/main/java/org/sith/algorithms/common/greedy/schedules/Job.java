package org.sith.algorithms.common.greedy.schedules;

/**
 * Date: 12/11/12
 * Time: 8:00 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class Job {

    private int weight, length;

    public Job(int weight, int length) {
        this.weight = weight;
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public int getLength() {
        return length;
    }
}
