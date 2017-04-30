
package patterns.router;

/**
 * The Router Class.
 */
class Router implements InputChannel, OutputChannel {

	private OutputChannel outputChannel;

	private InputChannel inputChannel;

	/**
	 * Adds the route.
	 */
	public void addRoute() {
	}

	/**
	 * Removes the route.
	 */
	public void removeRoute() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see patterns.router.OutputChannel#sendMessage(patterns.router.Message)
	 */
	@Override
	public void sendMessage(final Message message) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see patterns.router.InputChannel#receiveMessage(patterns.router.Message)
	 */
	@Override
	public void receiveMessage(Message message) {
	}

}
