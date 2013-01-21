package org.sith.algorithms.datastructures.graph;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: afedorov
 * Date: 11/20/12
 * Time: 8:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphTest {


    @Test
    public void test() throws Exception {

        Graph graph = new Graph();


        graph.addEdge(1, 2, false);
        graph.addEdge(1, 3, true);
        graph.addEdge(1, 4, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 4, true);


        assertThat(graph.edges(1).size(), is(3));
        assertThat(graph.edges(2).size(), is(1));
        assertThat(graph.edges(3).size(), is(2));



    }


}
