
package coaching.solid;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

import coaching.application.SingleResponsibilityPrinciple;

/**
 * Unit Test for the Single Responsibility Principle (SIP) example class.
 */
public final class SingleResponsibilityPrincipleTest {

    /** Provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(SingleResponsibilityPrincipleTest.class);

    /**
     * Unit Test shows multiple responsibility.
     */
    @Test
    public void testMultipleResponsibility() {
        final SingleResponsibilityPrinciple multiple = new SingleResponsibilityPrinciple();
        assertNotNull(multiple);
        multiple.multipleResponsibility();
        LOG.debug("multiple = {}", multiple.toString());
    }

    /**
     * Unit Test to single responsibility.
     */
    @Test
    public void testSingleResponsibility() {
        final SingleResponsibilityPrinciple srp = new SingleResponsibilityPrinciple();
        assertNotNull(srp);
        srp.singleResponsibility();
        LOG.debug("srp = {}", srp.toString());
    }
}
