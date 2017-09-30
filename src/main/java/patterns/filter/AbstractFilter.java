
package patterns.filter;

/**
 * AbstractFilter Class.
 */
public class AbstractFilter implements FilterInterface {

	private FilterInterface nextFilter = null;

	/**
	 * Instantiates a new abstract filter.
	 */
	public AbstractFilter() {
		super();
	}

	/**
	 * Instantiates a new abstract filter.
	 *
	 * @param filter the filter
	 */
	public AbstractFilter(final FilterInterface filter) {
		super();
		addNextFilter(filter);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.filter.FilterInterface#addNextFilter(patterns.filter.
	 * FilterInterface)
	 */
	@Override
	public FilterInterface addNextFilter(final FilterInterface newFilter) {
		if (nextFilter == null) {
			nextFilter = newFilter;
		} else {
			nextFilter.addNextFilter(newFilter);
		}
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see patterns.filter.FilterInterface#handleRequest(patterns.filter.
	 * PayloadInterface)
	 */
	@Override
	public void handleRequest(final PayloadInterface payload) {
		if (nextFilter != null) {
			nextFilter.handleRequest(payload);
		}
	}

}
