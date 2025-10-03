package open_closed.good;

/**
 * this is an implementation class of NotificationService, which is responsible to send otp via email.
 * this will keep the codebase clear and easy to maintain, easy to understand.
 */
public class SMSNotificationService implements NotificationService{
    @Override
    public void sendOtp(String medium) {
        // send otp using sms
    }
}
