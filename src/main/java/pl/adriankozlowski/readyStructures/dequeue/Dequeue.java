package pl.adriankozlowski.readyStructures.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dequeue {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<String>();
        deque.offer("Adrian");
        deque.offer("Kamil");
        deque.add("Jacek");
        deque.offerFirst("Lukasz");
        System.out.println("After offerFirst Traversal...");
        for (String s : deque) {
            System.out.println(s);
        }
        //deque.poll();
        //deque.pollFirst();//it is same as poll()
        deque.pollLast();
        System.out.println("After pollLast() Traversal...");
        for (String s : deque) {
            System.out.println(s);
        }
    }
}
