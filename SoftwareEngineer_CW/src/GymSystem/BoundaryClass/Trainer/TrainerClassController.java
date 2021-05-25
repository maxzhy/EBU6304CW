package GymSystem.BoundaryClass.Trainer;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class used in Trainer's manage class page
 * <p>class used in Trainer's manage class page, trainer can manage class information here, including his schedule information
 * and students' requests</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.2
 */
public class TrainerClassController {
    public JumpTo jump = new JumpTo();
    public Label username;
    public Label signOut;
    public Label toTrainerSchedule;
    public ImageView backToTrainerMain;
    public TextArea schedule;
    public TextArea studentInfo;
    public Label home;
    public Label video;
    public Label live;

    /**
     * <p>initialize the page</p>
     * <p>initialize the page, call {@link #showSchedule()} and {@link #showStudentInfo()} to show the schedule information
     * and students' requests.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @FXML
    public void initialize()throws IOException {
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
        showSchedule();
        showStudentInfo();
    }

    /**
     * <p>show schedule information</p>
     * <p>call {@link GymSystemCheck#checkSchedule(String)} method in {@code GymSystemCheck} class to get the schedule
     * information, and show them in the {@code TextArea}.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void showSchedule() throws IOException{
        ArrayList<String> originalSchedule = GymSystemCheck.checkSchedule(GymSystemCheck.accountNumber);
        for (int i = 0; i<originalSchedule.size();i++){
            schedule.appendText(i+1 + ": "+ originalSchedule.get(i)+"\n");
        }
    }

    /**
     * <p>show schedule information</p>
     * <p>call {@link GymSystemCheck#checkRequest(String)} method in {@code GymSystemCheck} class to get the request
     * information, and show them in the {@code TextArea}.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void showStudentInfo() throws IOException{
        ArrayList<String> studentInfoList = GymSystemCheck.checkRequest(GymSystemCheck.accountNumber);
        for (int i = 0; i<studentInfoList.size();i++){
            studentInfo.appendText(studentInfoList.get(i));
        }
    }

    /**
     * <p>jump to home page</p>
     * <p>Call {@link JumpTo#toMain(Scene)} method in {@code JumptTo} class to jump to home page, and sign out.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void signOut()throws IOException{
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(username.getScene());
    }

    /**
     * <p>jump to trainer's main page</p>
     * <p>Call {@link JumpTo#toTrainerMain(Scene)} method in {@code JumptTo} class to jump to trainer's main page.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toTrainerMain() throws IOException{
        jump.toTrainerMain(signOut.getScene());
    }

    /**
     * <p>jump to trainer's schedule page</p>
     * <p>Call {@link JumpTo#toTrainerSchedule(Scene)} method in {@code JumptTo} class to jump to trainer's schedule page.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toTrainerSchedule() throws IOException{
        jump.toTrainerSchedule(signOut.getScene());
    }

}
