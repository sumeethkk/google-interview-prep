package com.sumeeth.googleinterview.concepts.ds.graph;

import java.util.*;

//using priority queue
public class MyDijkstraAlgo {


    static class Node {
        int vertex;
        int weight;

        Node(int v, int w) {
            vertex = v;
            weight = w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return vertex == node.vertex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertex);
        }
    }

    static class Graph {
        Map<Node, List<Node>> edges;
        PriorityQueue<Node> pq;
        Set<Node> settled;
        Map<Node, Integer> distance;
        Integer V;
        private static final Comparator<Node> naturalOrder = Comparator.comparingInt(a -> a.weight);

        Graph(Integer totalVertex) {
            edges = new LinkedHashMap<>();
            pq = new PriorityQueue(naturalOrder);
            settled = new HashSet<>();
            distance = new LinkedHashMap<>();
            V = totalVertex;
        }


        public void shortestPath(Node src) {
            for (int i = 0; i < V; i++) {
                distance.put(new Node(i,0), Integer.MAX_VALUE);
            }

            distance.put(new Node(0,0), src.weight);
            pq.add(src);

            while (settled.size() <= V) {

                if (pq.isEmpty()) break;

                Node currNode = pq.poll();

                if (!settled.contains(currNode)) {

                    settled.add(currNode);
                    exploreNeighbours(currNode);

                }


            }

            System.out.println(distance);

        }

        private void exploreNeighbours(Node currNode) {
            if (edges.get(currNode) != null) {
                for (Node neighbour : edges.get(currNode)) {
                    if (neighbour != null && !settled.contains(neighbour)) {
                        int w = neighbour.weight;
                        int newWeight = w + distance.get(currNode);

                        if (newWeight < distance.get(neighbour)) {
                            distance.put(neighbour, newWeight); //store min wight
                        }

                        pq.add(new Node(neighbour.vertex, distance.get(neighbour)));
                    }
                }

            }
        }

    }

    public static void main(String[] args) {
        /**
         * // Inputs for the GFG(dpq) graph
         *         adj.get(0).add(new Node(1, 9));
         *         adj.get(0).add(new Node(2, 6));
         *         adj.get(0).add(new Node(3, 5));
         *         adj.get(0).add(new Node(4, 3));
         *
         *         adj.get(2).add(new Node(1, 2));
         *         adj.get(2).add(new Node(3, 4));
         */
        Graph g = new Graph(5);
        g.edges.put(new Node(0, 0), Arrays.asList(
                new Node(1, 9),
                new Node(2, 6),
                new Node(3, 5),
                new Node(4, 3)
        ));
        g.edges.put(new Node(2, 0), Arrays.asList(
                new Node(1, 2),
                new Node(3, 4)
        ));
        printGraph(g);
        g.shortestPath(new Node(0, 0));
    }

    public static void printGraph(Graph g) {
        g.edges.keySet().forEach(vertex -> {
            System.out.print(vertex.vertex + "->");
            g.edges.get(vertex).stream().forEach(edge -> System.out.print("[" + edge.vertex + "," + edge.weight + "]"));
            System.out.println();
        });
    }
}
