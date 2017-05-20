
package javamentor.collections;

import java.util.LinkedList;
import java.util.List;

public class PolymorphicList {
	private final List<Integer> integerList = new LinkedList<Integer>();

	/**
	 * Adds the Integer object.
	 *
	 * @param integerIn the integer in
	 */
	public void add(Integer integerIn) {
		integerList.add(integerIn);
	}

	/**
	 * Next the Integer object.
	 *
	 * @return the integer
	 */
	public Integer next() {
		return integerList.iterator().next();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final PolymorphicList myIntList = new PolymorphicList();

		myIntList.add(new Integer(0));
		final Integer x = myIntList.next();

		// these unsafe type conversions wont compile
		// myIntList.add( new Double(0) ) ;
		// myIntList.add( new Object(0) ) ;
	}
}
