package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\User\\IdeaProjects\\MaxCliqueBnB\\clq\\johnson8-2-4.clq.txt";
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter the file name: ");
//        String fileName = in.nextLine();
        Graph graph = new Graph();
        graph = Parser.readData(fileName);
        CliqueFinder clique = new CliqueFinder();
        Set<Integer> maxClique = clique.findMaxClique(graph);

    }
}
