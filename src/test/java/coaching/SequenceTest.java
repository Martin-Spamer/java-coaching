


package coaching;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.*;

/**
 * A Sequence of programming instructions.
 */
public class SequenceTest {
	private static final Logger LOG = LoggerFactory.getLogger(SequenceTest.class);

	/**
	 * Example of a sequence of programming instructions.
	 */
	@Test
	public void testExampleSequence() {
		final int x = 1;
		final int y = 1;
		final int z = x + y;
		LOG.info("{} = {} + {}", z, x, y);
		assertEquals(2, z);
	}

}
