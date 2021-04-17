package GymSystem.BoundaryClass.Trainer;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import GymSystem.ControlClass.VideoSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;


//Ma Zhaoyang
public class TrainerUploadVideoController {
    public TextField title;
    public TextArea comment;
    public Button videoUploadButton;


    @FXML
    public void initialize()throws IOException{
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
    }
    public JumpTo jump = new JumpTo();
    public Label username;
    public Label signOut;
    public ImageView backToTrainerMain;


    public void backToTrainerMain()throws IOException {
        jump.toTrainerMain(username.getScene());
    }

    public void videoUpload() throws IOException {
        String titleInput = title.getText();
        String commentInput = comment.getText();

        VideoSystem.addVideoInfo(titleInput, commentInput);
    }


    //退出登录
    public void signOut()throws IOException{
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(username.getScene());
    }
}
