import java.util.Iterator;
import java.util.NoSuchElementException;

public class GLLIterator<T> implements Iterator<T> {// implement Iterator 

	private GenericList<T> list;// create a list 
	private int temp;  // create a dummy counter to referral current index 
	int length; // index length  
	
	public GLLIterator(GenericList<T> mylist) {//initial
		temp = 0;
		list = mylist;							
		length = mylist.getLength();// get the length 
	}
	
	/*
	 * public boolean hasNext(), checks to see if there is another value in the data structure and returns true or false
	 */
	public boolean hasNext() {
		if (temp < length) {// if the current head is not null then we return true 
			return true;
			}
		return false;  
	}
	
	/*
	 * public T next(), returns the current value in the data structure and advances
	   to the next item. This is the class that will be returned when the iterator()
	   method is called from the Iterable<T> interface
	 */
	public T next() {
		if (hasNext()) {// we will move from the lowest value 
			T itrfront = list.get(temp);
			temp++; // increase your index until it reach max length
			return itrfront;
		} else { 
			throw new RuntimeException("Error Illegal Index, next() reach limit");
		}
		
	}
}

