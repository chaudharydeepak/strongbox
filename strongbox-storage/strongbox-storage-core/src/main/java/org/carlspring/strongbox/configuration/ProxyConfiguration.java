package org.carlspring.strongbox.configuration;

import javax.annotation.concurrent.Immutable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Collections;
import java.util.List;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jersey.repackaged.com.google.common.collect.ImmutableList;

/**
 * @author Przemyslaw Fusik
 * @see MutableProxyConfiguration
 */
@Immutable
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressFBWarnings(value = "AJCIP_FIELD_ISNT_FINAL_IN_IMMUTABLE_CLASS")
public class ProxyConfiguration
{

    private String host;

    private int port;

    private String username;

    private String password;

    private String type;

    private List<String> nonProxyHosts;

    ProxyConfiguration()
    {

    }

    public ProxyConfiguration(final MutableProxyConfiguration delegate)
    {
        this.host = delegate.getHost();
        this.port = delegate.getPort();
        this.username = delegate.getUsername();
        this.password = delegate.getPassword();
        this.type = delegate.getType();
        this.nonProxyHosts = immuteNonProxyHosts(delegate.getNonProxyHosts());
    }

    private List<String> immuteNonProxyHosts(final List<String> source)
    {
        return source != null ? ImmutableList.copyOf(source) : Collections.emptyList();
    }

    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getType()
    {
        return type;
    }

    public List<String> getNonProxyHosts()
    {
        return nonProxyHosts;
    }
}
