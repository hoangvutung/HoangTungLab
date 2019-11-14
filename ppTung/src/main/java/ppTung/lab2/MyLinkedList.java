package ppTung.lab2;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> , ILinkedList<T> {

	
	public class Node<T> {
		private T Data;
		private Node<T> Next;
		public Node(T data) {
			Data=data;
			Next=null;
		}
		public T get() {
			return Data;
		}
	}
	private Node<T> Head;
	
	public MyLinkedList(){
		Head = null;
	}
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> tmp=Head;
			public boolean hasNext() {
				return (tmp != null);
			}
			public T next() {
				T result = tmp.get();
				tmp=tmp.Next;
				return result;
			}}
		;
	}

	public int size() {
		int count=0;
		for (Node<T> i=Head; i != null; i = i.Next) {
			count++;
		}
		return count;
	}

	public T removeFirst() {
		if(Head==null) return null;
		else {
			T result = Head.Data;
			Head = Head.Next;
			return result;
		}
	}

	public T removeLast() {
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
		if(index< size() && index >=0) {
			Node<T> tmp = Head;
			while(index>0) {
				tmp=tmp.Next;
				index--;
			}
			return tmp.get();
		}
		else {
			throw new IndexOutOfBoundsException("Wrong index");
		}
	}

	public void addFirst(T data) {
		Node<T> newNode= new Node<T>(data);
		newNode.Next=Head;
		Head=newNode;
	}

	public void addLast(T data) {
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
		if(index==0) addFirst(data);
		else if(index< size() && index>0) {
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
		else throw new IndexOutOfBoundsException("Wrong index");
	}

	public T remove(int index) {
		if(index< size() && index>=0) {
			if(index==0) return removeFirst();
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
		else throw new IndexOutOfBoundsException("Wrong index");
	}
	public void printLinkedList() {
		System.out.println("size = "+ size());
		Node<T> tmp = Head;
        while (tmp != null) {
            System.out.println(tmp.Data.toString());
            tmp = tmp.Next;
        }
	}
	public boolean contains(T data) {
		Node<T> tmp = Head;
        while (tmp != null) {
            if(tmp.Data==data) return true;
            tmp = tmp.Next;
        }
		return false;
	}
}
