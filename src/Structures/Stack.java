package Structures;

public class Stack<T> {
	
	private int size;
	
	private QNode<T> top;
	
	public Stack() {
		top = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(T obj) {
		
		QNode<T> nn = new QNode<T>(obj);
		if(top == null) {
			top = nn;
		}else {
			nn.setNext(top);
			top = nn;
		}
		size++;
	}

	public T pop() {
		
		T dev = null;
		
		if(top != null) {
			dev  = top.getObj();
			top = top.getNext();
			size--;
		}
		
		return dev;
	}

	public T peek() {
		
		if(top != null) {
			return top.getObj();
		}else {
			return null;
		}
		
	}
	
	public int size() {
		return size;
	}

}
