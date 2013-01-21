package org.sith.algorithms.greedy;

import org.junit.Test;
import org.sith.algorithms.common.greedy.schedules.Job;
import org.sith.algorithms.datastructures.graph.Graph;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Date: 12/11/12
 * Time: 9:26 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class PrimsMSTTest {



    @Test
    public void testFromFile2() throws Exception {
//        69119377652
//        69547082972
//        69481170731
        Scanner sccanner = new Scanner(new FileInputStream("C:\\Users\\afedorov\\Documents\\algorithms\\src\\main\\resources\\graph"));


        int vertex = sccanner.nextInt();
        int edges = sccanner.nextInt();
        Graph graph = new Graph();
        while (sccanner.hasNextInt()) {
            graph.addEdge(sccanner.nextInt(), sccanner.nextInt(), sccanner.nextInt(), true);
        }

        PrimsMST primsMST = new PrimsMST();

        long result = primsMST.calculate(graph);
        System.out.println(result);


    }

    @Test
    public void test() throws Exception {
//        69119377652
//        69547082972
//        69481170731



        Graph graph = new Graph();
        graph.addEdge(1,2,1,true);
        graph.addEdge(2,3,1,true);
        graph.addEdge(3,1,1,true);
        graph.addEdge(2,5,1,true);

        PrimsMST primsMST = new PrimsMST();

        long result = primsMST.calculate(graph);
        System.out.println(result);


    }

}
