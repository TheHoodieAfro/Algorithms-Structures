package Structures;

public class QNode<T> {
	
	private T obj;
	private T data;
	private int key;
	
	private QNode<T> next;
	
	public QNode() {
		obj = null;
		next = null;
	}

	public QNode(T ob) {
		obj = ob;
		next = null;
	}
	
	public QNode(T ob, int k) {
		obj = ob;
		next = null;
		key = k;
	}
	
	public boolean hasNext() {
		if(next != null) {
			return true;
		}else {
			return false;
		}
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getObj() {
		return obj;
	}

	public QNode<T> getNext() {
		return next;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public void setNext(QNode<T> next) {
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	
	
	public void setData(T data){
		this.data = data;
	}
	
}
