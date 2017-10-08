


package patterns.builder;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * class DirectorTest.
 */
public class DirectorTest {

	/**
	 * Unit Test to director.
	 */
	@Test
	public void testDirector() {
		final Director director = new Director();

		final BuilderOne builderOne = new BuilderOne();
		assertNotNull("Value cannot be null", builderOne);
		director.add(builderOne);

		final BuilderTwo builderTwo = new BuilderTwo();
		assertNotNull("Value cannot be null", builderTwo);
		director.add(builderTwo);

		final Product product = director.constructProduct();
		assertNotNull("Value cannot be null", product);

	}

}
