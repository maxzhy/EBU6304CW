package GymSystem.BoundaryClass.Trainer;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class TrainerScheduleController {
    public JumpTo jump = new JumpTo();
    public Label signOut;
    public ImageView ToTrainerClass;
    public DatePicker datePicker;



    public void signOut()throws IOException {
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(signOut.getScene());
    }

    public void toTrainerClass() throws IOException{
        jump.toTrainerClass(signOut.getScene());
    }
}
