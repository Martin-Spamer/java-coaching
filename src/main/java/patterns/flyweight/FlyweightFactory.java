package patterns.flyweight;

import java.util.Vector;

/**
 * A factory for creating FlyWeight objects.
 */
public final class FlyweightFactory {

	public Vector<FlyWeight> flyWeight;

	public FlyWeight create() {
		return new FlyWeight("CommonState");
	}

}
