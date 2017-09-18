package patterns.singleton;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.*;

/**
 * Static Singleton Test Class.
 */
public class StaticSingletonTest {

	private static final Logger LOG = LoggerFactory.getLogger(StaticSingletonTest.class);

	/**
	 * Unit Test to get instance.
	 */
	@Test
	public void testGetInstance() {
		final StaticSingleton instance = StaticSingleton.getInstance();
		assertNotNull(instance);
		final String string = instance.toString();
		assertNotNull(instance);
		LOG.info("{}", string);
	}

}
