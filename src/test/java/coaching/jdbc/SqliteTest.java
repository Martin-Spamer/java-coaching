
package coaching.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class SqliteTest {

    @Test
    public void testSqlite() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");

            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");

            final Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.

            statement.executeUpdate("DROP TABLE IF EXISTS person");
            statement.executeUpdate("CREATE TABLE person (id INTEGER, name STRING)");

            final int ids[] = { 1, 2, 3, 4, 5 };
            final String names[] = { "Peter", "Pallar", "William", "Paul", "James Bond" };

            for (int i = 0; i < ids.length; i++) {
                statement.executeUpdate("INSERT INTO person values(' " + ids[i] + "', '" + names[i] + "')");
            }

            // statement.executeUpdate("UPDATE person SET name='Peter' WHERE
            // id='1'");
            // statement.executeUpdate("DELETE FROM person WHERE id='1'");

            final ResultSet resultSet = statement.executeQuery("SELECT * from person");

            while (resultSet.next()) {
                // iterate & read the result set
                System.out.println("name = " + resultSet.getString("name"));
                System.out.println("id = " + resultSet.getInt("id"));
            }
        }

        catch (final SQLException e) {
            System.err.println(e.getMessage());
        } catch (final ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (final SQLException e) {
                System.err.println(e);
            }
        }
    }
}