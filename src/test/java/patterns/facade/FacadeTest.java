
package patterns.facade;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * class FacadeTest.
 */
public final class FacadeTest {

    /**
     * Unit Test to concrete facade operation.
     */
    @Test
    public void testConcreteFacadeOperation() {
        ConcreteFacade object = new ConcreteFacade();
        assertNotNull(object);
        object.operation();
    }

}
