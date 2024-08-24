package com.sumeeth.googleinterview.concepts.ds.graph;

import com.google.common.base.Preconditions;

public class GraphDemo {

    private class Vertex {
        String data;

        Vertex(String data) {
            this.data = data;
        }
    }

    private class Edge {
        Integer cost;
        Vertex src;
        Vertex dest;

        public Edge(Vertex src, Vertex dest) {
            this.src = Preconditions.checkNotNull(src);
            this.dest = Preconditions.checkNotNull(dest);
        }

        public Edge(int cost, Vertex src, Vertex dest) {
            this.cost = Preconditions.checkNotNull(cost);
            this.src = Preconditions.checkNotNull(src);
            this.dest = Preconditions.checkNotNull(dest);
        }
    }


}
