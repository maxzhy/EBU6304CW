package GymSystem.BoundaryClass.Member;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MemberUpgradeController {
    @FXML
    public void initialize()throws IOException{
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
    }
    public JumpTo jump = new JumpTo();
    public Label username;
    public Label signOut;
    public ImageView backToMemberMain;


    public void backToMemberMain()throws IOException {
        jump.toMemberMain(username.getScene());
    }

    public void signOut()throws IOException{
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(username.getScene());
    }
}
