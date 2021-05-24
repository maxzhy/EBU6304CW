package GymSystem.BoundaryClass.LogIn;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.io.IOException;

/**
 * Class of log in page
 * <p>Class for main page, including......</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.0
 */
public class LogInController {
    public JumpTo jump = new JumpTo();
    public TextField accountNum;
    public PasswordField password;
    public Button logInButton;
    public Label messageBoard;
    public Label signUp;
    public ImageView backToMain;

    /**
     * <p>Jump to sign up page</p>
     * <p>By changing the scene configuration to change the page
     * </p>
     * @author Yongfan Jin
     * @throws Exception
     * @version 1.0
     */
    public void jumpToSignUp() throws Exception {
        jump.toSignUp(signUp.getScene());
    }

    /**
     * <p>Back to main page</p>
     * <p>By changing the scene configuration to change the page, through calling
     * {@code toMain()} method in {@code jump}class {@link JumpTo#toMain(Scene)}
     * </p>
     * @author Yongfan Jin
     * @throws Exception
     * @version 1.1
     */
    public void backToMain() throws Exception {
        jump.toMain(signUp.getScene());
    }

    /**
     * <p>Log in function</p>
     * <p>Two steps of log in: 1. Get the account number and password users
     * typed in. 2. Call {@code logIn()} method in {@link GymSystem} class {@link GymSystem#logIn(String, String)}
     * to decide whether user can log in successfully. If can, call {@code checkAccountInfo()} method in
     * {@code GymSystemCheck} class {@link GymSystemCheck#checkAccountInfo(String, String)} to get user's
     * username and sexual, and show a welcome sentence. If not, prompt that the account number
     * or password is wrong.
     * </p>
     * @author Yongfan Jin
     * @throws IOException
     * @version 1.0
     */
    public void logIn() throws IOException {
        String accountNumInput = accountNum.getText();
        String passwordInput = password.getText();
        accountNum.setText("");
        password.setText("");
        boolean isSuccess = GymSystem.logIn(accountNumInput, passwordInput);
        if (isSuccess) {
            String username = GymSystemCheck.checkAccountInfo(accountNumInput, "username");
            String sexual = GymSystemCheck.checkAccountInfo(accountNumInput, "sexual");
            String type = GymSystemCheck.checkAccountInfo(accountNumInput,"type");
            messageBoard.setText("Welcome, " + sexual + " " + username + "!");
            GymSystemCheck.setAccountNumber(accountNumInput);
            switch (type) {
                case "admin"  : jump.toManagerMain(logInButton.getScene()); break;
                case "trainer": jump.toTrainerMain(logInButton.getScene()); break;
                case "member" :
                case "premier" :
                case "platinum" :jump.toMemberMain(logInButton.getScene()); break;
                default : break;
            }
        } else {
            messageBoard.setText("Incorrect account number or\npassword!");
        }
    }


}
