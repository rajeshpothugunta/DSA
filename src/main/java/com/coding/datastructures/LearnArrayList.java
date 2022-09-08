package com.sdet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearnArrayList {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		list.add(4);
		System.out.println(list);
		list.add(1,50); //add new element at 1st index
		System.out.println(list);
		
		List<Integer> newlist = new ArrayList();
		newlist.add(150);
		newlist.add(160);
		
		list.addAll(newlist);
		System.out.println(list);
		
		System.out.println(list.get(1));

		//iterating through list----method-1
		for(int i=0;i<list.size();i++) {
			System.out.println("elements are:"+list.get(i));
		}
		//iterating through list----method-2
		for(Integer element: list) {
			System.out.println("elements are:"+element);
		}
		//iterating through list----method-3
		Iterator<Integer> it =list.iterator();
		while(it.hasNext())
			System.out.println("elements using iterator are:"+it.next());
		
		list.remove(1);
		System.out.println(list);
		
		list.remove(Integer.valueOf(150));
		System.out.println(list);
		

		list.clear();
		System.out.println(list);
	}

}
