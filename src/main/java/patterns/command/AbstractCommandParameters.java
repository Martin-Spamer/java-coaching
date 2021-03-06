
package patterns.command;

import java.util.Properties;
import java.util.Set;

/**
 * Abstract class for Parameters to Commands.
 */
public abstract class AbstractCommandParameters implements ParametersInterface {

    /** The parameters. */
    private final Properties parameters = new Properties();

    /**
     * Instantiates a new abstract parameters.
     */
    public AbstractCommandParameters() {
        super();
    }

    /**
     * Instantiates a new abstract parameters.
     *
     * @param key the key
     * @param value the value
     */
    public AbstractCommandParameters(final String key, final String value) {
        setParameter(key, value);
    }

    /*
     * (non-Javadoc)
     * @see patterns.command.ParametersInterface#setParameter(java.lang.String,
     * java.lang.String)
     */
    @Override
    public AbstractCommandParameters setParameter(final String key, final String value) {
        this.parameters.setProperty(key, value);
        return this;
    }

    /*
     * (non-Javadoc)
     * @see patterns.command.ParametersInterface#stringPropertyNames()
     */
    @Override
    public Set<String> stringPropertyNames() {
        return this.parameters.stringPropertyNames();
    }

    /*
     * (non-Javadoc)
     * @see patterns.command.ParametersInterface#valueFor(java.lang.String)
     */
    @Override
    public String valueFor(final String key) {
        return this.parameters.getProperty(key);
    }

    /*
     * (non-Javadoc)
     * @see patterns.command.ParametersInterface#valueFor(java.lang.String,
     * java.lang.String)
     */
    @Override
    public String valueFor(final String key, final String defaultValue) {
        return this.parameters.getProperty(key, defaultValue);
    }

    /*
     * (non-Javadoc)
     * @see patterns.command.ParametersInterface#valueFor(java.lang.String,
     * java.lang.Boolean)
     */
    @Override
    public Boolean valueFor(final String key, final Boolean defaultValue) {
        final String property = this.parameters.getProperty(key, defaultValue.toString());
        return Boolean.parseBoolean(property);
    }

    /*
     * (non-Javadoc)
     * @see patterns.command.ParametersInterface#valueFor(java.lang.String,
     * java.lang.Long)
     */
    @Override
    public Long valueFor(final String key, final Long defaultValue) {
        final String property = this.parameters.getProperty(key, defaultValue.toString());
        return Long.parseLong(property);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [parameters=%s]", this.getClass().getSimpleName(), this.parameters);
    }

}
