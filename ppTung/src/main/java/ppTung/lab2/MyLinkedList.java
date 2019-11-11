package ppTung.lab2;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> , ILinkedList<T> {

	@SuppressWarnings("hiding")
	public class Node<T> {
		T Data;
		Node<T> Next;
		public Node(T data) {
			Data=data;
			Next=null;
		}
		public T get() {
			return Data;
		}
	
	}
	Node<T> Head;
	
	public MyLinkedList(){
		Head = null;
		
	}
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			Node<T> tmp=Head;
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return (tmp != null);
			}
			public T next() {
				// TODO Auto-generated method stub
				T result = tmp.get();
				tmp=tmp.Next;
				return result;
			}}
		;
	}

	public int size() {
		// TODO Auto-generated method stub
		int count=0;
		for (Node<T> i=Head; i != null; i = i.Next) {
			count++;
		}
		return count;
	}

	public T removeFirst() {
		// TODO Auto-generated method stub
		if(Head==null) return null;
		else {
			T result = Head.Data;
			Head = Head.Next;
			return result;
		}
	}

	public T removeLast() {
		// TODO Auto-generated method stub
		if(Head==null) return null;
		else {
			Node<T> current= Head;
			Node<T> pre = null;
			if(current.Next==null) return removeFirst();
			else {
				while(current.Next !=null) {
					pre = current;
					current = current.Next;
				}
				pre.Next=null;
				return current.Data;
			}
		}
		
	}

	public T get(int index) {
		// TODO Auto-generated method stub
		if(index< size()) {
			Node<T> tmp = Head;
			while(index>0) {
				tmp=tmp.Next;
				index--;
			}
			return tmp.get();
		}
		return null;
	}

	public void addFirst(T data) {
		// TODO Auto-generated method stub
		Node<T> newNode= new Node<T>(data);
		newNode.Next=Head;
		Head=newNode;
	}

	public void addLast(T data) {
		// TODO Auto-generated method stub
		Node<T> newNode= new Node<T>(data);
		if(Head==null) {
			Head= newNode;
		}
		else {
			Node<T> tmp = Head;
			while(tmp.Next !=null) {
				tmp=tmp.Next;
			}
			tmp.Next=newNode;
		}
	}

	public void add(int index, T data) {
		// TODO Auto-generated method stub
		if(index< size()) {
			if(index==0) addFirst(data);
			else {
				Node<T> current= Head;
				Node<T> pre = Head;
				while(index-->0) {
					current=current.Next;
					pre.Next=current;
				}
				Node<T> newNode = new Node<T>(data);
				newNode.Next=current;
				pre.Next= newNode;
			}
			
		}
	}

	public T remove(int index) {
		// TODO Auto-generated method stub
		if(index< size()) {
			Node<T> current= Head;
			Node<T> pre = null;
			while(index-->0) {
				pre=current;
				current=current.Next;
				pre.Next=current;
			}
			pre.Next=current.Next;
			return current.Data;
		}
		else return null;
	}
	public void printLinkedList() {
		System.out.println("size = "+ size());
		Node<T> tmp = Head;
        while (tmp != null) {
            System.out.println(tmp.Data.toString());
            tmp = tmp.Next;
        }
	}
}
