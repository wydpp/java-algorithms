package com.dpp.graph;

import java.util.LinkedList;

/**
 * @author dpp
 * @date 2024/8/13
 * @Description 完全图
 */
public class CompleteGraph {

    private int v; // 顶点的个数
    private LinkedList<Edge>[] adj; // 邻接表

    public CompleteGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) {
        adj[s].add(new Edge(t, w));
        adj[t].add(new Edge(s, w));
    }

    public int getV() {
        return v;
    }

    public LinkedList<Edge> getEdges(int s) {
        if (s > v -1){
            throw new IllegalArgumentException("s is out of bound");
        }
        return adj[s];
    }

    public static class Edge {
        //指向的顶点
        int targetVertex;
        //边的权重
        int weight;

        public Edge(int v, int w) {
            this.targetVertex = v;
            this.weight = w;
        }

        public int getTargetVertex() {
            return targetVertex;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Edge{");
            sb.append("targetVertex=").append(targetVertex);
            sb.append(", weight=").append(weight);
            sb.append('}');
            return sb.toString();
        }
    }

}
