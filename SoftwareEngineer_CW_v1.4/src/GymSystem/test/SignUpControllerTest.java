package GymSystem.test;

import GymSystem.BoundaryClass.SignUp.SignUpController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignUpControllerTest {
    SignUpController test = new SignUpController();
    @Test
    void selectSexMan() {
        test.isWoman=true;
        assertEquals(false,test.isMan);
    }
}