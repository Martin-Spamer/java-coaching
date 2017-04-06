
package patterns.gof.behavioural.command;

import java.util.Properties;

/**
 * The Invoker Class.
 */
public class Invoker {

	private final Properties properties = new Properties();

	public Invoker() {
		super();
		final CommandMap commandMap = new CommandMap();
	}

	public Invoker execute(final String targetActionName) throws Exception {
		final String className = this.properties.getProperty(targetActionName);
		final AbstractCommand targetAction = (AbstractCommand) Class.forName(className).newInstance();
		targetAction.execute();
		return this;
	}

}
