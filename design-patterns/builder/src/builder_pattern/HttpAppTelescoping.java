package builder_pattern;

import java.util.Map;

/**
 * Client Code
 * Here, we have use telescoping constructor to create objects. and this approach itself brings a lot of issues.
 * 1. It is not readable and hard to write.
 * 2. Inflexible: Suppose we want to see parameter 4 and 5, but not 2 and 3, but we have to pass 'null' to
 * 2 and 3 forcefully. otherwise we won't be able to create object.
 * 3. Error Prone: You could notice we have pass 'null' to many fields which are not required, and it is not good
 * at all. it creates a lot of room for errors.
 * 4. Poor Scalability: As the number of parameters increases, the constructor gets longer, and it creates an issue.
 */
public class HttpAppTelescoping {
    public static void main(String[] args) {
        HttpRequestTelescoping req1 = new HttpRequestTelescoping("https://api.example.com");

        HttpRequestTelescoping req2 = new HttpRequestTelescoping(
                "https://api.example.com/submit",
                "POST",
                null,
                null,
                "{\"key\":\"value\"}"
        );

        HttpRequestTelescoping req3 = new HttpRequestTelescoping(
                "https://api.example.com/config",
                "PUT",
                Map.of("X-API-Key", "secret"),
                null,
                "config_data",
                5000
        );

        System.out.println(req1);
        System.out.println(req2);
        System.out.println(req3);
    }
}
