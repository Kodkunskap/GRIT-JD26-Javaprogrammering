public class SavingsBankAccount extends BankAccount {

    private double interestRate;
    public static final double WITHDRAWAL_FEE = 5;

    public SavingsBankAccount(String accountOwner, double interestRate) {
        super(accountOwner);
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + WITHDRAWAL_FEE);
    }

    public void addInterest() {
        deposit(getSaldo()*interestRate);
    }

}
