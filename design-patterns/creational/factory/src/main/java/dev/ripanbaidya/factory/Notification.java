package dev.ripanbaidya.factory;

/**
 * Product: An interface or abstract class for the objects the factory method creates.
 * Notification is the product in this example.
 */
public interface Notification {

    /**
     * Send notification
     */
    void send(String message);
}
