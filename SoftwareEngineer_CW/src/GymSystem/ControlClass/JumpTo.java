package GymSystem.ControlClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * class for jump between pages
 * <p>this class have methods that can load the new scenes to realize the jump between different pages</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 4.0
 */
public class JumpTo {

    /**
     * <p>jump to main page</p>
     * <p>jump to main page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toMain(Scene presentScene)throws IOException {
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../MainGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to login page</p>
     * <p>jump to login page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toLogIn(Scene presentScene)throws IOException {
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/LogIn/LogInGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to sign up page</p>
     * <p>jump to sign up page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toSignUp(Scene presentScene)throws IOException {
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/SignUp/SignUpGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to manager's main page</p>
     * <p>jump to manager's main page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toManagerMain(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Manager/ManagerMainGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to member's main page</p>
     * <p>jump to member's main page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toMemberMain(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Member/MemberMainGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to member's upgrade page</p>
     * <p>jump to member's upgrade page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toUpgrade(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Member/MemberUpgradeGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    //Ma Zhaoyang
    public void toUploadVideo(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Trainer/TrainerUploadVideoGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to trainer's main page</p>
     * <p>jump to trainer's main page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toTrainerMain(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Trainer/TrainerMainGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to trainer's class page</p>
     * <p>jump to trainer's class page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toTrainerClass(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Trainer/TrainerClassGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to trainer's schedule page</p>
     * <p>jump to trainer's schedule page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toTrainerSchedule(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Trainer/TrainerScheduleGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to member's information page</p>
     * <p>jump to member's information page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toMemberInformation(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Member/MemberInformationGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to member's live page</p>
     * <p>jump to member's live page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toMemberLive(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Member/MemberLiveGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to manager's fund manage page</p>
     * <p>jump to manager's fund manage page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toManagerFund(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Manager/ManagerFundGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    /**
     * <p>jump to manager's account manage page</p>
     * <p>jump to manager's account manage page
     * </p>
     * @param presentScene Scene the present scene
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toManagerAccount(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Manager/ManagerAccountGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }
}
