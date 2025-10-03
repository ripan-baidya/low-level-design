package single_responsiblity.bad;

/**
 * Let's say we have a class BankService that is responsible to perform various operations.
 * like: deposit, withdraw, getLoanInfo, sendOtp etc.
 *
 * Just think about the BankService, it is responsible to perform various operations.
 * For example:
 * say 'getLoanInteresetInfo' method is responsible to provide loan interest info. Right now it provides information
 * about 'homeLoan', 'personalLoan' and 'carLoan'. In future we may have the requirement to provide information about
 * 'businessLoan' and 'educationLoan' and so on. at that moment we again have to modify the 'getLoanInterestInfo' method.
 *
 * also, Let's say Bank send otp to there customer using email right now. and maybe in future bank have the requirement to
 * send otp using sms or whatsapp. at that moment we again have to modify the 'sendOtp' method, which is not a good practice.
 * that would increase complexity, and also it would be hard to maintain the code.
 * all its break the responsiblity of single responsibility principle.
 *
 * So, we could distribute the task to different classes. like 'DepositService', 'WithdrawService', 'LoanService', 'OtpService' etc.
 * which will be easy to maintain, debug and would follow the single responsibility principle.
 */
public class BankService {

    public void deposit(long amount, String accountNo) {
        //deposit amount
        return;
    }

    public long withDraw(long amount, String accountNo) {
        //withdraw amount
        return 0;
    }

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
    }

    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            // business logic
        }
    }

}
