package GymSystem.BoundaryClass.Trainer;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
    ArrayList<String> originalSche = new ArrayList<String>();
    ArrayList<String> addedSche = new ArrayList<String>();
    ArrayList<String> presentSche = new ArrayList<String>();
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

    public void addSchedule() {
        String addedTime = date.getValue().toString() + " " + (String) timePeriod.getValue();
        if (!presentSche.contains(addedTime)){
            addedSche.add(addedTime);
            presentSche.add(addedTime+" (new)");
            showPresentSchedule();
        } else {
            message.setText("Time period repeated!");
        }

    }

    public void deleteSchedule() {
        toBeDeletedSche.addAll(originalDelete.getSelectionModel().getSelectedItems());
        originalDelete.getItems().removeAll(originalDelete.getSelectionModel().getSelectedItems());
        toBeDeleted.setItems(toBeDeletedSche);
    }

    public void cancelDelete() throws IOException {
        toBeDeletedSche.clear();
        showOriginalSchedule();
    }

    public void applyDelete() throws IOException {
        for (String s: toBeDeletedSche) {
            String deleteItem = s.split(" ")[1] + '/' + s.split(" ")[2];
            GymSystem.changeInfo(deleteItem,"schedule","delete");
        }
        showOriginalSchedule();
        toBeDeletedSche.clear();
    }

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

    public void showPresentSchedule(){
        presentAdd.setText("");
        GymSystemCheck.sortSchedule(presentSche);
        for (int i = 0; i<presentSche.size();i++){
            presentAdd.appendText(i+1 + ": "+ presentSche.get(i)+"\n");
        }
    }

    public void cancelPresentSchedule() throws IOException {
        presentAdd.setText("");
        for (int i = 0; i<originalSche.size();i++){
            presentAdd.appendText(i+1 + ": "+ originalSche.get(i)+"\n");
        }
        presentSche = GymSystemCheck.checkSchedule(GymSystemCheck.accountNumber);
        addedSche.clear();
    }

    public void applySchedule() throws IOException {
        for (int i = 0; i<addedSche.size();i++){
            String date = addedSche.get(i).split(" ")[0];
            String timePeriod = addedSche.get(i).split(" ")[1];
            GymSystem.addSchedule(date,timePeriod);
        }
        showOriginalSchedule();
        addedSche.clear();
    }

    public void signOut()throws IOException {
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(signOut.getScene());
    }

    public void toTrainerClass() throws IOException{
        jump.toTrainerClass(signOut.getScene());
    }


}
