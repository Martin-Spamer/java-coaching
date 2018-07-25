
package coaching.solid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * A class to Demonstrate the Single Responsibility Principle (SRP).
 *
 * Intent: A class should have only on reason to change, one responsibility.
 *
 */
public class SingleResponsibilityPrinciple {

    /** provides logging. */
    private static final Logger LOG = LoggerFactory
        .getLogger(SingleResponsibilityPrinciple.class);

    /**
     * An example of a class with Multiple Responsibilities.
     */
    public class MultipleResponsibility {

        /** The foo. */
        private boolean foo = false;

        /** The bar. */
        private boolean bar = false;

        /**
         * Foo and Bar responsibility.
         *
         * @param newFoo the new foo
         * @param newBar the new bar
         */
        public void doSomething(final boolean newFoo, final boolean newBar) {
            LOG.info("doSomething({},{})", newFoo, newBar);
            foo = newFoo;
            bar = newBar;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return String
                .format("%s [foo=%s, bar=%s]",
                        this.getClass().getSimpleName(),
                        foo,
                        bar);
        }
    }

    /**
     * Split out the Foo responsibility into a separate class.
     */
    public class Foo {

        /** The is foo. */
        private boolean isFoo = true;

        /**
         * Foo.
         *
         * @param newFoo the new foo
         */
        public void doFoo(final boolean newFoo) {
            LOG.info("doFoo({})", newFoo);
            isFoo = newFoo;
        }
    }

    /**
     * Split out the Bar responsibility into a separate class.
     */
    public class Bar {

        /** The is bar. */
        private boolean isBar = true;

        /**
         * Bar.
         *
         * @param newBar the new bar
         */
        public void doBar(final boolean newBar) {
            LOG.info("doBar({}", newBar);
            isBar = newBar;
        }
    }

    /**
     * A class with a Single Responsibility, a container for Foo and Bar.
     */
    public class SingleResponsibility {

        /** The foo. */
        private final Foo foo = new Foo();

        /** The bar. */
        private final Bar bar = new Bar();

        /**
         * Responsibility.
         */
        public void responsibility() {
            LOG.info("responsibility");
            foo.doFoo(true);
            bar.doBar(true);
        }
    }

    /**
     * Multiple responsibility.
     */
    public void multipleResponsibility() {
        final MultipleResponsibility multipleResponsibility = new MultipleResponsibility();
        assertNotNull(multipleResponsibility);
    }

    /**
     * Single responsibility.
     */
    public void singleResponsibility() {
        final SingleResponsibility singleResponsibility = new SingleResponsibility();
        assertNotNull(singleResponsibility);
    }

}
