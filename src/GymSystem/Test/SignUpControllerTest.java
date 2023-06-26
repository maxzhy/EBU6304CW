package GymSystem.Test;

import GymSystem.BoundaryClass.SignUp.SignUpController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * test class for {@link SignUpController}
 * <p>test class for {@link SignUpController}</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.0
 */
class SignUpControllerTest {
    SignUpController test = new SignUpController();
    /**
     * <p>test {@link SignUpController#selectSexMan()}</p>
     * <p>test {@link SignUpController#selectSexMan()}
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @Test
    void selectSexMan() {
        test.isWoman=true;
        assertEquals(false,test.isMan);
    }
}