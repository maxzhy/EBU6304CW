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

    public void upgradeToPremier() throws IOException{
        String currentType = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"type");
        if (currentType.equals("member")){
            GymSystem.changeInfo(currentType,"membership","change","premier");
        } else {
            System.out.println("You have already been premier member!\n");
        }
    }

    public void upgradeToPlatinum() throws IOException{
        String currentType = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"type");
        if (currentType.equals("member")||currentType.equals("premier")){
            GymSystem.changeInfo(currentType,"membership","change","platinum");
        } else {
            System.out.println("You have already been platinum member!\n");
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
