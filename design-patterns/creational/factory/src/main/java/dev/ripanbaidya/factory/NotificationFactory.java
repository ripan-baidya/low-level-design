package dev.ripanbaidya.factory;

public abstract class NotificationFactory {

    /**
     * Factory method
     *
     * @return type of notification
     */
    public abstract Notification createNotification();

    // Common logic using factory method
    public void send(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}
