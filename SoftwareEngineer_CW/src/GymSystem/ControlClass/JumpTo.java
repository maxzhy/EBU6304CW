package GymSystem.ControlClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JumpTo {

    public void toMain(Scene presentScene)throws IOException {
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../MainGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    public void toLogIn(Scene presentScene)throws IOException {
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/LogIn/LogInGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    public void toSignUp(Scene presentScene)throws IOException {
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/SignUp/SignUpGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    public void toManagerMain(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Manager/ManagerMainGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    public void toMemberMain(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Member/MemberMainGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

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

    public void toTrainerMain(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Trainer/TrainerMainGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    public void toTrainerClass(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Trainer/TrainerClassGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }

    public void toTrainerSchedule(Scene presentScene) throws IOException{
        Stage stage = (Stage) presentScene.getWindow();
        Parent newPage = FXMLLoader.load(getClass().getResource("../BoundaryClass/Trainer/TrainerScheduleGUI.fxml"));
        presentScene.setRoot(newPage);
        stage.setScene(presentScene);
    }
}
