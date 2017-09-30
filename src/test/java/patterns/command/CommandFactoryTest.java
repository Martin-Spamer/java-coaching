
package patterns.command;

import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import org.junit.Test;
import org.slf4j.*;

/**
 * The CommandFactoryTest Class.
 */
public class CommandFactoryTest {

	private static final Logger LOG = LoggerFactory.getLogger(CommandFactoryTest.class);

	/**
	 * Unit Test to command factory.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testCommandFactory() throws Exception {
		LOG.debug("testCommandFactory");
		final InvokerInterface commandFactory = new CommandFactory();
		assertNotNull("Value cannot be null", commandFactory);
		LOG.info(commandFactory.toString());
	}

	/**
	 * Unit Test to command factory file.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testCommandFactoryFile() throws Exception {
		LOG.debug("testCommandFactoryFile");
		final InvokerInterface commandFactory = new CommandFactory("commands.properties");
		assertNotNull("Value cannot be null", commandFactory);
		LOG.info(commandFactory.toString());
	}

	/**
	 * Unit Test to command factory properties.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testCommandFactoryProperties() throws Exception {
		LOG.debug("testCommandFactoryProperties");
		final Properties properties = new Properties();
		final InvokerInterface commandFactory = new CommandFactory(properties);
		assertNotNull("Value cannot be null", commandFactory);
		LOG.info(commandFactory.toString());
	}

	/**
	 * Unit Test to missing command execute.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = MissingCommandException.class)
	public void testMissingCommandExecute() throws Exception {
		LOG.debug("testMissingCommandExecute");
		final InvokerInterface commandFactory = new CommandFactory();
		assertNotNull("Value cannot be null", commandFactory);
		final String actionName = "MissingCommand";
		commandFactory.execute(actionName);
	}

	/**
	 * Unit Test to execute missing command.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = MissingCommandException.class)
	public void testExecuteMissingCommand() throws Exception {
		LOG.debug("testExecuteMissingCommand");
		final InvokerInterface commandFactory = new CommandFactory();
		assertNotNull("Value cannot be null", commandFactory);
		final String actionName = "MissingCommand";
		commandFactory.execute(actionName);
	}

	/**
	 * Unit Test to execute missing class.
	 *
	 * @throws Exception the exception
	 */
	@Test(expected = MissingCommandException.class)
	public void testExecuteMissingClass() throws Exception {
		LOG.debug("testExecuteMissingClass");
		final InvokerInterface commandFactory = new CommandFactory();
		assertNotNull("Value cannot be null", commandFactory);
		final String actionName = "MissingCommand";
		commandFactory.execute(actionName);
	}

	/**
	 * Unit Test to execute example command.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testExecuteExampleCommand() throws Exception {
		LOG.debug("testExecuteExampleCommand");
		final InvokerInterface commandFactory = new CommandFactory();
		assertNotNull("Value cannot be null", commandFactory);
		final String actionName = "ExampleCommand";
		final ResultInterface result = commandFactory.execute(actionName);
		assertNotNull("Value cannot be null", result);
		LOG.info(result.toString());
	}

	/**
	 * Unit Test to execute sequence command.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testExecuteSequenceCommand() throws Exception {
		LOG.debug("testExecuteSequenceCommand");
		final InvokerInterface commandFactory = new CommandFactory();
		assertNotNull("Value cannot be null", commandFactory);
		final String actionName = "SequenceCommand";
		final ResultInterface result = commandFactory.execute(actionName);
		assertNotNull("Value cannot be null", result);
		LOG.info(result.toString());
	}

	/**
	 * Unit Test to execute compound command.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testExecuteCompoundCommand() throws Exception {
		LOG.debug("testExecuteCompoundCommand");
		final InvokerInterface commandFactory = new CommandFactory();
		assertNotNull("Value cannot be null", commandFactory);
		final String actionName = "CompoundCommand";
		final ResultInterface result = commandFactory.execute(actionName);
		assertNotNull("Value cannot be null", result);
		LOG.info(result.toString());
	}

	/**
	 * Unit Test to execute conditional command.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testExecuteConditionalCommand() throws Exception {
		LOG.debug("testExecuteConditionalCommand");
		final InvokerInterface commandFactory = new CommandFactory();
		assertNotNull("Value cannot be null", commandFactory);
		final String actionName = "ConditionalCommand";
		final ResultInterface result = commandFactory.execute(actionName);
		assertNotNull("Value cannot be null", result);
		LOG.info(result.toString());
	}

}
