package com.company;

import java.util.*;

public class CliqueFinder {
    private static Set<Integer> maxClique = new TreeSet<>();
    public CliqueFinder() {
    }

    public Set<Integer> findMaxClique(Graph graph) {
        List<Vertex> candidates = graph.getVertexList();
        System.out.println(maxClique);
        bnb(graph, maxClique, candidates);
        System.out.println(maxClique);
        return maxClique;
    }

    public void bnb(Graph graph, Set<Integer> curMaxClique, List<Vertex> candidates) {
        if (candidates.isEmpty()) {
            if (maxClique.size() < curMaxClique.size()) {
                maxClique.clear();
                maxClique.addAll(curMaxClique);
            }
            curMaxClique.remove(curMaxClique.toArray()[curMaxClique.size() - 1]);
        }
        for (Vertex vertex : candidates) {
            if (graph.getAdjacentVertexes(vertex).size() + curMaxClique.size() < maxClique.size()) {
                continue;
            }
            Set<Integer> temp_clique = new TreeSet<>();
            temp_clique.addAll(curMaxClique);
            temp_clique.add(vertex.getX());

            Graph graph_ = graph.getSubgraph(graph.getAdjacentVertexes(vertex));

            List<Vertex> new_candidates = graph.getAdjacentVertexes(vertex);
            new_candidates.retainAll(candidates);

            bnb(graph_, temp_clique, new_candidates);
        }

    }


}
