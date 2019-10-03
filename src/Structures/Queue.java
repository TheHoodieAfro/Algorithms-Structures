package Structures;

public class Queue<T> implements MQueue<T> {
	
	private int size;
	
	private QNode<T> head;
	private QNode<T> tail;
	
	public Queue() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	@Override
	public void add(T obj) {
		
		QNode<T> nn = new QNode<T>(obj);
		if(head == null) {
			head = nn;
			tail = nn;
		}else {
			tail.setNext(nn);
			tail = nn;
			
		}
		size++;
	}

	@Override
	public T poll() {
		
		T dev = null;
		
		if(head != null) {
			dev  = head.getObj();
			head = head.getNext();
		}
		
		return dev;
	}

	@Override
	public T peek() {
		
		if(head != null) {
			return head.getObj();
		}else {
			return null;
		}
		
	}
	
	public int size() {
		return size;
	}
	
}
