package single_responsiblity.good;

/**
 * Here, for interest info operation we have created a separate class names InterestInfoService.
 * This follow the Single Responsibility Principle.
 */
public class InterestInfoService {

    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            // business logic
        }
        if (loanType.equals("personalLoan")) {
            // business logic
        }
        if (loanType.equals("car")) {
            // business logic
        }
        // ... more info
    }
}
