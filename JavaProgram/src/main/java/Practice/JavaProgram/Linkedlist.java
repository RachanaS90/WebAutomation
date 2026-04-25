package Practice.JavaProgram;

import java.util.LinkedList;

public class Linkedlist {

	public static void main(String args[])
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(2);
		list.add(5);
		
		System.out.println(list);
		list.addFirst(10);
		System.out.println(list);
	}
}
