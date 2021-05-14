package GymSystem.BoundaryClass.Trainer;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class TrainerClassController {
    @FXML
    public void initialize()throws IOException {
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
        showSchedule();
        showStudentInfo();
    }
    public JumpTo jump = new JumpTo();
    public Label username;
    public Label signOut;
    public Label toTrainerSchedule;
    public ImageView backToTrainerMain;
    public TextArea schedule;
    public TextArea studentInfo;

    public void showSchedule() throws IOException{
        ArrayList<String> originalSchedule = GymSystemCheck.checkSchedule(GymSystemCheck.accountNumber);
        for (int i = 0; i<originalSchedule.size();i++){
            schedule.appendText(i+1 + ": "+ originalSchedule.get(i)+"\n");
        }
    }

    public void showStudentInfo() throws IOException{
        ArrayList<String> studentInfoList = GymSystemCheck.checkRequest(GymSystemCheck.accountNumber);
        for (int i = 0; i<studentInfoList.size();i++){
            studentInfo.appendText(studentInfoList.get(i));
        }
    }

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
