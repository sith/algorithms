package org.sith.algorithms.datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Graph {

    private Map<Integer, Vertex> edges = new HashMap<>();
    private Set<Integer> vertexes = new HashSet<>();

    public void addEdge(int x, int y, boolean direction) {

        vertexes.add(x);
        vertexes.add(y);

        Vertex vertex = this.edges.get(x);
        if (vertex == null) {
            vertex = new Vertex(x);
            this.edges.put(x, vertex);
        }
        vertex.addEdge(new Edge(x, y));
        if (direction) {
            addEdge(y, x, false);
        }
    }

    public int vertexCount() {
        return vertexes.size();
    }


    public Set<Edge> edges(int node) {
        Vertex vertex = edges.get(node);
        if (vertex == null) {
            return new HashSet<>();
        }
        return vertex.edges;
    }

    public Set<Integer> getVertexes() {
        return vertexes;
    }

    public void addEdge(int x, int y, int weight, boolean direction) {
        vertexes.add(x);
        vertexes.add(y);

        Vertex vertex = this.edges.get(x);
        if (vertex == null) {
            vertex = new Vertex(x);
            this.edges.put(x, vertex);
        }
        vertex.addEdge(new Edge(x, y, weight));
        if (direction) {
            addEdge(y, x, weight, false);
        }

    }

    public int dfs() {

        Integer vertex = vertexes.iterator().next();

        return recursiveDfs(vertex, new HashSet<Integer>());
    }

    private int recursiveDfs(Integer vertexLabel, Set<Integer> integers) {
        Vertex vertex = edges.get(vertexLabel);
        int result = 1;


        Set<Edge> edgeSet = vertex.edges;
        integers.add(vertexLabel);
        for (Edge edge : edgeSet) {
            if (integers.contains(edge.getY())) {
                continue;
            }
            result += recursiveDfs(edge.getY(), integers);
        }

        return result;
    }

    public static class Vertex {
        int nodeName;
        Set<Edge> edges = new HashSet<>();


        Vertex(int nodeName) {
            this.nodeName = nodeName;
        }


        public void addEdge(Edge edge) {
            edges.add(edge);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            if (nodeName != vertex.nodeName) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return nodeName;
        }
    }

    public static class Edge {
        int x, y;
        int weight;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getWeight() {
            return weight;
        }

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (x != edge.x) return false;
            if (y != edge.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

}
