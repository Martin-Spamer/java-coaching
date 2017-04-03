
package delegation;

/**
 * The Class Manager.
 */
class Manager implements ProcessInterface {

	/** The worker. */
	Worker worker;

	/**
	 * Instantiates a new manager.
	 */
	public Manager() {
		super();
		worker = new Worker();
	}

	/**
	 * Gets the worker.
	 *
	 * @return the worker
	 */
	public Worker getWorker() {
		return worker;
	}

	/**
	 * Sets the worker.
	 *
	 * @param worker the new worker
	 */
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see delegation.ProcessInterface#doProcess()
	 */
	public void doProcess() {
		worker.doProcess();
	}
}
