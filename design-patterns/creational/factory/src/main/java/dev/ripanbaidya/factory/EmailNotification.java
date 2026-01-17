package dev.ripanbaidya.factory;

/**
 * Email notification implementation
 * Concrete Product of Product (Notification)
 */
public class EmailNotification implements Notification{

    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
