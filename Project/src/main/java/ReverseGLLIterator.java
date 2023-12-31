import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReverseGLLIterator<T> implements Iterator<T> {// implement Iterator 
	
	private int temp;  // create a dummy to get and return reverse data length  
	private GenericList<T> mylist;// create a list 
	
	public ReverseGLLIterator(GenericList<T> myList) {
		mylist = myList;							// connect private with the new parameter 
		temp = myList.getLength() - 1; 	// start from last element and move back
	}
	
	
	/*
	 * public boolean hasNext(), checks to see if there is another value in the data structure and returns true or false
	 */
	public boolean hasNext() {
		if (temp >= 0) { //start from the highest value 
			return true;
			}
		return false;  
	}
	
	
	/*
	 * next() methods will have logic to iterate from the list in reverse (tail to head)
	 */
	public T next() {
		if (hasNext()) { // we will move to lowest value 
			T reverse = mylist.get(temp);
			temp--;  // decrease your index until it reach 0
			return reverse;
		} else { // make sure that value is in range  
			throw new RuntimeException("Error Illegal Index, next() reach limit");
		}
		
	}
}
