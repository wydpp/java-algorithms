package com.dpp.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dpp
 * @date 2024/7/25
 * @Description 无向图数据结构
 */
public class Graph {

    private int v; // 顶点的个数
    private LinkedList<Integer>[] adj; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索：搜索一条从s到t的最短路径
     *
     * @param s 起始顶点
     * @param t 终止顶点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        //记录顶点是否访问过
        boolean[] visited = new boolean[v];
        //记录已经被访问，但相连顶点还没有访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //记录搜索路径，当我们从顶点s开始，广度优先搜索到顶点t后，prev数据中存的就是搜索的路径。不过这个路径是反向存储的。
        // prev[w]存储的是顶点w是从哪个前驱顶点遍历过来的，通过顶点2的邻接表访问到顶点3，那prev[3]=2.
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int w = queue.poll();
            //访问顶点w的边
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                //q是和顶点w相连的一个顶点
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }else {
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
        }
    }

    private boolean found = false;

    public void dfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
        found = false;
    }

    private void recurDfs(int s, int t, boolean[] visited, int[] prev) {
        if (found){
            return;
        }
        visited[s] = true;
        if (s == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[s].size(); ++i) {
            int q = adj[s].get(i);
            if (!visited[q]) {
                prev[q] = s;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.bfs(0, 6);
        System.out.println("");
        graph.dfs(0,6);
    }
}
