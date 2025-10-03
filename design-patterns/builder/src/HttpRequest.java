package builder_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * To overcome the drawbacks of the telescoping constructor pattern, the Builder pattern is employed.
 * The Builder pattern allows for the construction of complex objects step by step and provides a more
 * flexible and readable way to build objects.
 *
 * The Builder pattern consists of a Product class (in this case, HttpRequest) and a Builder class.
 * The Builder class encapsulates the construction of the HttpRequest object and provides methods to
 * set all the mandatory and optional parameters. The constructor of the HttpRequest class is
 * private, forcing the client to create an object using the Builder.
 *
 * The Builder class is a static nested class within HttpRequest and is responsible for constructing the
 * HttpRequest object. It provides a fluent interface that allows clients to set up each part of the
 * request step by step.
 *
 * This pattern enhances the flexibility of object creation, making it easier to customize and manage
 * the construction process.
 */
class HttpRequest {
    // Required
    private final String url;

    // Optional
    private final String method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final String body;
    private final int timeout;

    // Private constructor
    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.queryParams = builder.queryParams;
        this.body = builder.body;
        this.timeout = builder.timeout;
    }

    // Getters (optional)
    public String getUrl() { return url; }
    public String getMethod() { return method; }
    public Map<String, String> getHeaders() { return headers; }
    public Map<String, String> getQueryParams() { return queryParams; }
    public String getBody() { return body; }
    public int getTimeout() { return timeout; }

    // toString method
    @Override
    public String toString() {
        return "HttpRequest{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", headers=" + headers +
                ", queryParams=" + queryParams +
                ", body='" + body + '\'' +
                ", timeout=" + timeout +
                '}';
    }

    // Builder Class
    public static class Builder {
        // Required
        private final String url;

        // Optional
        private String method = "GET";
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();
        private String body;
        private int timeout = 30000;

        public Builder(String url) {
            this.url = url;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder addQueryParam(String key, String value) {
            this.queryParams.put(key, value);
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}
