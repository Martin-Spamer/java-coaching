
package patterns.router;

/**
 * The InputChannel Interface.
 */
public interface InputChannel {

	/**
	 * Receive message.
	 *
	 * @param message the message
	 */
	public void receiveMessage(Message message);

}
