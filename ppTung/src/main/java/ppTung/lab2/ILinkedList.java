package ppTung.lab2;

public interface ILinkedList<T> {
	int size();
	boolean contains(T data);
	T get(int index);
	void addFirst(T data);
	void addLast(T data);
	void add(int index, T data);
	T removeFirst();
	T removeLast();
	T remove (int index);
	

}
