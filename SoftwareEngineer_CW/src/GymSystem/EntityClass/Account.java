package GymSystem.EntityClass;

/**
 * <p>account</p>
 * <p>class for account
 * </p>
 * @author Yongfan Jin
 * @version 1.0
 */
public abstract class Account {
    private int accountNum;
    private String password;
    private String username;
    private boolean isManager=false;
    private boolean isMember=false;
    private boolean isTrainer=false;
    private boolean isSuspend=false;
    private void changePswd(){}
    private void changeType(){}
}
