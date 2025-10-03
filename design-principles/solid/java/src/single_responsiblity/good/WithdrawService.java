package single_responsiblity.good;

/**
 * Here, for withdraw operation we have created a separate class names WithdrawService.
 * This follow the Single Responsibility Principle.
 */
public class WithdrawService {

    public long withdraw(long amount, String accountNumber) {
        // business logic
        return 0L;
    }
}
