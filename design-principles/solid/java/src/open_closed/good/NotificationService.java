package open_closed.good;

/**
 * This is an interface which will have a method 'sendOtp'.
 * based on our requirement we could extend the interface and could implement our own
 * notification service. like: sms, whatsapp, push notification etc.
 */
public interface NotificationService {
    public void sendOtp(String medium);
}
