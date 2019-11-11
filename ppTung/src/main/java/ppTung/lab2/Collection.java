package ppTung.lab2;

public class Collection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
		linkedList.addFirst(1);
		linkedList.addFirst(2);
		linkedList.addLast(5);
		linkedList.addLast(6);
		linkedList.add(3, 3);
		linkedList.remove(2);
		//linkedList.printLinkedList();
		for( Integer i : linkedList) {
			System.out.println(i);
		}
	}

}
