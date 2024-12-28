package app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphModel {
    private Map<Integer, List<Integer>> graph;

    // Constructor
    public GraphModel() {
        this.graph = new HashMap<>();
    }

    // add to Graph
    public void addVertex(int vertex) {
        if (!graph.containsKey(vertex)) {
            graph.put(vertex, new ArrayList<>());
        }
    }

    // add Edge to Graph
    public void addEdge(int source, int destination) {
        if (!graph.containsKey(source)) {
            graph.put(source, new ArrayList<>());
        }
        if (!graph.containsKey(destination)) {
            graph.put(destination, new ArrayList<>());
        }
        if (!graph.get(source).contains(destination)) {
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }
    }

    // remove Vertex from Graph
    public void removeVertex(int vertex) {
        if (graph.containsKey(vertex)) {
            graph.remove(vertex);
            for (List<Integer> neighbors : graph.values()) {
                neighbors.remove(Integer.valueOf(vertex));
            }
        }
    }

    // remove Edge
    public void removeEdge(int source, int destination) {
        if (graph.containsKey(source) && graph.containsKey(destination)) {
            graph.get(source).remove(Integer.valueOf(destination));
            graph.get(destination).remove(Integer.valueOf(source));
        }
    }

    // Check Vertex in Graph
    public boolean hasVertex(int vertex) {
        return graph.containsKey(vertex);
    }

    // Check Edge in Graph
    public boolean hasEdge(int source, int destination) {
        return graph.containsKey(source) && graph.get(source).contains(destination);
    }

    // Convert graph to string vision
    public String getGraphRepresentation() {
        return graph.toString();
    }
}

