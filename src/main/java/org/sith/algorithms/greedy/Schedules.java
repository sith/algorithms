package org.sith.algorithms.greedy;

import org.sith.algorithms.common.greedy.schedules.Job;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Date: 12/11/12
 * Time: 7:57 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class Schedules {


    public long schedule(Job... jobs) {

        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                double firstDiff = (double) o1.getWeight() - o1.getLength();
                double secondDiff = (double) o2.getWeight() - o2.getLength();

                int compare = Double.compare(secondDiff, firstDiff);
                if (compare != 0) {
                    return compare;
                }
                int weightDiff = o2.getWeight() - o1.getWeight();

                return weightDiff;

            }
        });


        long completionTime = 0;
        long result = 0;

        for (Job job : jobs) {
            completionTime += job.getLength();
            result += job.getWeight() * completionTime;
        }

        return result;
    }


}
