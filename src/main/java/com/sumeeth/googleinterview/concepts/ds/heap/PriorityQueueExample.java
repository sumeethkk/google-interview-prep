package com.sumeeth.googleinterview.concepts.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        Comparator<Integer> naturalOrder = (a, b)  -> b-a;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(naturalOrder);
        priorityQueue.add(56);
        priorityQueue.add(100);
        priorityQueue.add(110);
        priorityQueue.add(120);
        priorityQueue.add(12);

        priorityQueue.stream().sequential().forEach(e -> System.out.print(e +"->"));
        System.out.println();
        System.out.println(  priorityQueue.peek());
        System.out.println(  priorityQueue.remove());
        System.out.println(  priorityQueue.poll());
        System.out.println(  priorityQueue.peek());
    }
}
