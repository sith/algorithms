package org.sith.algorithms.combinatorics;

import org.sith.algorithms.common.Generator;
import org.sith.algorithms.common.outputs.GraphPaths;
import org.sith.algorithms.common.ResultHandler;
import org.sith.algorithms.common.inputs.VertexQuery;
import org.sith.algorithms.datastructures.graph.Graph;

import java.util.Set;


public class GraphAllPathBackTrackGenerator extends BackTrack<Integer, Integer> implements Generator<VertexQuery, GraphPaths> {

    private final Graph graph;

    public GraphAllPathBackTrackGenerator(Graph graph) {
        this.graph = graph;
    }


    protected Integer[] constructCandidates(Integer[] a, int k, Integer input, int nCandidates) {

        Set<Graph.Edge> edges = graph.edges(a[k - 1]);

        boolean[] inSolution = new boolean[a.length + 1];
        for (int i = 1; i < k; i++) inSolution[a[i - 1]] = true;

        Integer[] candidates = new Integer[edges.size()];

        int count = 0;
        for (Graph.Edge edge : edges) {
            if (!inSolution[edge.getY()]) {
                candidates[count++] = (edge.getY());
            }
        }

        return candidates;
    }

    @Override
    protected void processSolution(Integer[] solutions, int k, Integer input, ResultHandler<Integer, Integer> resultHandler) {
        resultHandler.handle(solutions, k, input);
    }

    protected boolean isSolution(Integer[] a, int k, Integer data) {
        return data.equals(a[k]);
    }


    @Override
    protected void unmakeMove(Integer[] a, int k, Integer input) {
    }

    @Override
    protected void makeMove(Integer[] solutions, int k, Integer input) {
    }


    @Override
    public GraphPaths generate(VertexQuery input) {


        Integer[] a = new Integer[graph.vertexCount()];
        a[0] = input.getX();

        final GraphPaths paths = new GraphPaths();

        backtrack(a, 0, input.getY(), new ResultHandler<Integer, Integer>() {
            @Override
            public void handle(Integer[] a, int k, Integer data) {
                int[] vertexs = new int[k];

                for (int i = 0; i < vertexs.length; i++) {
                    vertexs[i] = a[i];
                }

                paths.addPath(new GraphPaths.Path(vertexs));
            }
        });

        return paths;
    }
}
