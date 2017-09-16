/**
 * CurrentWorkingDirectory.java
 * Created on 21 July 2005, 14:39
 */

package coaching.fileio;

import java.io.File;

import org.slf4j.*;

/**
 * CurrentWorkingDirectory Class.
 */
public class CurrentWorkingDirectory {

	/** The log. */
	protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	/**
	 * Instantiates a new current working directory.
	 */
	public CurrentWorkingDirectory() {
		mark(this);
	}

	/**
	 * Mark.
	 *
	 * that
	 * string
	 *
	 * @param that the that
	 * @return the string
	 */
	public String mark(final Object that) {
		String absolutePath = null;
		try {
			final String className = that.getClass().getSimpleName();
			final String fileName = String.format("%s.CurrentWorkingDirectory", className);
			final File file = new File(fileName);
			try {
				file.createNewFile();
				absolutePath = file.getAbsolutePath();
				log.info("{}", absolutePath);
			} catch (final Exception exception) {
				log.debug(exception.toString());
			}
		} catch (final Exception exception) {
			log.error(exception.toString());
		}
		return absolutePath;
	}
}
