package dev.ripanbaidya.factory;

/**
 * Concrete factory
 */
public class EmailNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
