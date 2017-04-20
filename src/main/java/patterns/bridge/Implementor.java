package patterns.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Implementor {

	protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	abstract public void operation();

}
