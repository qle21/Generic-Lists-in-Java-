
public class GenericQueue<T> extends GenericList<T> {// inherit from GenericList<T>. 
	
	private Node<T> tail;// This is a traditional reference to the tail of the list.
	
	/*
	* enqueue(T data) and public T dequeue() which will call the methods add(T data) and delete() respectively.
	*/
	public T dequeue() {
		return delete();
	}
	
	public void enqueue(T data) {
		add(data);
	}
	
	
	/*
	 * retrieves and removes the tail of the list using the tail data 
		member.

	 */
	
	public T removeTail() {
		
		T temp = null;
		
		if (getLength() == 0) {	// empty list will return null value of temp
			return temp;
		} else { 
			
			temp = tail.data; //return this value when over
			Node<T> curr = getHead();// current head 
			while(curr.next != tail) {  //  go to final node
				curr = curr.next;
			}
			
			curr.next = null;	   // set the final node to empty 
			tail = curr;  	// current head = tail
			setLength(getLength() - 1);		// length of list will decrease after removing element 
		}
		return temp;
	}
	/*
	 * Each class should also implement 
	   the method add(T data), GenericQueue will add to the back of the list while 
	   GenericStack will add to the front
	 */
	public void add(T data) {
		
		Node<T> curr = new Node(data);	
		
		if (getLength() == 0 ) {		// if list is empty at first or after remove element 
			setHead(curr);  
			tail = curr;		// Head = Tail
		} else {
			tail.next = curr;  // Make the last node point to the new node
			tail = curr;  // Make tail the new node
		}
		setLength(getLength() + 1);  // length of list will increase after adding element 
	}
	

}