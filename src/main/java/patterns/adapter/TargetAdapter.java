
package patterns.adapter;

/**
 * TargetAdapter Class.
 */
public class TargetAdapter extends AbstractAdapter {

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.adapter.AbstractAdapter#request()
	 */
	@Override
	public Result request() {
		final Target target = new Target();
		final Result result = target.request();
		return result;
	}

}
