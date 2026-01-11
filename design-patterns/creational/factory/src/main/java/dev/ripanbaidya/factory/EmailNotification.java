package dev.ripanbaidya.factory;

/**
 * Email notification implementation
 */
public class EmailNotification implements Notification{

    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}
