package patterns.command;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticInvokerTest {

	private static final Logger LOG = LoggerFactory.getLogger(StaticInvokerTest.class);

	@Test
	public void testExampleCommandInvoker() throws Exception {
		LOG.debug("testExampleCommandInvoker");
		final ResultInterface result = new InvokerExample().execute("ExampleCommand");
		assertNotNull(result);
		LOG.info(result.toString());
	}

	@Test
	public void testCommandSequenceInvoker() throws Exception {
		LOG.debug("testCommandSequenceInvoker");
		final ResultInterface result = new InvokerExample().execute("CommandSequence");
		assertNotNull(result);
		LOG.info(result.toString());
	}

	@Test
	public void testCompoundCommandInvoker() throws Exception {
		LOG.debug("testCompoundCommandInvoker");
		final ResultInterface result = new InvokerExample().execute("CompoundCommand");
		assertNotNull(result);
		LOG.info(result.toString());
	}

	@Test
	public void testConditionalCommandInvoker() throws Exception {
		LOG.debug("testConditionalCommandInvoker");
		final ResultInterface result = new InvokerExample().execute("ConditionalCommand");
		assertNotNull(result);
		LOG.info(result.toString());
	}

}