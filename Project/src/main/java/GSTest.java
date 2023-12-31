import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ListIterator;
import java.util.Iterator;

public class GSTest {

	private GenericStack<Integer> thiStack;
	
	@BeforeEach
	void init() {
		thiStack = new GenericStack<>();
	}
	

	/*
	 * listIterator() testing 
	 */
	@Test
	void Iterator_testing1() {	
		
		Integer temparr1[] = new Integer[487];
		ArrayList<Integer> arrL = new ArrayList<>();
		for(int i = 0; i < 487; i++) {
			temparr1[i] = 486 - i;
			thiStack.add(i);
		}
		
		ListIterator<Integer> itr = thiStack.listIterator(0);

		while(itr.hasNext()) {
			arrL.add(itr.next());
		}
		
		Integer temparr2[] = new Integer[thiStack.getLength()];
		temparr2 = arrL.toArray(temparr2);
		
		assertArrayEquals(temparr1,temparr2, "invalid value return");
	}
	
	/*
	 * hasNext_itr method testing
	 */
	@Test
	void hasNext_litr_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(3);
		assertTrue(itr.hasNext());
	}
	
	@Test
	void hasNext_litr_testing2() {	
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(3);
		itr.next(); 
		assertFalse(itr.hasNext());
	}

	/*
	 * next_itr method testing
	 */
	@Test
	void Next_litr_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(0);
		assertEquals(174, itr.next());
	}
	
	@Test
	void Next_litr_testing2() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(3);
		assertEquals(23, itr.next());
	}
	
	/*
	 * hasPrevious_itr method testing 
	 */
	@Test
	void hasPrevious_itr_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(0);
		assertTrue(itr.hasPrevious());
	}
	
	@Test
	void hasPrevious_itr_testing2() {	
		thiStack.push(16);
		ListIterator<Integer> itr = thiStack.listIterator(0);
		itr.previous();
		assertFalse(itr.hasPrevious());
	}
	
	/*
	 * previous_itr method testing 
	 */
	@Test
	void previous_itr_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(0);
		assertEquals(174, itr.previous());
	}
	
	@Test
	void previous_itr_testing2() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(4);
		assertEquals(16, itr.previous());
	}
	
	
	/*
	 *nextIndex_itr method testing 
	 */
	@Test
	void next_itrIndex_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(4);
		assertEquals(4, itr.nextIndex());
	}	
	
	@Test
	void next_itrIndex_testing2() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(0);
		assertEquals(0, itr.nextIndex());
	}	
	
	/*
	 * previousIndex_itr testing
	 */
	@Test
	void previousIndex_itr_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(4);
		assertEquals(4, itr.previousIndex());
	}	
	
	@Test
	void previousIndex_itr_testing2() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ListIterator<Integer> itr = thiStack.listIterator(0);
		assertEquals(0, itr.previousIndex());
	}	
	
	
	/*
	 *iterator testing 
	 */
	@Test
	void Iterator_testing2() {

		Integer myarr[] = new Integer[555];
		ArrayList<Integer> arrL = new ArrayList<>();
		for(int i = 0; i < 555; i++) {
			myarr[i] = 554 - i;
			thiStack.add(i);
		}
		
		Iterator<Integer> itr = thiStack.iterator();

		while(itr.hasNext()) {
			arrL.add(itr.next());
		}
		
		Integer temparr2[] = new Integer[thiStack.getLength()];
		temparr2 = arrL.toArray(temparr2);
		
		assertArrayEquals(myarr,temparr2, "invalid value return");
	}

	/*
	 * next_itr method testing 
	 */
	@Test
	void next_itr_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		Iterator<Integer> itr = thiStack.iterator();
		assertEquals(174, itr.next());
	}
	
	@Test
	void next_itr_testing2() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		Iterator<Integer> itr = thiStack.iterator();
		itr.next();
		assertEquals(89, itr.next());
	}
	
	/*
	 * hasNext_itr method testing 
	 */
	@Test
	void hasNext_itr_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		Iterator<Integer> itr = thiStack.iterator();
		assertTrue(itr.hasNext());
	}
	
	@Test
	void hasNext_itr_testing2() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		Iterator<Integer> itr = thiStack.iterator();
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
			temparr1[i] = i;
			thiStack.add(i);
		}
		
		Iterator<Integer> desItr = thiStack.descendingIterator();

		while(desItr.hasNext()) {
			arrL.add(desItr.next());
		}
		
		Integer temparr2[] = new Integer[thiStack.getLength()];
		temparr2 = arrL.toArray(temparr2);
		
		assertArrayEquals(temparr1,temparr2, "invalid value return");
	}

	/*
	 * next_itr method testing 
	 */
	@Test
	void descendingnext_itr_testing1() {
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		Iterator<Integer> desItr = thiStack.descendingIterator();
		assertEquals(16, desItr.next());
	}
	
	@Test
	void descendingnext_itr_testing2() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		Iterator<Integer> desItr = thiStack.descendingIterator();
		desItr.next();
		desItr.next();
		assertEquals(56, desItr.next());
	}
	
	/*
	 * hasNext_itr method testing 
	 */
	@Test
	void descendinghasNext_itr_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		Iterator<Integer> desItr = thiStack.descendingIterator();
		assertTrue(desItr.hasNext());
	}
	
	@Test
	void descendinghasNext_itr_testing2() {	
		thiStack.push(16);
		Iterator<Integer> desItr = thiStack.descendingIterator();
		desItr.next();
	
		assertFalse(desItr.hasNext());
	}	
	/*
	 * add method testing
	 */
	@Test
	void add_testing1() {
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		thiStack.push(220);
		assertEquals(6, thiStack.getLength(), "invalid value");
	}

	
	
	@Test
	void add_testing2() {
		assertEquals(0, thiStack.getLength(), "invalid value");
	}
	
	@Test
	void add_testing3() {
		thiStack.add(16);
		thiStack.add(23);
		thiStack.add(56);
		thiStack.add(89);
		thiStack.add(174);
		thiStack.add(220);
		assertEquals(6, thiStack.getLength(), "invalid value");
	}
	
	
	/*
	 * delete method testing
	 */
	
	@Test
	void delete_testing1() {
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		assertEquals(174, thiStack.delete(), "return value is invalid");
	}
	
	@Test
	void delete_testing2() {
		thiStack.add(1);
		thiStack.add(2);
		thiStack.add(3);
		assertEquals(3, thiStack.delete(), "length is invalid");
	}
	
	@Test
	void delete_testing3() {
		assertEquals(null, thiStack.delete(), "length is invalid");
	}
	

	/*
	 * dumpList method testing 
	 */
	@Test
	void dumpList_testing1() {
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		ArrayList<Integer> arrL = new ArrayList<>();
		ArrayList<Integer> myL =  thiStack.dumpList();
		arrL.add(174);
		arrL.add(89);
		arrL.add(56);
		arrL.add(23);
		arrL.add(16);
		
		Integer arr1[] = new Integer[5];
		arr1 = arrL.toArray(arr1); 
		
		Integer arr2[] = new Integer[thiStack.getLength()];
		arr2 = myL.toArray(arr2);
		
		assertArrayEquals(arr1, arr2, "invalid value returned");
	}
	
	
	/*
	 * get method testing 
	 */
	@Test
	void get_testing1() {
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		assertEquals(174, thiStack.get(0), "invalid value returned");
	}
	
	@Test
	void get_testing2() {
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		assertEquals(23, thiStack.get(thiStack.getLength() - 2), "invalid value returned");
	}
	
		
	@Test
	void get_testing3() {
		assertEquals(null, thiStack.get(5), "invalid value returned");
	}
	
	/*
	 * set method testing  
	 */
	@Test
	void set_testing1() {
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		assertEquals(174, thiStack.set(0,123), "invalid value returned");
	}
	
	@Test
	void set_testing2() {
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		assertEquals(16, thiStack.set(4,456), "invalid value returned");
	}
	

	/*
	 * getLength method testing 
	 */
	@Test
	void getLength_testing1() {
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		assertEquals(8, thiStack.getLength(), "invalid length");
	}
	
	@Test
	void getLength_testing2() {
		assertEquals(0, thiStack.getLength(), "invalid length");
	}

	@Test
	void getLength_testing3() {
		for(int i = 0; i < 100; i++) {
			thiStack.add(i);
		}
		assertEquals(100, thiStack.getLength(), "invalid length");
	}
	
	/*
	 * getHead method testing 
	 */
	@Test
	void getHead_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		assertEquals(174, thiStack.getHead().data, "invalid head");
	}
	@Test
	void getHead_testing2() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		assertEquals(89, thiStack.getHead().data, "invalid head");
	}
	
	/*
	 * setLength method testing 
	 */
	@Test
	void setLength_testing1() {	
		thiStack.setLength(8);
		assertEquals(8, thiStack.getLength(), "invalid length");
	}
	
	@Test
	void setLength_testing2() {	
		thiStack.setLength(9);
		assertEquals(9, thiStack.getLength(), "invalid length");
	}
	/*
	 * setHead method testing 
	 */
	@Test
	void setHead_testing1() {	
		thiStack.push(16);
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		thiStack.add(220); 
		thiStack.setHead(thiStack.getHead());	
		assertEquals(220, thiStack.getHead().data, "invalid head");
	}
	
	@Test
	void setHead_testing2() {	
		thiStack.push(23);
		thiStack.push(56);
		thiStack.push(89);
		thiStack.push(174);
		thiStack.add(220); 
		thiStack.setHead(thiStack.getHead());	
		
		
		assertEquals(220, thiStack.getHead().data, "invalid head");
	}
	
}