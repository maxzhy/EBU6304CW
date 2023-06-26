package GymSystem.EntityClass;

/**
 * class for income
 * <p>class for income</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.0
 */
public class Income {
    String account;
    String amount;
    String from;

    public Income(String account, String amount, String from) {
        this.account = account;
        this.amount = amount;
        this.from = from;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
