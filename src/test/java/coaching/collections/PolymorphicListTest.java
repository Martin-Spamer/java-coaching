package coaching.collections;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.*;

public class PolymorphicListTest {

	private static final Logger LOG = LoggerFactory.getLogger(PolymorphicListTest.class);

	@Test
	public void testPolymorphicList() {
		LOG.info("testPolymorphicList");
		final PolymorphicList polymorphicList = new PolymorphicList();
		assertNotNull(polymorphicList);
	}

	@Test
	public void testAdd() {
		LOG.info("testAdd");
		final PolymorphicList polymorphicList = new PolymorphicList();
		assertNotNull(polymorphicList);
		assertNotNull(polymorphicList.add(1));
	}

	@Test
	public void testNext() {
		LOG.info("testNext");
		final PolymorphicList polymorphicList = new PolymorphicList();
		assertNotNull(polymorphicList);
		assertNotNull(polymorphicList.add(1));
		final Integer next = polymorphicList.next();
		assertNotNull(next);
	}

	@Test
	public void testToString() {
		final PolymorphicList polymorphicList = new PolymorphicList();
		assertNotNull(polymorphicList);
		LOG.info("{}", polymorphicList.toString());
	}

}