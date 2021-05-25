package GymSystem.BoundaryClass.Trainer;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * class used in Trainer's manage schedule page
 * <p>class used in Trainer's manage schedule page, trainer can add and delete schedule of live sessions here
 * </p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.1
 */
public class TrainerScheduleController {
    public JumpTo jump = new JumpTo();
    public Label signOut;
    public ImageView ToTrainerClass;
    public DatePicker date;
    public ChoiceBox timePeriod;
    public Button add;
    public Button cancel;
    public Button apply;
    public TextArea originalAdd;
    public TextArea presentAdd;
    public Label message;
    public ListView<String> originalDelete;
    public ListView<String> toBeDeleted;
    public ObservableList<String> originalScheDelete = FXCollections.observableArrayList();
    public ObservableList<String> toBeDeletedSche = FXCollections.observableArrayList();
    public Button delete;
    public Button cancelDelete;
    public Button applyDelete;
    public Label home;
    public Label video;
    public Label live;
    ArrayList<String> originalSche = new ArrayList<String>();
    ArrayList<String> addedSche = new ArrayList<String>();
    ArrayList<String> presentSche = new ArrayList<String>();

    /**
     * <p>initialize the page</p>
     * <p>set the options in {@code choiceBox} and call {@link #showOriginalSchedule()} to show original schedule
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @FXML
    public void initialize() throws IOException {
        date.setValue(LocalDate.now());
        timePeriod.setItems(FXCollections.observableArrayList(
                "08:00-09:00",
                "09:00-10:00",
                "10:00-11:00",
                "11:00-12:00",
                "12:00-13:00",
                "13:00-14:00",
                "14:00-15:00",
                "15:00-16:00",
                "16:00-17:00",
                "19:00-20:00",
                "20:00-21:00",
                "21:00-22:00"
        ));
        originalDelete.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        showOriginalSchedule();
    }

    /**
     * <p>add Schedule</p>
     * <p>add the selected schedule for trainer to deliver live sessions
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void addSchedule() {
        String addedTime = date.getValue().toString() + " " + (String) timePeriod.getValue() +" Unbooked";
        if (!presentSche.contains(addedTime)&&!addedSche.contains(addedTime)){
            addedSche.add(addedTime);
            presentSche.add(addedTime+" (new)");
            showPresentSchedule();
        } else {
            message.setText("Time period repeated!");
        }

    }

    /**
     * <p>delete schedule</p>
     * <p>delete the selected schedule
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void deleteSchedule() {
        toBeDeletedSche.addAll(originalDelete.getSelectionModel().getSelectedItems());
        originalDelete.getItems().removeAll(originalDelete.getSelectionModel().getSelectedItems());
        toBeDeleted.setItems(toBeDeletedSche);
    }

    /**
     * <p>cancel schedule</p>
     * <p>cancel the added schedule, before applying the changes.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void cancelDelete() throws IOException {
        toBeDeletedSche.clear();
        showOriginalSchedule();
    }

    /**
     * <p>apply the delete operation of schedule</p>
     * <p>apply the delete operation of schedule and call {@link GymSystem#changeInfo(String, String, String, String)} to
     * delete the information in the schedule.txt file.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void applyDelete() throws IOException {
        for (String s: toBeDeletedSche) {
            String deleteItem = s.split(" ")[1] + '/' + s.split(" ")[2];
            GymSystem.changeInfo(deleteItem,"schedule","delete","none");
        }
        showOriginalSchedule();
        toBeDeletedSche.clear();
    }

    /**
     * <p>show original schedule</p>
     * <p>call {@link GymSystemCheck#checkSchedule(String)} method in {@code GymSystemChech} class to get the original
     * schedule of the trainer.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void showOriginalSchedule() throws IOException{
        originalSche = GymSystemCheck.checkSchedule(GymSystemCheck.accountNumber);
        presentSche = GymSystemCheck.checkSchedule(GymSystemCheck.accountNumber);
        originalAdd.setText("");
        presentAdd.setText("");
        originalDelete.getItems().clear();
        for (int i = 0; i<originalSche.size();i++){
            originalAdd.appendText(i+1 + ": "+ originalSche.get(i)+"\n");
            presentAdd.appendText(i+1 + ": "+ originalSche.get(i)+"\n");
            originalScheDelete.add(i+1 + ": "+originalSche.get(i));
        }
        originalDelete.setItems(originalScheDelete);
    }

    /**
     * <p>show present schedule</p>
     * <p>show the added schedule in the {@code TextArea}
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void showPresentSchedule(){
        presentAdd.setText("");
        GymSystemCheck.sortSchedule(presentSche);
        for (int i = 0; i<presentSche.size();i++){
            presentAdd.appendText(i+1 + ": "+ presentSche.get(i)+"\n");
        }
    }

    /**
     * <p>cancel present schedule</p>
     * <p>cancel the added schedule
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void cancelPresentSchedule() throws IOException {
        presentAdd.setText("");
        for (int i = 0; i<originalSche.size();i++){
            presentAdd.appendText(i+1 + ": "+ originalSche.get(i)+"\n");
        }
        presentSche = GymSystemCheck.checkSchedule(GymSystemCheck.accountNumber);
        addedSche.clear();
    }

    /**
     * <p>apply the changes of schedule</p>
     * <p>apply the changes of schedule and call {@link GymSystem#changeInfo(String, String, String, String)} to write
     * the information into the schedule.txt file.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void applySchedule() throws IOException {
        for (int i = 0; i<addedSche.size();i++){
            String date = addedSche.get(i).split(" ")[0];
            String timePeriod = addedSche.get(i).split(" ")[1];
            GymSystem.addSchedule(date,timePeriod);
        }
        showOriginalSchedule();
        addedSche.clear();
    }

    /**
     * <p>jump to home page</p>
     * <p>Call {@link JumpTo#toMain(Scene)} method in {@code JumptTo} class to jump to home page, and sign out.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void signOut()throws IOException {
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(signOut.getScene());
    }

    /**
     * <p>jump to trainer's manage class page</p>
     * <p>Call {@link JumpTo#toTrainerClass(Scene)} method in {@code JumptTo} class to jump to trainer's manage class page.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toTrainerClass() throws IOException{
        jump.toTrainerClass(signOut.getScene());
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

}
