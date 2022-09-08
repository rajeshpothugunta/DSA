package com.sdet;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LearnPriorityQueue {
	public static void main(String[] args) {
		
		Queue<Integer> queue = new PriorityQueue<Integer>();//similar to min heap
		
		queue.offer(40);
		queue.offer(12);
		queue.offer(24);
		queue.offer(36);
		
		System.out.println(queue);
		
		System.out.println(queue.poll());
		
		System.out.println(queue);
		
		System.out.println(queue.peek());
		
		Queue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());//similar to max heap
		
		maxQueue.offer(40);
		maxQueue.offer(12);
		maxQueue.offer(24);
		maxQueue.offer(36);
		
		System.out.println(maxQueue);
		
		System.out.println(maxQueue.poll());
		
		System.out.println(maxQueue);
		
		System.out.println(maxQueue.peek());

	}


}
