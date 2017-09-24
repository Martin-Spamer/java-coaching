/**
 *  @title			Types.java
 *  @description	TODO
 *  @author			martin.spamer.
 *  @version		0.1 - first release.
 *	Created			07-Oct-2004
 **/

package coaching.types;

import org.slf4j.*;

/**
 * Java Native Types.
 *
 * @author martin.spamer
 * @version 0.1 - 09:20:22
 */
public class ObjectTypes {

	protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	// integers object types
	private final Byte largestByte = Byte.MAX_VALUE;
	private final Byte smallestByte = Byte.MIN_VALUE;

	private final Short largestShort = Short.MAX_VALUE;
	private final Short smallestShort = Short.MIN_VALUE;

	private final Integer largestInteger = Integer.MAX_VALUE;
	private final Integer smallestInteger = Integer.MIN_VALUE;

	private final Long largestLong = Long.MAX_VALUE;
	private final Long smallesttLong = Long.MIN_VALUE;

	// real numbers
	private final Float largestFloat = Float.MAX_VALUE;
	private final Float smallestFloat = Float.MIN_VALUE;

	private final Double largestDouble = Double.MAX_VALUE;
	private final Double smallestDouble = Double.MIN_VALUE;

	// other primitive types
	private final Character aChar = 'A';

	private final Boolean aBooleanTrue = true;
	private final Boolean aBooleanFalse = false;

	/**
	 * Instantiates a new object types.
	 */
	protected ObjectTypes() {
		super();
	}

	/**
	 * Display.
	 */
	public void display() {
		// display them all
		log.info("largest byte value : {}", largestByte);
		log.info("smallest byte value : {}", smallestByte);

		log.info("largest short value is {}", largestShort);
		log.info("smallest short value is {}", smallestShort);

		log.info("largest integer value is {}", largestInteger);
		log.info("smallest integer value is {}", smallestInteger);

		log.info("largest long value is {}", largestLong);
		log.info("smallest long value is {}", smallesttLong);

		log.info("largest float value is {}", largestFloat);
		log.info("smallest float value is {}", smallestFloat);

		log.info("largest double value is {}", largestDouble);
		log.info("smallest double value is {}", smallestDouble);

		if (Character.isUpperCase(aChar)) {
			log.info("The character {} is upper case.", aChar);
		} else {
			log.info("The character {} is lower case.", aChar);
		}

		if (aBooleanTrue) {
			log.info("aBooleanTrue has tested as true : {}", aBooleanTrue);
		} else {
			log.info("aBooleanTrue has tested as false : {}", aBooleanTrue);
		}

		if (aBooleanFalse) {
			log.info("aBooleanFalse has tested as true : {}", aBooleanFalse);
		} else {
			log.info("aBooleanFalse has tested as false : {}", aBooleanFalse);
		}
	}
}
