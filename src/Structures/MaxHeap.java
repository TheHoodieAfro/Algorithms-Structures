package Structures;

public class MaxHeap<T extends Comparable<T>> extends Heap<T> {
	
	//Methods
	/**
	 * Simple constructor, initialises the representative array with the default capacity defined in superclass Heap
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap() {
		arr = (T[])new Comparable[DEFAULT_CAPACITY];
	}
	
	/**
	 * Initialises the representative array with a given size.
	 * @param i The given size.
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap(int i) {
		arr = (T[])new Comparable[i];
	}
	
	/**
	 * Creates a MaxHeap given its representative array.
	 * @param a The given representative array.
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap(T[] a) {
		arr = (T[])new Comparable[a.length];
		for(T object: a) {
			add(object);
		}
	}
	
	/**
	 * Adds a given object to this heap as long as it has space left.
	 * @param object The given object to be added.
	 */
	public void add(T object) {
		
		if(size >= arr.length-1) {
			arr = resize(arr);
		}
		size++;
		arr[size] = object;
		bubbleUp();
	}
	
	public T poll() {
		T ret = arr[0];
		arr[0] = arr[size];
		arr[size] = null;
		size--;
		bubbleDown(arr, 0);
		return ret;
	}
	
	/**
	 * Ensures the representative array has the order property in this heap when changes have been done to the latest element in it.
	 */
	public void bubbleUp() {
		int index = size;
		while(parent(index)>-1 && arr[parent(index)].compareTo(arr[index])<0){
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	public void heapify() {
		bubbleDown(arr, 0);
	}
	
	/**
	 * Ensures the representative array has the order property in this heap when changes have been done to the first element in it.
	 * This procedure is also known as heapifying the array.
	 */
	public void bubbleDown(T[] a, int index) {
		int smallest = size;
		int l = left(index);
		int r = right(index);
		if(l<=index && a[l].compareTo(a[smallest])>0) {
			smallest = l;
		}
		if(r<=index && a[r].compareTo(a[smallest])>0){
			smallest = r; //2 13 23 7 5 3 10 6 
		}
		if(smallest != index) {
			swap(smallest, index);
			bubbleDown(a, smallest);
		}
	}
	
	
	public static void main(String ars[]) {
		//Random r = new Random(System.currentTimeMillis());
		Integer[] a = {2,3,5,7,10,54,23,13,6};
		MaxHeap<Integer> m = new MaxHeap<Integer>();
		m.setArray(a);
		m.heapify();
		/*for(int i = 0; i<100; i++) {
			int x = r.nextInt(200);
			m.add(x);
		}*/
		System.out.println(m.toString());
	}
}
