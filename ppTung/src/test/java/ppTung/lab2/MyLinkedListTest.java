package ppTung.lab2;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ppTung.lab2.MyLinkedList;

public class MyLinkedListTest {
	MyLinkedList<Integer> linkedList;
	LinkedList<Integer> linkedListTest;
	@Before
	public void init() {
		linkedList = new MyLinkedList<Integer>();
		linkedList.addFirst(1);
		linkedList.addLast(2);
		
		linkedListTest= new LinkedList<Integer>();
		linkedListTest.addFirst(1);
		linkedListTest.addLast(2);
	}
	@Test
	public void testSize() {
		linkedList.addFirst(3);
		linkedListTest.addFirst(3);
		
		Assert.assertEquals(linkedList.size(),linkedListTest.size());
	}
	@Test
	public void testRemoveFirst() {
		linkedList.addFirst(3);
		linkedListTest.addFirst(3);
		
		Assert.assertEquals(linkedList.removeFirst(),linkedListTest.removeFirst());
	}

	@Test
	public void testRemoveLast() {
		linkedList.addFirst(3);
		linkedListTest.addFirst(3);
		
		Assert.assertEquals(linkedList.removeLast(),linkedListTest.removeLast());
	}

	@Test
	public void testGet() {
		linkedList.addFirst(3);
		linkedListTest.addFirst(3);
		
		Assert.assertEquals(linkedList.get(2),linkedListTest.get(2));
	}

	@Test
	public void testAddFirst() {
		linkedList.addFirst(3);
		linkedListTest.addFirst(3);
		
		Assert.assertEquals(linkedList.get(0),linkedListTest.getFirst());
	}

	@Test
	public void testAddLast() {
		linkedList.addLast(3);
		linkedListTest.addLast(3);
		
		Assert.assertEquals(linkedList.get(linkedList.size()-1),linkedListTest.getLast());
	}

	@Test
	public void testAdd() {
		linkedList.add(1, 5);
		linkedListTest.add(1, 5);
		Assert.assertEquals(linkedList.get(1),linkedListTest.get(1));
	}

	@Test
	public void testRemove() {
		linkedList.addFirst(3);
		linkedListTest.addFirst(3);
		linkedList.addFirst(4);
		linkedListTest.addFirst(4);
		Assert.assertEquals(linkedList.remove(1),linkedListTest.remove(1));
	}
	@Test
	public void testContains() {
		Assert.assertEquals(linkedList.contains(1),linkedListTest.contains(1));
	}
}
