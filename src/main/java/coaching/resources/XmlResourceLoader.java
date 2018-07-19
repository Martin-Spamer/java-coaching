
package coaching.resources;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import static org.junit.Assert.fail;

/**
 * The Class XmlResourceLoader.
 */
public final class XmlResourceLoader {

    /** SUFFIX 			constant. */
    private static final String SUFFIX = ".xml";

    /** LOG 			constant. */
    private static final Logger LOG = LoggerFactory
        .getLogger(XmlResourceLoader.class);

    /**
     * Instantiates a new xml resource loader.
     */
    private XmlResourceLoader() {
        fail("Use static methods");
    }

    /**
     * Gets the xml resource.
     *
     * @param resourceName the resource name
     * @return the xml resource
     */
    public static Document getXmlResource(final String resourceName) {
        final InputStream stream = ResourceLoader
            .getStream(xmlFilename(resourceName));
        try {
            final DocumentBuilder builder = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder();
            return builder.parse(stream);
        } catch (final Exception exception) {
            final String message = String
                .format("Failed to parse resource %s", resourceName);
            LOG.error(message, exception);
            throw new ResourceNotLoadedException(message, exception);
        }
    }

    /**
     * Xml filename.
     *
     * @param resourceName the resource name
     * @return the string
     */
    private static String xmlFilename(final String resourceName) {
        String suffix = ".xml";
        if (resourceName.endsWith(suffix)) {
            return resourceName;
        } else {
            return String.format("%s%s", resourceName, suffix);
        }
    }

    /**
     * Xml to string.
     *
     * @param xml the xml
     * @return the string
     */
    public static String xmlToString(final Document xml) {
        try {
            final TransformerFactory factory = TransformerFactory.newInstance();
            final Transformer transformer = factory.newTransformer();
            transformer
                .setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            final StringWriter stringWriter = new StringWriter();
            final DOMSource xmlSource = new DOMSource(xml);
            final StreamResult outputTarget = new StreamResult(stringWriter);
            transformer.transform(xmlSource, outputTarget);
            return stringWriter.toString();
        } catch (
                IllegalArgumentException |
                    TransformerFactoryConfigurationError |
                    TransformerException e) {
            final String message = String
                .format("Failed to parse XML Document. %s",
                        e.getLocalizedMessage());
            LOG.error(message, e);
        }
        return null;
    }
}
