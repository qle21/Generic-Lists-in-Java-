import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class GenericList<T> implements Iterable<T> {

	private Node<T> head;// the one we will use to work on most of time (print, add, delete etc)
	private int length;// list length 
	
	// we already declared in private return them as is
	
	public void setLength(int listLength) {
		this.length = listLength;// set length of list
	}
	
	public void setHead(Node<T> currentHead) {
		this.head = currentHead;// set current head value
	}
	
	public int getLength() {
		return this.length;// get length of list
	}

	public Node<T> getHead() {
		return head;// get current head value
	}
	
	/* 
	 * prints the value of the list each one.
	 */
	public void print() {
		Node<T> curr = head;
		if (curr == null) {
            System.out.println("Empty List");
        }
		while(curr != null){// travel to the end 
			System.out.println(curr.data);
			curr = curr.next;	
		}
	}
	
	
	/*
	 *  returns the value at the specified index or null if the index is 
out of bounds.
	 */
	public T get(int index) { 
		
		T temp = null; //temporary dummy value to use
		
		if (length == 0) {// if list empty return null
			return temp;
		} else if (index >= 0 && index < length) { // if not out bound
			Node<T> curr = head;	// head will be current then we move on to next 	
			for(int i = 0; i < index; i++) {
				curr = curr.next;	//head = next 
			}
			temp = curr.data; // current index value is here 
		} 
		return temp;
	}
	
	/*
	 *  replace the element at specified position in the list 
		with the specified element and return the element previously at the specified position. 
		Return null if index is out of bounds

	 */
	public T set(int index, T element) {
		
		T temp = null;//temporary dummy value to use
		
		if (length == 0){			
		} else if (index >= 0 && index < length) {	// if not out bound
			Node<T> curr = head;		// head will be current then we move on to next 	
			for(int i = 0; i < index; i++) { 
				curr = curr.next;	//head = next 
			}
			temp = curr.data;
			curr.data = element;// replace the current value = value you want 
		} 
		return temp;
	}
	
	
	/*
	 * adds the value to the list. This method is abstract since the 
	   implementation depends on what the data structure is (front or end ?)
	 */
	abstract void add(T data);  
	
    //public void addFront(T t) {
	//    head = new Node<T>(t);
	//    length++;
	//  }
	
	
	
	/*
	 * delete the head node in the list, we will modify this based on need of Queue or Stack
	 */
	public T delete() { 
		T temp = null;
		if (length == 0) {// if list empty return null
			return temp;
		} else { // if not then we delete the length and set next data to be the current head data
			temp = head.data; 
			head = head.next;	
			length--;
		}
		return temp;
	}
	
	/*
	 *  this method stores and returns all values currently in 
		the list into an ArrayList and returns it. At the end of this method, your list should be 
		empty.
	 */
	public ArrayList<T> dumpList() {	
		ArrayList<T> arrayval = new ArrayList<>();
		Node<T> curr = head;
		while(curr != null){  // from the head until end 
			arrayval.add(curr.data);	// add each head to array 
			curr = curr.next; // current head will be the next one after added
		}
		//empty everything in the end
		head = null;	
		length = 0;		
		return arrayval;
	}
	

	
	/*
	 * returns a list-iterator of the elements of 
	   this list starting at the specified position.

	 */
	public ListIterator<T> listIterator(int index) {
		return new GLListIterator<T>(this, index); //  using pointer this to access all data inside
	}
	
	/*
	 *  returns an iterator over the elements of the 
	    list in reverse order( tail to head)
	 */
	public Iterator<T> descendingIterator() {
		return new ReverseGLLIterator<T>(this);	 // using pointer this to access all data inside 
	}

	/*
	 *  implement any abstract methods from the Iterable<T> interface. 
		You do not need to worry about the default methods
	 */
	public GLLIterator<T> iterator() {
		return new GLLIterator<T>(this);	 // using pointer this to access all data inside 
	}
	
	/*
	 * This class should also define a generic inner class Node<T>: It will include two fields: 
	T data and Node<T> next; 
	This inner class will also provide a single arg constructor:
	public Node(T val) // sets data equal to val
	This inner class is to be used to create nodes, in your linked list class
	 */
	public class Node<T> {
			public Node<T> next;//next ptr
			public T data;// your data store here any kind of data
			
			// empty on created 
			public Node(T val) { 
				this.data = val;
				this.next = null;
			}
	}	
}
