package single_responsiblity.good;

/**
 * Here, we have created a separate class names OtpService.
 * any modification we want to make in the future will not affect the other classes.
 * This follow the Single Responsibility Principle.
 */
public class OtpService {

    public void sendOtp() {
        // business logic .
    }
}
