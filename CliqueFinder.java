package com.company;

import java.util.*;

public class CliqueFinder {
    long startTime;
    long timeLimit;
    private static List<Integer> maxClique = new LinkedList<>();

    public CliqueFinder() {
    }

    public List<Integer> findMaxClique(Graph graph) {
        startTime = System.currentTimeMillis();
        List<Vertex> candidates = graph.getVertexList();
        bnb(graph, new LinkedList<>(), candidates);
        System.out.println(maxClique.size());
        for (Integer node : maxClique) {
            System.out.print(node + " ");

        }
        return maxClique;
    }

    public void bnb(Graph graph, List<Integer> curMaxClique, List<Vertex> candidates) {
        if (maxClique.size() < curMaxClique.size()) {
            maxClique.clear();
            maxClique.addAll(curMaxClique);
        }
        if (candidates.size() == 0) {
            curMaxClique.remove(curMaxClique.size() - 1);
            return;
        }
        if (candidates.size() + curMaxClique.size() < maxClique.size()) {
            return;
        }
        for (Vertex vertex : candidates) {
            List<Integer> temp_clique = new LinkedList<>();
            temp_clique.addAll(curMaxClique);
            temp_clique.add(vertex.getX());

            Graph graph_ = graph.getSubgraph(graph.getAdjacentVertexes(vertex));

            List<Vertex> new_candidates = graph.getAdjacentVertexes(vertex);
            new_candidates.retainAll(candidates);

            bnb(graph_, temp_clique, new_candidates);
        }

    }

    void setTimeLimit(String time) {
        timeLimit = Long.valueOf(time);
    }

}
