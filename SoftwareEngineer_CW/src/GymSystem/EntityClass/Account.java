package GymSystem.EntityClass;

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
