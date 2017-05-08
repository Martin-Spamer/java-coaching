package patterns.chain;

/**
 * The HandlerInterface Interface.
 */
public interface HandlerInterface {

	/**
	 * Handle request.
	 *
	 * @return the handler interface
	 */
	abstract void handleRequest(RequestInterface request);

}