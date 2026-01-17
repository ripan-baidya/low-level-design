package dev.ripanbaidya.factory;

/**
 * Simple factory pattern
 */
public class SimpleFactoryNotification {

    public static Notification createNotification(String type) {
        return switch (type) {
            case "EMAIL" -> new EmailNotification();
            case "PUSH" -> new PushNotification();
            // More notification types can be added here
            // ...
            default -> throw new IllegalArgumentException("Invalid notification type");
        };
    }
}
