package GymSystem.BoundaryClass.LogIn;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.IOException;

/**
 * Class of log in page
 * <p>Class for main page, including......</p>
 * @author
 * @date 2021-04-07
 * @since 1.0
 * @version 1.0
 */
public class LogInController {
    public GymSystem sys = new GymSystem();
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
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void jumpToSignUp() throws Exception {
        Scene scene = signUp.getScene();
        Stage stage = (Stage) scene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../SignUp/SignUpGUI.fxml"));
        scene.setRoot(newPage);
        stage.setScene(scene);
    }

    /**
     * <p>Back to main page</p>
     * <p>By changing the scene configuration to change the page
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void backToMain() throws Exception {
        Scene scene = signUp.getScene();
        Stage stage = (Stage) scene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../../MainGUI.fxml"));
        scene.setRoot(newPage);
        stage.setScene(scene);
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
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void logIn() throws IOException {
        String accountNumInput = accountNum.getText();
        String passwordInput = password.getText();
        accountNum.setText("");
        password.setText("");
        boolean isSuccess = sys.logIn(accountNumInput, passwordInput);
        if (isSuccess) {
            String username = GymSystemCheck.checkAccountInfo(accountNumInput, "username");
            String sexual = GymSystemCheck.checkAccountInfo(accountNumInput, "sexual");
            messageBoard.setText("Welcome, " + sexual + " " + username + "!");
        } else {
            messageBoard.setText("Incorrect account number or\npassword!");
        }
    }


}
