package dev.ripanbaidya.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryApplication {
    // Factory method demo
    public static void main(String[] args) {
        // SpringApplication.run(FactoryApplication.class, args);
        NotificationFactory notification;

        // Email
        notification = new EmailNotificationFactory();
        notification.send("Welcome to the world of Java");

        // Push
        notification = new PushNotificationFactory();
        notification.send("You won the game");
    }

}
