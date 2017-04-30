
package patterns.command;

/**
 * The ResultInterface Interface.
 */
public interface ResultInterface {

	/**
	 * Result.
	 *
	 * @param newResult the new result
	 * @return the result interface
	 */
	ResultInterface result(ResultInterface newResult);

}