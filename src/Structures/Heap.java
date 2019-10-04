package Structures;

import java.util.Arrays;

public abstract class Heap<T> {
	
	//Constant fields
	/**The default capacity of each heap.*/
	public int DEFAULT_CAPACITY = 10;
	
	//Variable fields
	/**The array that represents this Heap*/
	protected T[] arr;
	
	/**The heap size of this heap.*/
	protected int size;
	
	/**
	 * Creates a new Heap and assigns the default size to its representative array.
	 */
	@SuppressWarnings("unchecked")
	public Heap() {
		arr = (T[]) new Object[DEFAULT_CAPACITY];
		size = -1;
	}
	
	/**
	 * Creates a new Heap and assigns a given size to its representative array.
	 * @param size The given size.
	 */
	@SuppressWarnings("unchecked")
	public Heap(int size) {
		arr = (T[]) new Object[size];
		size = -1;
	}
	
	/**
	 * Sets the representative array to a given array.
	 * @param ar The given array
	 */
	public void setArray(T[] ar) {
		arr = ar;
		size = arr.length-1;
	}
	
	/**
	 * Returns the length of the array that represents this heap.
	 * @return the value of arr.length
	 */
	public int length() {
		return arr.length;
	}
	
	/**
	 * Returns the heap size of the array that represents this heap.
	 * @return the number of elements in arr that share the heap property. 
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns the index of the parent of a given index.
	 * @param i the given index
	 * @return an integer r, such as r = i/2. -1 if the given index has no parent (root node)
	 */
	public int parent(int i) {
		return (i-1)/2;
	}
	
	/**
	 * Returns the index of the left element of a given index, as long as it exists.
	 * @param i the given index
	 * @return an integer r, such as r=i*2
	 */
	public int left(int i) {
		return (i*2)+1;
	}
	
	/**
	 * Returns the index of the right element of a given index, as long as it exists.
	 * @param i the given index
	 * @return an integer r, such as r=i*2+1
	 */
	public int right(int i) {
		return (i*2)+2;
	}
	
	/**
	 * Swaps the contents of two different keys in this heap.
	 * @param i1 the first given key to be swapped
	 * @param i2 the second given key to be swapped
	 */
	public void swap(int i1, int i2) {
		T temp = arr[i1];
		arr[i1]=arr[i2];
		arr[i2] = temp;
	}
	
	/**
	 * Creates a copy of the representative array with its size increased by <code>DEFAULT_CAPACITY</code> which is 10.
	 * @param ar The array to be resized
	 * @return An identical copy of the representative array, but with its size increased by 10 and the empty spaces filled with null.
	 */
	public T[] resize(T[] ar) {
		return Arrays.copyOf(ar, ar.length+DEFAULT_CAPACITY);
	}
	
	@Override
	public String toString() {
		String msg = "";
		for(T t : arr) {
			if(t!=null) {
				msg+=t.toString() + " ";
			}else {
				break;
			}
		}
		return msg;
	}
}