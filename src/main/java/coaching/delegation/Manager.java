
package coaching.delegation;

/**
 * Manager class with delegation.
 */
public class Manager implements ProcessInterface {

    /** The worker. */
    private Worker worker;

    /**
     * Instantiates a new manager, with a new Worker instance.
     */
    public Manager() {
        super();
        this.worker = new Worker();
    }

    /**
     * configure the worker to receive delegation.
     *
     * worker manager
     *
     * @param worker the worker
     * @return the manager
     */
    public Manager setWorker(final Worker worker) {
        this.worker = worker;
        return this;
    }

    /*
     * (non-Javadoc)
     * @see delegation.ProcessInterface#doProcess()
     */
    @Override
    public Manager doProcess() {
        this.worker.doProcess();
        return this;
    }

}
