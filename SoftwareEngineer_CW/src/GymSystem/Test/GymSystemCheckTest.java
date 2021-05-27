package GymSystem.Test;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.EntityClass.Account;
import GymSystem.EntityClass.NumberOfAccount;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * test class for {@link GymSystemCheck}
 * <p>test class for {@link GymSystemCheck}</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 2.0
 */
class GymSystemCheckTest {
    /**
     * <p>test {@link GymSystemCheck#checkIncome()}</p>
     * <p>test {@link GymSystemCheck#checkIncome()}
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @Test
    void checkIncome() throws IOException{
        System.out.println(GymSystemCheck.checkIncome());
    }

    /**
     * <p>test {@link GymSystemCheck#checkNumberOfAcc()}</p>
     * <p>test {@link GymSystemCheck#checkNumberOfAcc()}
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @Test
    void checkNumberOfAcc() throws IOException{
        NumberOfAccount num = new NumberOfAccount();
        num = GymSystemCheck.checkNumberOfAcc();
        System.out.println(num.getNumOfMember());
        System.out.println(num.getNumOfPlatinum());
        System.out.println(num.getNumOfPremier());
        System.out.println(num.getNumOfTrainer());
    }

    /**
     * <p>test {@link GymSystemCheck#checkAccounts()}</p>
     * <p>test {@link GymSystemCheck#checkAccounts()}
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @Test
    void checkAccounts() throws IOException {
        ArrayList<Account> accounts = GymSystemCheck.checkAccounts();
        System.out.println(accounts.get(0).getAccountNumProperty());
    }
}