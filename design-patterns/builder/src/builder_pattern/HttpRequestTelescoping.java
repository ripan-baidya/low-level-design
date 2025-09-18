package builder_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Imagine we are building a system that needs to configure and create HTTP requests. which has many
 * fields. like - url, method, header, body, timeout, etc. among these fields some are mandatory and some are
 * optional.
 *
 * At first glance, it seems reasonable to create a constructor with all the parameters. However, when the number
 * of fields increases, so does the constructor get longer, and it creates an issue. This is known as the Telescoping
 * Constructor Anti-Pattern.
 *
 * The common approach to resolve the issue is Constructor Overloading. However, this approach has its own issues.
 */
public class HttpRequestTelescoping {
    // Required
    private String url;

    // Optional
    private String method;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private String body;
    private int timeout;

    public HttpRequestTelescoping(String url) {
        this(url, "GET");
    }

    public HttpRequestTelescoping(String url, String method) {
        this(url, method, null);
    }

    public HttpRequestTelescoping(String url, String method, Map<String, String> headers) {
        this(url, method, headers, null);
    }

    public HttpRequestTelescoping(String url, String method, Map<String, String> headers,
                                  Map<String, String> queryParams) {
        this(url, method, headers, queryParams, null);
    }

    public HttpRequestTelescoping(String url, String method, Map<String, String> headers,
                                  Map<String, String> queryParams, String body) {
        this(url, method, headers, queryParams, body, 30000);
    }

    public HttpRequestTelescoping(String url, String method, Map<String, String> headers,
                                  Map<String, String> queryParams, String body, int timeout) {
        this.url = url;
        this.method = method;
        this.headers = headers == null ? new HashMap<>() : headers;
        this.queryParams = queryParams == null ? new HashMap<>() : queryParams;
        this.body = body;
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "HttpRequestTelescoping{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", queryParams=" + queryParams +
                ", body='" + body + '\'' +
                ", timeout=" + timeout +
                '}';
    }

    // Getter methods ..
}
