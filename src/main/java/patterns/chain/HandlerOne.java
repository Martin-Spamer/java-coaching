


package patterns.chain;

/**
 * HandlerOne Class.
 */
public class HandlerOne extends AbstractHandler {

	/**
	 * Instantiates a new handler one.
	 */
	public HandlerOne() {
		super();
	}

	/**
	 * Instantiates a new handler one.
	 *
	 * @param next the next
	 */
	public HandlerOne(final HandlerInterface next) {
		super(next);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.chain.Handler#handleRequest()
	 */
	@Override
	public void handleRequest(final RequestInterface request) {
		// do something
		// then pass request
		super.handleRequest(request);
	}

}
