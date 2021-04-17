package GymSystem.BoundaryClass.Trainer;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TrainerClassController {
    @FXML
    public void initialize()throws IOException {
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
    }
    public JumpTo jump = new JumpTo();
    public Label username;
    public Label signOut;
    public Label toTrainerSchedule;
    public ImageView backToTrainerMain;

    public void signOut()throws IOException{
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(username.getScene());
    }

    public void toTrainerMain() throws IOException{
        jump.toTrainerMain(signOut.getScene());
    }

    public void toTrainerSchedule() throws IOException{
        jump.toTrainerSchedule(signOut.getScene());
    }
}
