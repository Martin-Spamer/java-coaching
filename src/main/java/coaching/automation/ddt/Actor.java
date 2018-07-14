
package coaching.automation.ddt;

/**
 * An Actor for automated testing.
 * Represents a person using the system in a role.
 */
public class Actor {

    /** The username. */
    private String username = "username";

    /** The password. */
    private String password = "password";

    /** The email. */
    private String email = "email@example.com";

    /**
     * Sets the username.
     *
     * @param username the username
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Sets the password.
     *
     * @param password the password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Sets the email.
     *
     * @param email the email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String
            .format("%s [username=%s, password=%s, email=%s]",
                    this.getClass().getSimpleName(),
                    username,
                    password,
                    email);
    }

}