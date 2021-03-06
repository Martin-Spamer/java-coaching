
package coaching.range;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class LongRangeTest {

    /**
     *  provides logging.
     */

    @Test
    public void testLongRange() {
        assertNotNull(new LongRange(0L, 0L));
        assertNotNull(new LongRange(0L, 0L, 0L));
        log.info("{}", new LongRange(Long.MIN_VALUE, Long.MAX_VALUE));
        log.info("{}", new LongRange(Long.MAX_VALUE, Long.MIN_VALUE));
    }

    /**
     * test LongRange object.
     */
    @Test
    public void testRangeOf() {
        assertNotNull(LongRange.of(0L, 0L));
        assertNotNull(LongRange.of(0L, 1L));
        assertNotNull(LongRange.of(1L, 1L));
        LongRange actual = LongRange.of(1L, 3L);
        assertNotNull(actual);
        log.info("{}", actual);
        LongRange expected = LongRange.of(1L, 3L, 1L);
        assertNotNull(expected);
        log.info("{}", expected);
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * test LongRange object.
     */
    @Test
    public void testLongRangeIncludes() {
        LongRange range1to3 = new LongRange(1, 3);
        // assertTrue(range1to3.includes(1));
        // assertTrue(range1to3.includes(2));
        // assertTrue(range1to3.includes(3));
        // assertFalse(range1to3.includes(0));
        // assertFalse(range1to3.includes(4));
    }

    /**
     * test LongRange object.
     */
    @Test
    public void testRangeIncludes() {
        assertTrue(LongRange.of(0, 0).includes(0));
        // assertTrue(Range.of(0, 1).includes(0));
        // assertTrue(Range.of(0, 1).includes(1));
        // assertTrue(Range.of(1, 1).includes(1));
        // assertTrue(Range.of(1, 3, 1).includes(Range.of(1, 3, 1)));
        // assertFalse(Range.of(0, 0).includes(1));
    }

    /**
     * test LongRange object.
     */
    @Test
    public void testLongRangeExcludes() {
        LongRange range1to3 = new LongRange(1, 3);
        assertTrue(range1to3.excludes(0));
        assertTrue(range1to3.excludes(4));
        assertFalse(range1to3.excludes(1));
        assertFalse(range1to3.excludes(2));
        assertFalse(range1to3.excludes(3));
    }

    /**
     * test LongRange object.
     */
    @Test
    public void testRangeExcludes() {
        assertTrue(Range.of(0, 0).excludes(1));
        assertTrue(Range.of(0, 1).excludes(2));
        assertTrue(Range.of(1, 1).excludes(0));
        assertTrue(Range.of(1, 1).excludes(2));
        assertFalse(Range.of(1, 1).excludes(1));
    }

}
