
package coaching.delegation;

import org.slf4j.*;

/**
 * Worker Class.
 */
class Worker implements ProcessInterface {

	protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	/**
	 * Instantiates a new worker.
	 */
	public Worker() {
		super();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see delegation.ProcessInterface#doProcess()
	 */
	@Override
	public Worker doProcess() {
		log.info("do work");
		return this;
	}

}
