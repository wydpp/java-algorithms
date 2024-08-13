package com.dpp.leetcode;

import com.dpp.graph.CompleteGraph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dpp
 * @date 2024/8/13
 * @Description 旅行商问题：
 * 假设有一个旅行商（或销售员）需要访问若干个城市，并且每个城市只能访问一次，最后要回到出发的城市。
 * 已知每两个城市之间的距离或费用，旅行商需要找到一条路径，使得总的旅行距离（或总费用）最小。
 * 简要来说，旅行商问题就是找到一条经过所有城市且总距离最短的闭合路径。
 */
public class TravellingSalesmanProblem {

    static LinkedList<Integer> shortestPath = null;

    static int minWeight = Integer.MAX_VALUE;

    public static void findShortestPath(CompleteGraph graph, int cw, int startVertex, int step) {
        if (shortestPath == null) {
            shortestPath = new LinkedList<>();
            for (int i = 0; i <= graph.getV(); i++) {
                shortestPath.add(-1);
            }
        }
        if (step == 0) {
            shortestPath.set(0, startVertex);
        }
        if (step == graph.getV() - 1) {
            //加上最后的回路
            for (CompleteGraph.Edge edge : graph.getEdges(startVertex)) {
                if (edge.getTargetVertex() == 0) {
                    cw += edge.getWeight();
                    break;
                }
            }
            if (cw <= minWeight) {
                minWeight = cw;
                shortestPath.set(step + 1, 0);
                System.out.println(String.format("路径=%s，权重=%s", shortestPath, minWeight));
            }
            return;
        }
        List<Integer> path = new LinkedList<>();
        for (int i = 0; i < step; i++) {
            path.add(shortestPath.get(i));
        }
        LinkedList<CompleteGraph.Edge> edges = graph.getEdges(startVertex);
        for (int i = 0; i < edges.size(); i++) {
            int targetVertex = edges.get(i).getTargetVertex();
            if (path.contains(targetVertex)) {
                continue;
            }
            int weight = edges.get(i).getWeight();
            shortestPath.set(step + 1, targetVertex);
            findShortestPath(graph, weight + cw, targetVertex, step + 1);
        }
    }

    public static void main(String[] args) {
        //先构建一个具体的示例:有4个顶点的完全有权图，顶点依次是 0，1，2，3
        //从顶点0开始，找一个一条经过所有顶点的总权重最小的闭合路径
        CompleteGraph graph = new CompleteGraph(4);
        //添加顶点0的边和权重
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 3, 7);
        //添加顶点1的边和权重
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 3, 3);
        //添加顶点2的边和权重
        graph.addEdge(2, 3, 1);

        findShortestPath(graph, 0, 0, 0);

        System.out.println("最小权重路径=>" + shortestPath);
        System.out.println("最下哦权重值=" + minWeight);

    }
}
