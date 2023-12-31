import java.util.ListIterator;
import java.util.NoSuchElementException;

public class GLListIterator<T> implements ListIterator<T> {
	
	private GenericList<T> mylist;// referent to list inherit
	private int length = 0; // length counter to traversal through list 
	
	//create head node and next node pointer  
	private GenericList<T>.Node<T> currNext = null;
	private GenericList<T>.Node<T> currHead = null;

	// Optional/default operations 
    @Override
    public void set(T data) {
    }   
	 @Override
	public void add(T t) {
	    }
    @Override
    public void remove() {
    }
	
	/*
	This class is used to create nodes for the list if the length is out bound or less than 0 then it is not valid 
	 */
	public GLListIterator(GenericList<T> list, int len) {
		if (len >= list.getLength() || len < 0) { 
			throw new RuntimeException("Error Illegal Index");
		} else {
			mylist = list;	// create a referral for list 
			// initial list will be empty with only head 
			currHead = list.getHead();
			currNext = list.getHead();		
			// travel through each node to add element 
			for(int i = 0; i < len; i++) {
				length++;	// increase length when adding element 			
				currNext = currNext.next; // do the same as list head = next then move on until we travel through the whole list
			}	
		}
	}
	
	/*
	 *  This method will returns the next index
	 */
	public int nextIndex() {
		if (length < mylist.getLength()) {	// your current length will determine the position of index and it cant be greater than the list length
			return length;
		} else {
			throw new RuntimeException("Error Illegal Index, nextIndex() reach limit");
		}
	}
	
	/*
	 *  This method will return the previous index
	 */
	public int previousIndex() {
		if (length >= 0) {		// your current length will determine the position of index and it must be greater than 0 to progress
			return length;
		} else {
			throw new RuntimeException("Error Illegal Index, previousIndex() reach limit");
		}

	}
	
	/* Does next node exits ? */
	public boolean hasNext() {
		if (currNext != null) {
		return true ;	// if nextNode is null there are no nodes in the list. Return false in that case.
		}
		return false;
	}
	
	/*
	 * This method will returns the next element in the list
	 */
	public T next() {
		if (hasNext()) {	
			GenericList<T>.Node<T> returnNode = currNext;	// current next node
			currNext = currNext.next;  	// // do the same as list head = next then move on until we travel through the whole list
			length++;		// Increase the length 
			return returnNode.data;
		} else {
			throw new RuntimeException("Error Illegal Index, next() reach limit");
		}
	}

	/* Does previous node exits ? */
	public boolean hasPrevious() {
		if (length >= 0) {		return true;		// If the length greater than 0
		}
	return false;
	}
	
	/*
	 * This method will returns the previous element in the list 
	 */
	public T previous() {
			if (hasPrevious()) {
				T data = mylist.get(length);  // Get data at current indexed node
				currNext = currHead;	// Make next node point to head to start traversing
				for (int i = 0; i < length; i++) {  
					currNext = currNext.next;	// do the same as list head = next then move on until we travel through the whole list
				}	
				length--;	 // Decrease the length to the data point if length is <0 then we throw error 
				return data;
			} else {
				throw new RuntimeException("Error Illegal Index, previous() reach limit");
			}		
	}
	




}
