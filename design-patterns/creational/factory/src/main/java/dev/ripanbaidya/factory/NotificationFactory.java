package dev.ripanbaidya.factory;

/**
 * Creator: A class that has a factory method for creating objects.
 */
public abstract class NotificationFactory {

    /**
     * Factory method
     */
    public abstract Notification createNotification();

    // Common logic using factory method
    public void send(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
