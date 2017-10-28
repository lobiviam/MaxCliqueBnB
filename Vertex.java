package com.company;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {

    private int x;
    private int degree;
    ArrayList<Vertex> adjacentV = new ArrayList<Vertex>();

    Vertex(){
        super();
    }

    Vertex(int x){
        this.x =x;
    }

    public void addAdjacentV(Vertex x) {
        this.adjacentV.add(x);
        if (!x.getAdjacentV().contains(this)) {
            x.addAdjacentV(this);
            x.degree++;
        }
        this.degree++;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public ArrayList<Vertex> getAdjacentV() {
        return adjacentV;
    }

    public void setAdjacentV(ArrayList<Vertex> adjacentV) {
        this.adjacentV = adjacentV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;

        Vertex vertex = (Vertex) o;

        if (getX() != vertex.getX()) return false;
        if (getDegree() != vertex.getDegree()) return false;
        return getAdjacentV() != null ? getAdjacentV().equals(vertex.getAdjacentV()) : vertex.getAdjacentV() == null;
    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getDegree();
        result = 31 * result + (getAdjacentV() != null ? getAdjacentV().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Vertex x) {
        if (this.degree < x.degree) {
            return -1;
        }
        if (this.degree > x.degree) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(x);
    }


}
