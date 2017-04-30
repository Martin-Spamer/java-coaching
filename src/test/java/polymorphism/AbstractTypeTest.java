package polymorphism;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractTypeTest {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractTypeTest.class);
	private AbstractType abstractType;

	@Test
	public void testOne() {
		abstractType = new SubTypeOne();
		LOG.info("{}", abstractType);
	}

	@Test
	public void testTwo() {
		abstractType = new SubTypeTwo();
		LOG.info("{}", abstractType);
		abstractType.operation();
		LOG.info("{}", abstractType);
	}

}
