package javamentor.xml;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * DOM Element Mapper Class.
 */
public class ElementMapper {

	private static final Logger log = LoggerFactory.getLogger(ElementMapper.class);
	private String indexName = "id";
	private final HashMap<String, Element> elementMap = new HashMap<String, Element>();

	/**
	 * Instantiates a new element mapper.
	 */
	public ElementMapper() {
	}

	/**
	 * Instantiates a new element mapper.
	 *
	 * @param nodeList the node list
	 */
	public ElementMapper(final NodeList nodeList) {
		initialisation(nodeList);
	}

	/**
	 * Initialisation.
	 *
	 * @param nodeList the node list
	 */
	public void initialisation(final NodeList nodeList) {
		for (int index = 0; index < nodeList.getLength(); index++) {
			final Element element = (Element) nodeList.item(index);
			final String key = element.getAttribute(this.indexName);
			this.elementMap.put(key, element);
			ElementMapper.log.info("{}={}", this.indexName, element);
		}
	}

	/**
	 * Gets the text.
	 *
	 * @param node the node
	 * @return the text
	 */
	public static String getText(final Node node) {
		// We need to retrieve the text from elements, entity
		// references, CDATA sections, and text nodes; but not
		// comments or processing instructions
		final int type = node.getNodeType();
		if (type == Node.COMMENT_NODE || type == Node.PROCESSING_INSTRUCTION_NODE) {
			return "";
		}

		final StringBuffer text = new StringBuffer();

		final String value = node.getNodeValue();
		if (value != null) {
			text.append(value);
		}

		if (node.hasChildNodes()) {
			final NodeList children = node.getChildNodes();
			for (int index = 0; index < children.getLength(); index++) {
				final Node child = children.item(index);
				text.append(getText(child));
			}
		}
		return text.toString();
	}

	/**
	 * Find element.
	 *
	 * @param attributeName the attribute name
	 * @return the element
	 */
	public Element findElement(final String attributeName) {
		final Element element = this.elementMap.get(attributeName);
		return element;
	}

	/**
	 * Find element text.
	 *
	 * @param attributeName the attribute name
	 * @return the string
	 */
	public String findElementText(final String attributeName) {
		final Node node = this.elementMap.get(attributeName);
		return getText(node);
	}

	/**
	 * Index name.
	 *
	 * @param indexAttribute the index attribute
	 * @return the string
	 */
	public String indexName(final String indexAttribute) {
		if (indexAttribute != null) {
			this.indexName = indexAttribute;
		}
		return this.indexName;
	}
}