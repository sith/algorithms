package org.sith.algorithms.combinatorics;

import org.junit.Test;
import org.sith.algorithms.common.outputs.GraphPaths;
import org.sith.algorithms.common.inputs.VertexQuery;
import org.sith.algorithms.datastructures.graph.Graph;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Date: 11/20/12
 * Time: 9:47 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class GraphAllPathBackTrackGeneratorTest {

    @Test
    public void test1() throws Exception {

        Graph graph = new Graph();
        graph.addEdge(1, 2, false);
        graph.addEdge(1, 3, false);
        graph.addEdge(2, 4, false);
        graph.addEdge(1, 4, false);
        GraphAllPathBackTrackGenerator generator = new GraphAllPathBackTrackGenerator(graph);

        GraphPaths result = generator.generate(new VertexQuery(1, 4));

        assertThat(result.getPaths().size(), is(2));
    }

    @Test
    public void test2() throws Exception {

        Graph graph = new Graph();
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 3, false);
        GraphAllPathBackTrackGenerator generator = new GraphAllPathBackTrackGenerator(graph);

        GraphPaths result = generator.generate(new VertexQuery(1, 3));

        assertThat(result.getPaths().size(), is(1));
    }

    @Test
    public void test3() throws Exception {

        Graph graph = new Graph();
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(4, 5, false);
        graph.addEdge(5, 6, false);
        graph.addEdge(1, 6, false);
        GraphAllPathBackTrackGenerator generator = new GraphAllPathBackTrackGenerator(graph);

        GraphPaths result = generator.generate(new VertexQuery(1, 6));

        assertThat(result.getPaths().size(), is(2));
    }


    @Test
    public void test4() throws Exception {

        Graph graph = new Graph();
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(4, 5, false);
        graph.addEdge(4, 6, false);
        GraphAllPathBackTrackGenerator generator = new GraphAllPathBackTrackGenerator(graph);

        GraphPaths result = generator.generate(new VertexQuery(5, 6));

        assertThat(result.getPaths().size(), is(0));
    }


    @Test
    public void test5() throws Exception {

        Graph graph = new Graph();
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(4, 5, false);
        graph.addEdge(4, 6, true);
        GraphAllPathBackTrackGenerator generator = new GraphAllPathBackTrackGenerator(graph);

        GraphPaths result = generator.generate(new VertexQuery(5, 6));

        assertThat(result.getPaths().size(), is(0));
    }

    @Test
    public void test6() throws Exception {

        Graph graph = new Graph();
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(4, 5, true);
        graph.addEdge(4, 6, false);
        GraphAllPathBackTrackGenerator generator = new GraphAllPathBackTrackGenerator(graph);

        GraphPaths result = generator.generate(new VertexQuery(6, 5));

        assertThat(result.getPaths().size(), is(0));
    }


    @Test
    public void test7() throws Exception {

        Graph graph = new Graph();
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(4, 5, true);
        graph.addEdge(4, 6, true);
        GraphAllPathBackTrackGenerator generator = new GraphAllPathBackTrackGenerator(graph);

        GraphPaths result = generator.generate(new VertexQuery(6, 5));

        assertThat(result.getPaths().size(), is(1));
    }

}

