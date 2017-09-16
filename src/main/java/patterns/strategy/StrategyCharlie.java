package patterns.strategy;

/**
 * StrategyThree Class.
 */
class StrategyCharlie extends AbstractStrategy {

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.strategy.AbstractStrategy#operation()
	 */
	@Override
	public void operation() {
		log.info("operation()");
	}

}