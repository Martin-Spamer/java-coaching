
package coaching.pool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ConcurrentPoolTest Class.
 */
public class ConcurrentPoolTest {

	private static final Logger LOG = LoggerFactory.getLogger(ConcurrentPoolTest.class);

	/**
	 * TestResourcePool Class.
	 */
	public class TestResourcePool extends ConcurrentPool<Boolean> {
	}

	/**
	 * Test abstract resource pool.
	 */
	@Test
	public void testAbstractResourcePool() {
		assertNotNull(new TestResourcePool());
	}

	/**
	 * Test typical usage.
	 */
	@Test
	public void testTypicalUsage() {
		// Given a resource pool
		final TestResourcePool testResourcePool = new TestResourcePool();
		assertNotNull(testResourcePool);
		testResourcePool.add(true);
		testResourcePool.add(false);
		assertEquals(2, testResourcePool.countFree());
		assertEquals(0, testResourcePool.countUsed());

		// * pool
		while (testResourcePool.countFree() > 0) {
			final Boolean bool = testResourcePool.take();
			if (bool == true) {
				testResourcePool.remove(bool);
			}
		}

		// Then
		assertEquals(0, testResourcePool.countFree());
		assertEquals(1, testResourcePool.countUsed());
	}

	/**
	 * Test concurrent pool.
	 */
	@Test
	public void testConcurrentPool() {
		final TestResourcePool testResourcePool = new TestResourcePool();
		assertNotNull(testResourcePool);
	}

}