


package coaching.idioms;

import org.slf4j.*;

/**
 * An AbstractLogging logging class.
 *
 * a protected logger can be used by any inheriting specialisation class.
 *
 * Each Class has its own logger, but uses this.getClass().getSimpleName()
 * to ensure polymorphic sub-classes always log under their name.
 *
 * logging layout formater (%F:%L) for click through in most IDEs.
 */
public abstract class AbstractLogging implements LoggingInterface {

	protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	/*
	 * (non-Javadoc)
	 *
	 * @see coaching.idioms.LoggingInterface#toLog()
	 */
	@Override
	public void toLog() {
		log.info("{}.toLog", this.getClass().getSimpleName());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see coaching.idioms.LoggingInterface#logTo(org.slf4j.Logger)
	 */
	@Override
	public void logTo(final Logger destinationLog) {
		destinationLog.info("{}.logTo", this.getClass().getSimpleName());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s [...]", this.getClass().getSimpleName());
	}

}
