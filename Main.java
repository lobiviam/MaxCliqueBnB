package com.company;

import java.util.List;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Main {
    static Time mThing;
    public static void main(String[] args) throws IOException {
//        String fileName = "C:\\Users\\User\\IdeaProjects\\MaxCliqueBnB\\clq\\johnson8-4-4.clq.txt";
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter the file name: ");
//        String fileName = in.nextLine();
        int timeLimit = args.length > 1 ? parseInt(args[1]) : 3600;
        Time mThing = new Time();
        Time.setTimeLimit(timeLimit);
        Thread myThready = new Thread(mThing);	//Создание потока "myThready"
        myThready.start();
        String fileName = args[0];

        Graph graph = new Graph();
        long startTime = System.currentTimeMillis();
        // ... do something ...
        graph = Parser.readData(fileName);
        CliqueFinder clique = new CliqueFinder();
        List<Integer> maxClique = clique.findMaxClique(graph);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(maxClique.size());
        System.out.println("Time : " + estimatedTime);
        myThready.interrupt();
    }
}
