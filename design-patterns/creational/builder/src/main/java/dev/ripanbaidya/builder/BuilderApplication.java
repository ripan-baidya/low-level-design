package dev.ripanbaidya.builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuilderApplication {
    public static void main(String[] args) {
        // SpringApplication.run(BuilderApplication.class, args);
        HttpRequest req = new HttpRequest.Builder("https://api.example.com/data")
                .method("POST")
                .header("Content-Type", "application/json")
                .body("{\"key\":\"value\"}")
                .timeout(3000)
                .build();

        HttpRequest req2 = new HttpRequest.Builder("https://api.example.com/config")
                .method("PUT")
                .header("X-API-Key", "secret")
                .param("env", "prod")
                .body("config_payload")
                .timeout(5000)
                .build();


        System.out.println(req);
        System.out.println(req2);
    }

}
