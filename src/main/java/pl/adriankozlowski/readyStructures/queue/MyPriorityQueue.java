package pl.adriankozlowski.readyStructures.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    public static void main(String args[]) {
        PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        queue.add("Kamil");
        queue.offer("Adrian");
        queue.offer("Janusz Kowalski");
        queue.offer("Seba");
        queue.add("Karina");
        System.out.println("head:" + queue.element());
        System.out.println("head:" + queue.peek());
        System.out.println("iterating the queue elements:");
        Iterator itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        queue.remove();
        queue.poll();
        System.out.println("after removing two elements:");
        Iterator<String> itr2 = queue.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
    }
}
