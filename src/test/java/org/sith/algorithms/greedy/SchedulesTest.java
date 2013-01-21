package org.sith.algorithms.greedy;

import org.junit.Test;
import org.sith.algorithms.common.greedy.schedules.Job;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Date: 12/11/12
 * Time: 8:14 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class SchedulesTest {

    @Test
    public void test() throws Exception {


        Schedules schedules = new Schedules();

        long schedule = schedules.schedule(new Job(3, 1), new Job(2, 2), new Job(1, 3));

        System.out.println(schedule);

    }@Test
    public void test2() throws Exception {


        Schedules schedules = new Schedules();

        long schedule = schedules.schedule(new Job(3, 5), new Job(1,2));

        System.out.println(schedule);

    }

    @Test
    public void testFromFile() throws Exception {
//        69119377652
//        67311454237
        Scanner sccanner = new Scanner(new FileInputStream("C:\\Users\\afedorov\\Documents\\algorithms\\src\\main\\resources\\jobs"));


        int count = sccanner.nextInt();
        Job[] jobs = new Job[count];
        for (int i = 0; i < count; i++) {
            jobs[i] = new Job(sccanner.nextInt(),sccanner.nextInt());
        }

        Schedules schedules = new Schedules();
        long result = schedules.schedule(jobs);

        System.out.println(result);


    } @Test
    public void testFromFile2() throws Exception {
//        69119377652
//        69547082972
//        69481170731
        Scanner sccanner = new Scanner(new FileInputStream("C:\\Users\\afedorov\\Documents\\algorithms\\src\\main\\resources\\jobs2"));


        int count = sccanner.nextInt();
        Job[] jobs = new Job[count];
        for (int i = 0; i < count; i++) {
            jobs[i] = new Job(sccanner.nextInt(),sccanner.nextInt());
        }

        Schedules schedules = new Schedules();
        long result = schedules.schedule(jobs);

        System.out.println(result);


    }
}

