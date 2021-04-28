package GymSystem.BoundaryClass.Member;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    public Button upToPremier;
    public Button upToPlatinum;
    public Label message;

    public void upgradeToPremier() throws IOException{
        String currentType = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"type");
        if (currentType.equals("member")){
            GymSystem.changeInfo(currentType,"membership","change","premier");
        } else {
            message.setText("You have already been Premier Member!");
        }
    }

    public void upgradeToPlatinum() throws IOException{
        String currentType = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"type");
        if (currentType.equals("member")||currentType.equals("premier")){
            GymSystem.changeInfo(currentType,"membership","change","platinum");
        } else {
            message.setText("You have already been Platinum Member!");
        }
    }

    public void backToMemberMain()throws IOException {
        jump.toMemberMain(username.getScene());
    }

    public void signOut()throws IOException{
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(username.getScene());
    }
}
