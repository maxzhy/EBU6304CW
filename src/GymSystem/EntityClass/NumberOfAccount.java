package GymSystem.EntityClass;

/**
 * contain the number of different kinds of members
 * <p>contain the number of different kinds of members, including normal member, premier member, platinum member and
 * trainer</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.0
 */
public class NumberOfAccount {
    private int numOfMember;
    private int numOfPremier;
    private int numOfPlatinum;
    private int numOfTrainer;

    public NumberOfAccount() {
        setNumOfMember(0);
        setNumOfPlatinum(0);
        setNumOfPremier(0);
        setNumOfTrainer(0);
    }

    public int getNumOfMember() {
        return numOfMember;
    }

    public void setNumOfMember(int numOfMember) {
        this.numOfMember = numOfMember;
    }

    public int getNumOfPremier() {
        return numOfPremier;
    }

    public void setNumOfPremier(int numOfPremier) {
        this.numOfPremier = numOfPremier;
    }

    public int getNumOfPlatinum() {
        return numOfPlatinum;
    }

    public void setNumOfPlatinum(int numOfPlatinum) {
        this.numOfPlatinum = numOfPlatinum;
    }

    public int getNumOfTrainer() {
        return numOfTrainer;
    }

    public void setNumOfTrainer(int numOfTrainer) {
        this.numOfTrainer = numOfTrainer;
    }
}
