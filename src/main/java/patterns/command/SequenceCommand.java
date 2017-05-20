package patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Sequence of Commands example.
 */
public class SequenceCommand extends AbstractCommand {

	private final List<AbstractCommand> sequence = new ArrayList<AbstractCommand>();

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.command.AbstractCommand#execute(patterns.command.
	 * ParametersInterface)
	 */
	@Override
	public ResultInterface execute(ParametersInterface commandParameters) {
		for (final AbstractCommand command : sequence) {
			result = command.execute(commandParameters);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.command.AbstractCommand#undo(patterns.command.
	 * ParametersInterface)
	 */
	@Override
	public ResultInterface undo(ParametersInterface commandParameters) {
		for (final AbstractCommand command : sequence) {
			result = command.execute(commandParameters);
		}
		return result;
	}

}
