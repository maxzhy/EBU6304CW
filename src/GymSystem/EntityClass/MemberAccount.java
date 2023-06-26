package GymSystem.EntityClass;

/**
 * class for member account
 * <p>class for member account</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.0
 */
public class MemberAccount extends Account{
    private boolean isGeneral;
    private double balance;
    private void recharge(){}
    private void upgrade(){}

    public MemberAccount(String accNum, String username, String phoneNum, String sexual, String type, boolean isGeneral, double balance) {
        super(accNum, username, phoneNum, sexual, type);
        this.isGeneral = isGeneral;
        this.balance = balance;
    }
}
