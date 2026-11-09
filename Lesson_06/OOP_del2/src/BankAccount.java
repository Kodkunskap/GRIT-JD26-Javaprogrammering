public class BankAccount {

    private double saldo = 0;
    private String name;

    BankAccount(String accountOwner) {
        name = accountOwner;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getAccountOwner() {
        return name;
    }

    /*
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    */

    public void deposit(double amount) {
        if (amount > 0){
            saldo += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= saldo) {
            saldo -= amount;
            return true;
        }
        return false;
    }

    public void info() {
        String className = this.getClass().getName();
        System.out.printf("%s: [owner: %s, saldo: %.2f kr]\n", className, name, saldo);
    }

}
