/**
 *  @title       Guid.java
 *  @description TODO
 *	Created      28-Oct-2004
 **/

package coaching.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NetInfo class.
 */
public final class NetInfo {

    /** Provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(NetInfo.class);

    /**
     * Instantiates a new net info.
     *
     * @throws SocketException
     */
    public NetInfo() throws SocketException {
        final Enumeration<NetworkInterface> interfaces = NetworkInterface
            .getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            final NetworkInterface networkInterface = interfaces.nextElement();
            LOG.info("{}", networkInterface.getDisplayName());
            final Enumeration<InetAddress> bounded = networkInterface
                .getInetAddresses();
            while (bounded.hasMoreElements()) {
                final InetAddress inetAddress = bounded.nextElement();
                LOG
                    .info("inetAddress.getHostAddress() = {}",
                            inetAddress.getHostAddress());
                LOG
                    .info("inetAddress.getHostName() = {}",
                            inetAddress.getHostName());
            }
        }
    }
}
