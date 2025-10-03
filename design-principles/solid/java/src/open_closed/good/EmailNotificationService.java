package open_closed.good;

/**
 * this is an implementation class of NotificationService, which is responsible to send otp via email.
 * this will keep the codebase clear and easy to maintain, easy to understand.
 */
public class EmailNotificationService implements NotificationService{
    @Override
    public void sendOtp(String medium) {
        // send otp using Java Mail API
    }
}
