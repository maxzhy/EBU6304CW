package GymSystem.BoundaryClass.SignUp;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Class for sign up page
 * <p>Class for sign up page, including ......</p>
 * @author
 * @date 2021-04-07
 * @since 1.0
 * @version 1.0
 */
public class SignUpController {
    public JumpTo jump = new JumpTo();
    public ImageView backToLogIn;
    public RadioButton man;
    public RadioButton woman;
    public boolean isMan;
    public boolean isWoman;
    public TextField accountNum;
    public PasswordField password;
    public TextField username;
    public TextField phoneNum;
    public Label messageBoard;
    public Button signUpButton;
    public Label accIcon;
    public Label pswIcon;
    public Label usnmIcon;
    public Label phnmIcon;
    public Label sexIcon;

    /**
     * <p>Sign up method</p>
     * <p>Three steps for sign up: 1.Check if all information: including account number, password,
     *      username, phone number, and sexual are all correct. 2.If all correct,call {@code addAccountInfo()}
     *      method in {@code GymSystem} class {@link GymSystem#addAccountInfo(String, String, String, String, String)}
     *      to add account information into accounts.txt. 3. Call {@code initialize()}{@link #initialize()} method to
     *      initialize components.
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date  2021-04-07
     * @version 1.0
     */
    public void signUp() throws IOException {
        boolean accLegal = accIcon.getText().equals("√");
        boolean pswLegal = pswIcon.getText().equals("√");
        boolean usnmLegal = usnmIcon.getText().equals("√");
        boolean phnmLegal = phnmIcon.getText().equals("√");
        boolean sexLegal = isMan || isWoman;
        boolean allLegal = accLegal && pswLegal && usnmLegal && phnmLegal && sexLegal;

        if (!allLegal) {
            messageBoard.setText("Please fill in the information correctly.");
            return;
        }

        String actNum = accountNum.getText();
        String psw = password.getText();
        String usName = username.getText();
        String phNum = phoneNum.getText();
        String sexual = isMan ? "man" : "woman";

        GymSystem.addAccountInfo(actNum, psw, usName, phNum, sexual);
        initialize();
        messageBoard.setText("Sign up successfully!");
    }

    /**
     * <p>Check if account number user typed in is legal</p>
     * <p> By calling {@code checkAccountNum()} method in {@code GymSystemCheck} class
     *      {@link GymSystemCheck#checkAccountNum(String)} to decide whether
     *      it is legal, if so, call {@code checkAccountInfo()} in {@code GymSystemCheck}
     *      class {@link GymSystemCheck#checkAccountInfo(String, String)} to decide
     *      if the account number is repeated, if also no, show a green "√". If any one
     *      of the conditions is not satisfied, show a red "X"
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void checkAndShowAccNum() throws IOException{
        String acc = accountNum.getText();
        boolean isLegal;
        messageBoard.setText("");
        isLegal = GymSystemCheck.checkAccountNum(acc);
        if (isLegal) {
            if (GymSystemCheck.checkAccountInfo(acc,"accountNum").equals("no")) {
                accIcon.setText("√");
                accIcon.setTextFill(Color.rgb(0, 255, 0));
            } else {
                accIcon.setText("X");
                accIcon.setTextFill(Color.rgb(255, 0, 0));
                messageBoard.setText("Account number is repeated.");
            }
        } else {
            accIcon.setText("X");
            accIcon.setTextFill(Color.rgb(255, 0, 0));
        }
    }

    /**
     * <p>Check if password user typed in is legal</p>
     * <p> By calling {@code checkPassword()} method in {@code GymSystemCheck} class
     *      {@link GymSystemCheck#checkPassword(String)} to decide whether
     *      it is legal, if so, show a green "√", if not, show a red "X"
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void checkAndShowPsw() {
        String psw = password.getText();
        boolean isLegal;
        isLegal = GymSystemCheck.checkPassword(psw);
        if (isLegal) {
            pswIcon.setText("√");
            pswIcon.setTextFill(Color.rgb(0, 255, 0));
        } else {
            pswIcon.setText("X");
            pswIcon.setTextFill(Color.rgb(255, 0, 0));
        }
    }

    /**
     * <p>Check if username user typed in is legal</p>
     * <p> By calling {@code checkUsername()} method in {@code GymSystemCheck} class
     *      {@link GymSystemCheck#checkUsername(String)} to decide whether
     *      it is legal, if so, show a green "√", if not, show a red "X"
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void checkAndShowUsnm() {
        String usnm = username.getText();
        boolean isLegal;
        isLegal = GymSystemCheck.checkUsername(usnm);
        if (isLegal) {
            usnmIcon.setText("√");
            usnmIcon.setTextFill(Color.rgb(0, 255, 0));
        } else {
            usnmIcon.setText("X");
            usnmIcon.setTextFill(Color.rgb(255, 0, 0));
        }
    }

    /**
     * <p>Check if phone number user typed in is legal</p>
     * <p> By calling {@code checkPhoneNum()} method in {@code GymSystemCheck} class
     *      {@link GymSystemCheck#checkPhoneNum(String)} to decide whether
     *      it is legal, if so, show a green "√", if not, show a red "X"
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void checkAndShowPhnm() {
        String phnm = phoneNum.getText();
        boolean isLegal;
        isLegal = GymSystemCheck.checkPhoneNum(phnm);
        if (isLegal) {
            phnmIcon.setText("√");
            phnmIcon.setTextFill(Color.rgb(0, 255, 0));
        } else {
            phnmIcon.setText("X");
            phnmIcon.setTextFill(Color.rgb(255, 0, 0));
        }
    }

    /**
     * <p>Method for RadioButton "man" of choice of sexual</p>
     * <p>Ensure that user only choose one of the two choices:
     *      man or woman. They can't neither choose both nor choose nothing.
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void selectSexMan() {
        if (isMan) {
            man.setSelected(true);
            return;
        }
        if (isWoman) {
            man.setSelected(!isMan);
            woman.setSelected(!isWoman);
        }
        isMan = man.isSelected();
        isWoman = woman.isSelected();
        sexIcon.setText("√");
        sexIcon.setTextFill(Color.rgb(0, 255, 0));
    }

    /**
     * <p>Method for RadioButton "woman" of choice of sexual</p>
     * <p>Ensure that user only choose one of the two choices:
     * man or woman. They can't neither choose both nor choose nothing.
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void selectSexWoman() {
        if (isWoman) {
            woman.setSelected(true);
            return;
        }
        if (isMan) {
            man.setSelected(!isMan);
            woman.setSelected(!isWoman);
        }
        isMan = man.isSelected();
        isWoman = woman.isSelected();
        sexIcon.setText("√");
        sexIcon.setTextFill(Color.rgb(0, 255, 0));
    }

    /**
     * <p>Method for initialize the sign up page</p>
     * <p>Initialize the components in sign up page.
     *
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2020-04-07
     * @version 1.0
     */
    public void initialize() {
        accountNum.setText("");
        password.setText("");
        username.setText("");
        phoneNum.setText("");
        man.setSelected(false);
        woman.setSelected(false);
        accIcon.setText("*");
        accIcon.setTextFill(Color.rgb(255, 0, 0));
        pswIcon.setText("*");
        pswIcon.setTextFill(Color.rgb(255, 0, 0));
        usnmIcon.setText("*");
        usnmIcon.setTextFill(Color.rgb(255, 0, 0));
        phnmIcon.setText("*");
        phnmIcon.setTextFill(Color.rgb(255, 0, 0));
        sexIcon.setText("*");
        sexIcon.setTextFill(Color.rgb(255, 0, 0));
    }

    /**
     * <p>Back to log in page</p>
     * <p>By changing the scene configuration to change the page
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void backToLogIn() throws Exception {
        jump.toLogIn(man.getScene());
    }

}
