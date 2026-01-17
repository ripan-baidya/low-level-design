package dev.ripanbaidya.factory;

/**
 * Push notification
 * Concrete Product of Product (Notification)
 */
public class PushNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending Push notification: " + message);
    }
}
