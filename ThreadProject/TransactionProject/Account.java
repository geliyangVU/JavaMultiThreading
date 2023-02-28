package ThreadProject.TransactionProject;

public class Account {

    private int accountMoneyAmount;

    public Account(int amount) {
        this.accountMoneyAmount = amount;
    }

    public int getMoney() {
        return accountMoneyAmount;
    }

    public void setMoney(int money) {
        this.accountMoneyAmount = money;
    }

    public void transfer(Account target, int amount) {
        synchronized (Account.class) {
            if (this.accountMoneyAmount >= amount) {
                this.setMoney(this.getMoney() - amount);
                target.setMoney(target.getMoney() + amount);
            }
        }

    }

}
