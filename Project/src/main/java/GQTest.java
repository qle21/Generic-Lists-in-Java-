import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ListIterator;
import java.util.Iterator;

public class GQTest {

	private GenericQueue<Integer> thisQueue;
	
	@BeforeEach
	void init() {
		thisQueue = new GenericQueue<>();
	}
	

	/*
	 * listIterator() testing 
	 */
	@Test
	void Iterator_testing1() {	//list
		
		Integer temparr1[] = new Integer[487];
		ArrayList<Integer> arrL = new ArrayList<>();
		for(int i = 0; i < 487; i++) {
			temparr1[i] = i;
			thisQueue.add(i);
		}
		
		ListIterator<Integer> itr = thisQueue.listIterator(0);

		while(itr.hasNext()) {
			arrL.add(itr.next());
		}
		
		Integer temparr2[] = new Integer[thisQueue.getLength()];
		temparr2 = arrL.toArray(temparr2);
		
		assertArrayEquals(temparr1,temparr2, "invalid value return");
	}
	
	/*
	 * hasNext_itr method testing
	 */
	@Test
	void hasNext_litr_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(3);
		assertTrue(itr.hasNext());
	}
	
	@Test
	void hasNext_litr_testing2() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(4);
		itr.next(); 
		assertFalse(itr.hasNext());
	}

	/*
	 * next_itr method testing
	 */
	@Test
	void Next_litr_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(0);
		assertEquals(16, itr.next());
	}
	
	@Test
	void Next_litr_testing2() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(2);
		assertEquals(56, itr.next());
	}
	
	/*
	 * hasPrevious_itr method testing 
	 */
	@Test
	void hasPrevious_itr_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(0);
		assertTrue(itr.hasPrevious());
	}
	
	@Test
	void hasPrevious_itr_testing2() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(0);
		itr.previous();
		assertFalse(itr.hasPrevious());
	}
	
	/*
	 * previous_itr method testing 
	 */
	@Test
	void previous_itr_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(0);
		assertEquals(16, itr.previous());
	}
	
	@Test
	void previous_itr_testing2() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(1);
		assertEquals(23, itr.previous());
	}
	
	
	/*
	 *nextIndex_itr method testing 
	 */
	@Test
	void next_itrIndex_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(3);
		assertEquals(3, itr.nextIndex());
	}	
	
	@Test
	void next_itrIndex_testing2() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(0);
		assertEquals(0, itr.nextIndex());
	}	
	
	/*
	 * previousIndex_itr testing
	 */
	@Test
	void previousIndex_itr_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(2);
		assertEquals(2, itr.previousIndex());
	}	
	
	@Test
	void previousIndex_itr_testing2() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		ListIterator<Integer> itr = thisQueue.listIterator(0);
		assertEquals(0, itr.previousIndex());
	}	
	
	
	/*
	 *iterator testing 
	 */
	@Test
	void Iterator_testing2() {// iterator

		Integer myarr[] = new Integer[555];
		ArrayList<Integer> arrL = new ArrayList<>();
		for(int i = 0; i < 555; i++) {
			myarr[i] = i;
			thisQueue.add(i);
		}
		
		Iterator<Integer> itr = thisQueue.iterator();

		while(itr.hasNext()) {
			arrL.add(itr.next());
		}
		
		Integer temparr2[] = new Integer[thisQueue.getLength()];
		temparr2 = arrL.toArray(temparr2);
		
		assertArrayEquals(myarr,temparr2, "invalid value return");
	}

	/*
	 * next_itr method testing 
	 */
	@Test
	void next_itr_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		Iterator<Integer> itr = thisQueue.iterator();
		assertEquals(16, itr.next());
	}
	
	@Test
	void next_itr_testing2() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		Iterator<Integer> itr = thisQueue.iterator();
		itr.next();
		assertEquals(23, itr.next());
	}
	
	/*
	 * hasNext_itr method testing 
	 */
	@Test
	void hasNext_itr_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		Iterator<Integer> itr = thisQueue.iterator();
		assertTrue(itr.hasNext());
	}
	
	@Test
	void hasNext_itr_testing2() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		Iterator<Integer> itr = thisQueue.iterator();
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		itr.next();
		assertFalse(itr.hasNext());
	}
	
	/*
	 * descending_Itr method testing 
	 */
	@Test
	void descending_testing() {

		Integer temparr1[] = new Integer[145];
		ArrayList<Integer> arrL = new ArrayList<>();
		for(int i = 0; i < 145; i++) {
			temparr1[i] = 144 - i;
			thisQueue.add(i);
		}
		
		Iterator<Integer> desItr = thisQueue.descendingIterator();

		while(desItr.hasNext()) {
			arrL.add(desItr.next());
		}
		
		Integer temparr2[] = new Integer[thisQueue.getLength()];
		temparr2 = arrL.toArray(temparr2);
		
		assertArrayEquals(temparr1,temparr2, "invalid value return");
	}

	/*
	 * next_itr method testing 
	 */
	@Test
	void descendingnext_itr_testing1() {
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		Iterator<Integer> desItr = thisQueue.descendingIterator();
		assertEquals(174, desItr.next());
	}
	
	@Test
	void descendingnext_itr_testing2() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		Iterator<Integer> desItr = thisQueue.descendingIterator();
		desItr.next();
		desItr.next();
		assertEquals(56, desItr.next());
	}
	
	/*
	 * hasNext_itr method testing 
	 */
	@Test
	void descendinghasNext_itr_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		Iterator<Integer> desItr = thisQueue.descendingIterator();
		assertTrue(desItr.hasNext());
	}
	
	@Test
	void descendinghasNext_itr_testing2() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		Iterator<Integer> desItr = thisQueue.descendingIterator();
		desItr.next();
		desItr.next();
		desItr.next();
		desItr.next();
		desItr.next();
		assertFalse(desItr.hasNext());
	}	
	/*
	 * add method testing
	 */
	@Test
	void add_testing1() {
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		assertEquals(5, thisQueue.getLength(), "invalid value");
	}

	
	
	@Test
	void add_testing2() {
		assertEquals(0, thisQueue.getLength(), "invalid value");
	}
	
	@Test
	void add_testing3() {
		thisQueue.add(16);
		thisQueue.add(23);
		thisQueue.add(56);
		thisQueue.add(89);
		thisQueue.add(174);
		thisQueue.add(105);
		assertEquals(6, thisQueue.getLength(), "invalid value");
	}
	
	
	/*
	 * delete method testing
	 */
	
	@Test
	void delete_testing1() {
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		assertEquals(16, thisQueue.delete(), "return value is invalid");
	}
	
	@Test
	void delete_testing2() {
		thisQueue.add(1);
		thisQueue.add(2);
		thisQueue.add(3);
		assertEquals(1, thisQueue.delete(), "length is invalid");
	}
	
	@Test
	void delete_testing3() {
		assertEquals(null, thisQueue.delete(), "length is invalid");
	}
	

	/*
	 * dumpList method testing 
	 */
	@Test
	void dumpList_testing1() {
		thisQueue.enqueue(174);
		thisQueue.enqueue(89);
		thisQueue.enqueue(56);
		thisQueue.enqueue(23);
		thisQueue.enqueue(16);
		ArrayList<Integer> arrL = new ArrayList<>();
		ArrayList<Integer> myL =  thisQueue.dumpList();
		arrL.add(174);
		arrL.add(89);
		arrL.add(56);
		arrL.add(23);
		arrL.add(16);
		
		Integer arr1[] = new Integer[5];
		arr1 = arrL.toArray(arr1); 
		
		Integer arr2[] = new Integer[thisQueue.getLength()];
		arr2 = myL.toArray(arr2);
		
		assertArrayEquals(arr1, arr2, "invalid value returned");
	}
	
	
	/*
	 * get method testing 
	 */
	@Test
	void get_testing1() {
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		assertEquals(16, thisQueue.get(0), "invalid value returned");
	}
	
	@Test
	void get_testing2() {
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		assertEquals(174, thisQueue.get(thisQueue.getLength() - 1), "invalid value returned");
	}
	
		
	@Test
	void get_testing3() {
		assertEquals(null, thisQueue.get(10), "invalid value returned");
	}
	
	/*
	 * set method testing  
	 */
	@Test
	void set_testing1() {
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		assertEquals(16, thisQueue.set(0,123), "invalid value returned");
	}
	
	@Test
	void set_testing2() {
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		assertEquals(174, thisQueue.set(4,456), "invalid value returned");
	}
	

	/*
	 * getLength method testing 
	 */
	@Test
	void getLength_testing1() {
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		assertEquals(5, thisQueue.getLength(), "invalid length");
	}
	
	@Test
	void getLength_testing2() {
		assertEquals(0, thisQueue.getLength(), "invalid length");
	}

	@Test
	void getLength_testing3() {
		for(int i = 0; i < 100; i++) {
			thisQueue.add(i);
		}
		assertEquals(100, thisQueue.getLength(), "invalid length");
	}
	
	/*
	 * getHead method testing 
	 */
	@Test
	void getHead_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		assertEquals(16, thisQueue.getHead().data, "invalid head");
	}
	
	@Test
	void getHead_testing2() {	
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		assertEquals(23, thisQueue.getHead().data, "invalid head");
	}
	
	/*
	 * setLength method testing 
	 */
	@Test
	void setLength_testing1() {	
		thisQueue.setLength(6);
		assertEquals(6, thisQueue.getLength(), "invalid length");
	}
	
	@Test
	void setLength_testing2() {	
		thisQueue.setLength(7);
		assertEquals(7, thisQueue.getLength(), "invalid length");
		}
	
	/*
	 * setHead method testing 
	 */
	@Test
	void setHead_testing1() {	
		thisQueue.enqueue(16);
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		thisQueue.add(220); 
		thisQueue.setHead(thisQueue.getHead());	
		assertEquals(16, thisQueue.getHead().data, "invalid head");
		}
		
	@Test
	void setHead_testing2() {	
		thisQueue.enqueue(23);
		thisQueue.enqueue(56);
		thisQueue.enqueue(89);
		thisQueue.enqueue(174);
		thisQueue.add(220); 
		thisQueue.setHead(thisQueue.getHead());	
		assertEquals(23, thisQueue.getHead().data, "invalid head");
	}
	
}