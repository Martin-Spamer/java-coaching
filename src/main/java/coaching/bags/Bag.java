
package coaching.bags;

import java.util.*;

/**
 * Simple Bag Class.
 */
@SuppressWarnings("serial")
public class Bag extends ArrayList<String> implements BagInterface {
	private final Random random = new Random();
	private String[] initialState = new String[0];

	/**
	 * Instantiates a new empty bag.
	 */
	public Bag() {
		super();
		fill(initialState);
	}

	/**
	 * Instantiates a new bag from string array.
	 *
	 * values varargs
	 *
	 * @param values the values
	 */
	public Bag(final String... values) {
		super();
		fill(values == null ? new String[0] : values);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see coaching.bags.BagInterface#fill(java.lang.String[])
	 */
	@Override
	public BagInterface fill(final String... values) {
		if (values != null) {
			initialState = values;
			for (final String value : values) {
				this.add(value);
			}
		}
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	@Override
	public boolean add(final String value) {
		return super.add(value);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see coaching.bags.BagInterface#pick()
	 */
	@Override
	public String pick() {
		return choose();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see coaching.bags.BagInterface#choose()
	 */
	@Override
	public String choose() {
		final int size = size();
		if (size > 0) {
			final int nextInt = random.nextInt(size);
			final String remove = this.remove(nextInt);
			return remove;
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see coaching.bags.BagInterface#reset()
	 */
	@Override
	public BagInterface reset() {
		return fill(initialState);
	}

}
