package patterns.interpreter;

/**
 * Terminal Expression Class.
 */
public class TerminalExpression extends AbstractExpression {

	private final Data data;

	/**
	 * Instantiates a new terminal expression.
	 *
	 * @param data the data
	 */
	public TerminalExpression(final Data data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * patterns.interpreter.AbstractExpression#interpret(patterns.interpreter.
	 * ContextInterface)
	 */
	@Override
	public boolean interpret(final ContextInterface context) {
		return context.contains(this.data);
	}

}
