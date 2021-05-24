package GymSystem.Test;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.EntityClass.NumberOfAccount;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class GymSystemCheckTest {
    @Test
    void checkIncome() throws IOException{
        System.out.println(GymSystemCheck.checkIncome());
    }
    @Test
    void checkNumberOfAcc() throws IOException{
        NumberOfAccount num = new NumberOfAccount();
        num = GymSystemCheck.checkNumberOfAcc();
        System.out.println(num.getNumOfMember());
        System.out.println(num.getNumOfPlatinum());
        System.out.println(num.getNumOfPremier());
        System.out.println(num.getNumOfTrainer());
    }

}