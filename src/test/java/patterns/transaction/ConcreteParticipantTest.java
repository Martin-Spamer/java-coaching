
package patterns.transaction;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * class ConcreteParticipantTest.
 */
public final class ConcreteParticipantTest {

    /**
     * Unit Test to commit.
     */
    @Test
    public void testCommit() {
        final ConcreteParticipant testInstance = new ConcreteParticipant();
        assertNotNull(testInstance);
    }

}
