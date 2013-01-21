package org.sith.algorithms.greedy;

import org.sith.algorithms.datastructures.graph.Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Date: 12/11/12
 * Time: 9:08 PM
 *
 * @author <a href="mailto:fedorov1984@gmail.com">Alexander Fedorov</a>
 */
public class PrimsMST {

    public long calculate(Graph graph) {

        Integer vertex = graph.getVertexes().iterator().next();

        Set<Integer> processedVertexes = new HashSet<>();

        PriorityQueue<Graph.Edge> candidates = new PriorityQueue<>(graph.vertexCount(), new Comparator<Graph.Edge>() {
            @Override
            public int compare(Graph.Edge o1, Graph.Edge o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });


        candidates.addAll(graph.edges(vertex));
        processedVertexes.add(vertex);

        long sum = 0;

        while (candidates.size()>0) {


            Graph.Edge edge = candidates.poll();
            if (processedVertexes.contains(edge.getY())) {
                continue;
            }


            sum += edge.getWeight();
            processedVertexes.add(edge.getX());
            processedVertexes.add(edge.getY());

            candidates.addAll(graph.edges(edge.getY()));


        }
        return sum;

    }


}
