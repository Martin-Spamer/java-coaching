/**
 * VehicleInterface.
 * Created on 06-Jul-2004
 */
package coaching.associations;

/**
 * Vehicle Interface.
 */
public interface VehicleInterface {

	/**
	 * set the vehicle's driver.
	 *
	 * @param driver the new
	 * @return this for a fluent interface.
	 */
	public VehicleInterface setDriver(Driver driver);

	/**
	 * driver.
	 *
	 * @return the driver
	 */
	public Driver getDriver();

	/**
	 * Travel destination.
	 *
	 * @param destination the destination
	 * @return this for a fluent interface.
	 */
	public VehicleInterface travel(String destination);

}
