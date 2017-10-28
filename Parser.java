package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Parser {
    public String fileName;

    public static Graph  readData(String fileName) throws IOException{
        String str = "";
        Scanner sc = new Scanner(new File(fileName));
        while(sc.hasNext()&&!str.equals("p")) str = sc.next();
        sc.next();
        int n = sc.nextInt();
        Graph graph = new Graph();
        graph.setVertexNumber(n);
        int m = sc.nextInt();
        graph.setEdgesNumber(m);
        while (sc.hasNext()){
            sc.next();
            int i = sc.nextInt();
            int j = sc.nextInt();
            Vertex x1 = new Vertex();
            Vertex x2 = new Vertex();
            x1.setX(i);
            x2.setX(j);
            graph.addEdge(x1,x2);
        }
        sc.close();
        //System.out.print(graph.getVertexMap());
        return graph;
    }
}
