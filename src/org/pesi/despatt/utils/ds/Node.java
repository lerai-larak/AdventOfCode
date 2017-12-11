package org.pesi.despatt.utils.ds;

public class Node {

	private Long data;
	private Node nodeNext;

	public Node(Long value){
		this.data = value;
		nodeNext = null;
	}

	public Long getData() {
		return data;
	}

	public Node getNodeNext() {
		return nodeNext;
	}
}

class CircularList{

	private Node first;
	private Node last;

	public CircularList(){
		first = null;
		last = null;
	}

	public Node find(long key){
		Node currentNode = first;
		while (currentNode.getData() != key){
			currentNode = currentNode.getNodeNext();
		}
		return currentNode;
	}

	public Node delete(){
		if( first.getNodeNext() == null )
			last = null;
		Node temp = first;
		first = first.getNodeNext();
		return temp;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public void insert(long value){
		Node newNode = new Node(value);

		if( isEmpty() )
			last = newNode;
	}

}
