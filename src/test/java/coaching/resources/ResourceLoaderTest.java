
package coaching.resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;

/**
 * Unit tests for ResourceLoader class.
 */
@Slf4j
public final class ResourceLoaderTest {

    private static final String CONFIGURATION_PROPERTIES = "Configuration.properties";
    private static final String CONFIGURATION_XML = "Configuration.xml";
    private static final String MISSING_RESOURCE = "Missing";

    /**
     * Unit test to get stream.
     *
     * @throws IOException Signals that an I/O exception has occurred while
     *             reading the stream.
     */
    @Test
    public void testGetResource() throws IOException {
        final InputStream inputStream = ResourceStream.getStream(CONFIGURATION_PROPERTIES);
        assertNotNull(inputStream);
        assertTrue(inputStream.available() > 0);
        log.debug("ResourceLoader.getStream = {}", inputStream.toString());
    }

    /**
     * Unit test to get stream.
     *
     * @throws IOException Signals that an I/O exception has occurred while
     *             reading the stream.
     */
    @Test
    public void testGetXmlResource() throws IOException {
        final InputStream inputStream = ResourceStream.getStream(CONFIGURATION_XML);
        assertNotNull(inputStream);
        assertTrue(inputStream.available() > 0);
        log.debug("ResourceLoader.getStream = {}", streamToString(inputStream));
    }

    /**
     * Unit test to get missing stream.
     *
     * @throws IOException Signals that an I/O exception has occurred while
     *             reading the stream.
     */
    @Test(expected = ResourceNotLoadedException.class)
    public void testMissingXmlResource() throws IOException {
        final InputStream inputStream = ResourceStream.getStream(MISSING_RESOURCE);
        assertNotNull(inputStream);
        assertTrue(inputStream.available() > 0);
        log.debug("ResourceLoader.getStream = {}", streamToString(inputStream));
    }

    /**
     * Stream to string.
     *
     * @param inputStream the input stream
     * @return the string
     */
    private String streamToString(final InputStream inputStream) {
        final Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        final String string = s.hasNext() ? s.next() : "";
        s.close();
        return string;
    }

}
