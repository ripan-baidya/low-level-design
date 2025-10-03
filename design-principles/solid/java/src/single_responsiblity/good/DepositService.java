package single_responsiblity.good;

/**
 * Here, for deposit operation we have created a separate class names DepositService.
 * This follow the Single Responsibility Principle.
 */
public class DepositService {

    public void deposit(long amount, String accountNumber) {
        // business logic
        return;
    }
}
