

package coaching.jdbc;

import java.sql.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

/**
 * Provides a XML reader for input and a JDBC PointBase Database for output.
 * @author martin.spamer
 * @version 0.1 - 12:33:20
 */
public final class XmlDao extends AbstractDataAccessObject {

	private static final String JDBC_DRIVER = "com.pointbase.jdbc.jdbcUniversalDriver";
	private static final String JDBC_URL = "jdbc:pointbase:server://localhost/sample";
	private static final String USER = "PBPUBLIC";
	private static final String PASSWORD = "PBPUBLIC";
	private static final String SQL = "SELECT * from customers";

	/**
	 * Instantiates a new xml DAO.
	 */
	public XmlDao() {
		super(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
	}

	/**
	 * To xml string.
	 *
	 * @return the string
	 */
	public String toXmlString() {
		try {
			read(SQL);
			final String xmlString = toXmlString(this.resultSet);
			this.resultSet.close();
			return xmlString;
		} catch (final SQLException e) {
			log.error("{}", e.toString());
		}
		return null;
	}

	/**
	 * To xml document.
	 *
	 * @return the document
	 */
	public Document toXmlDocument() {
		try {
			read(SQL);
			final Document xmlDocument = toXmlDocument(this.resultSet);
			this.resultSet.close();
			return xmlDocument;
		} catch (final SQLException e) {
			log.error("{}", e.toString());
		}
		return null;
	}

	/**
	 * data as XML.
	 *
	 * @param resultSet the result set
	 * @return the document
	 */
	protected Document toXmlDocument(final ResultSet resultSet) {
		Document document = null;

		try {
			final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.newDocument();

			final ResultSetMetaData metaData = resultSet.getMetaData();
			final int colCount = metaData.getColumnCount();

			final Element results = document.createElement("TABLE");
			document.appendChild(results);

			while (resultSet.next()) {
				final Element row = document.createElement("ROW");
				results.appendChild(row);

				for (int i = 1; i <= colCount; i++) {
					final String columnName = metaData.getColumnName(i);
					final Object value = resultSet.getObject(i);

					if (value != null) {
						final Element node = document.createElement(columnName);
						final String string = String.format("%s", value);
						final Text createTextNode = document.createTextNode(string);
						node.appendChild(createTextNode);
						row.appendChild(node);
					}
				}
			}
		} catch (final Exception e) {
			log.error("{}", e.toString());
		}

		return document;
	}

	/**
	 * data as an XML encoded string.
	 *
	 * @param resultSet the result set
	 * @return the string
	 */
	protected String toXmlString(final ResultSet resultSet) {
		final StringBuffer xml = new StringBuffer();

		try {
			final ResultSetMetaData metaData = resultSet.getMetaData();
			final int colCount = metaData.getColumnCount();

			while (resultSet.next()) {
				xml.append("<TABLE>\n");

				for (int i = 1; i <= colCount; i++) {
					xml.append("<ROW>\n");
					final String columnLabel = metaData.getColumnName(i);
					final Object value = resultSet.getObject(i);
					final String columnAsXml = columnValue(columnLabel, value);
					xml.append(columnAsXml);
				}
				xml.append("</ROW>\n");
			}
			xml.append("</TABLE>\n");
			resultSet.close();
		} catch (final Exception e) {
			log.error("{}", e.toString());
		}
		return xml.toString();
	}

	/**
	 * Column value.
	 *
	 * @param columnName the column name
	 * @param value the value
	 * @return the string
	 */
	protected String columnValue(final String columnName, final Object value) {
		return String.format("<%s>%s</%s>", columnName, value, columnName);
	}

}
