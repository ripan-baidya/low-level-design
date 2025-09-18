package builder_pattern;

/**
 * The Builder Pattern: A clever solution to the problem of creating complex objects with numerous
 * optional fields.
 * It avoids the Telescoping Constructor Anti-Pattern, null parameters, and long constructors.
 * The builder simplifies the client code and makes it more readable.
 * It also easily extends as new fields are simply added to the builder.
 */
public class HttpAppBuilderPattern {
    public static void main(String[] args) {
        HttpRequest req1 = new HttpRequest.Builder("https://api.example.com").build();

        HttpRequest req2 = new HttpRequest.Builder("https://api.example.com/register")
                .method("POST")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer token")
                .addQueryParam("key", "value")
                .body("{ \"key\": \"value\" }")
                .timeout(5000)
                .build();

        HttpRequest req3 = new HttpRequest.Builder("https://api.example.com/users")
                .method("GET")
                .addHeader("Authorization", "Bearer token")
                .addQueryParam("key", "value")
                .timeout(5000)
                .build();


        System.out.println(req1);
        System.out.println(req2);
        System.out.println(req3);
    }
}
