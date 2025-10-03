package open_closed.bad;

/**
 * Let's talk about open closed principle.
 * The open closed principle is a design principle that states software entities (classes, modules, functions, etc.)
 * should be open for extension but closed for modification.
 * what it means is that we should be able to extend the functionality of a class without modifying its existing code.
 *
 * Let's say we have a class NotificationService that is responsible to sendOtp via Email (right now).
 * Just imagine, in future we have the requirement to sendOtp via SMS, Whatsapp and Push Notification.
 * at that moment we again have to modify the 'sendOtp' method, which is not a good practice. and it
 * violates the open closed principle.
 *
 * So, we could create an interface name NotificationService and define the 'sendOtp' method in it.
 * and we will create implementation classes to distribute the task to different classes. like
 * 'EmailNotificationService', 'SmsNotificationService', 'WhatsappNotificationService', 'PushNotificationService' etc.
 */
public class NotificationService {

    public void sendOtp(String medium) {
        if (medium.equals("email")) {
            // send email using Java Mail API
        }
        // future requirement
        // else if (medium.equals("sms")) {
        //
        // }
    }
}
