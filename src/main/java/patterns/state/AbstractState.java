
package patterns.state;

/**
 * AbstractState class.
 */
public abstract class AbstractState {

    /**
     * Handle the state, do what needs to be done when this state arises.
     */
    public abstract void handle();

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
