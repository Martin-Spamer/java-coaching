
package coaching.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import coaching.WorkInProgress;
import lombok.extern.slf4j.Slf4j;

/**
 * Given an XML data file, use it to update a database via JDBC.
 */
@WorkInProgress("")
@Slf4j
public final class XmlToJdbc {

    /**
     * Instantiates a new xml to jdbc.
     */
    public XmlToJdbc() {
        super();
    }

    /**
     * Process.
     */
    public void process() {
        final String simpleName = String.format("%s.xml", this.getClass().getSimpleName());
        processFile(simpleName);
    }

    /**
     * Process.
     *
     * @param filename the filename
     */
    public void processFile(final String filename) {
        try {
            final File configFile = new File(filename);
            final DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder = builderFactory.newDocumentBuilder();
            final Document document = builder.parse(configFile);

            processTable(document);

        } catch (final Exception exception) {
            log.error("Failed with {} ", exception);
        }
    }

    /**
     * Process table.
     *
     * @param document the document
     */
    private void processTable(final Document document) {
        // root Document Element
        final Element tableElement = document.getDocumentElement();

        if (tableElement.getNodeName().equals("TABLE")) {
            final String tableName = tableElement.getAttribute("NAME");

            // get a list of rows
            final NodeList rowList = tableElement.getElementsByTagName("ROW");

            // * list of rows
            for (int rowNo = 0; rowNo < rowList.getLength(); rowNo++) {
                final String temp = rowList.item(rowNo).toString();
                processRow(tableName, rowList, rowNo, temp);
            }
        }
    }

    /**
     * Process row.
     *
     * @param table the table
     * @param rowList the row list
     * @param rowNo the row no
     * @param value the temp
     */
    private void processRow(final String table, final NodeList rowList, final int rowNo, final String value) {
        try {
            // * first row element by index.
            final Element rowElement = (Element) rowList.item(rowNo);

            // * fields
            final NodeList fieldList = rowElement.getElementsByTagName("FIELD");

            final String fieldNames = fieldNames(fieldList);
            final String dataValues = dataValues(fieldList);

            insertRow(table, fieldNames, dataValues);

        } catch (final Exception exception) {
            log.error("Failed with {} ", exception);
        }
    }

    /**
     * Field names.
     *
     * @param fieldList the field list
     * @return the string
     */
    private String fieldNames(final NodeList fieldList) {
        final StringBuilder fieldNames = new StringBuilder();
        final char columnSeparator = ' ';

        for (int fieldNo = 0; fieldNo < fieldList.getLength(); fieldNo++) {
            final Node item = fieldList.item(fieldNo);
            log.info(item.toString());
            final Element fieldElement = (Element) item;
            fieldNames.append(columnSeparator).append(fieldElement.getAttribute("NAME"));
        }
        return fieldNames.toString();
    }

    /**
     * Data values.
     *
     * @param fieldList the field list
     * @return the string
     */
    private String dataValues(final NodeList fieldList) {
        final StringBuilder dataValues = new StringBuilder();
        final char columnSeperator = ',';

        for (int fieldNo = 0; fieldNo < fieldList.getLength(); fieldNo++) {
            final Node item = fieldList.item(fieldNo);
            log.info(item.toString());
            final Element fieldElement = (Element) item;
            final String nodeValue = fieldElement.getChildNodes().item(0).getNodeValue();
            dataValues.append(columnSeperator).append("'").append(nodeValue).append("'");
        }
        return dataValues.toString();
    }

    /**
     * Insert row.
     *
     * @param table the table
     * @param fieldNames the field names
     * @param dataValues the data values
     */
    private void insertRow(final String table, final String fieldNames, final String dataValues) {
        // insert into %table
        // (%field%,...)
        // from
        // (%value%,...)
        final StringBuilder sql = new StringBuilder();
        sql.append(String.format("insert into %s", table));
        sql.append(String.format(" (%s) VALUES (%s)", fieldNames, dataValues));

        log.info(sql.toString());
        // super.executePreparedStatement(sql.toString());
    }
}
