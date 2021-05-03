package GymSystem.BoundaryClass.Member;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class MemberLiveController {
    public JumpTo jump = new JumpTo();
    public Label username;
    public Label signOut;
    public ImageView backToMemberMain;
    public Button book;
    public Button cancel;
    public Label messageBook;
    public Label messageCancel;
    public boolean isNormal = true;
    public TableView<scheduleInfo> schedules;
    public TableColumn<String, scheduleInfo> trainerNameCol;
    public TableColumn<String, scheduleInfo> timeCol;
    public TableColumn<String, scheduleInfo> appointmentCol;
    public ObservableList<scheduleInfo> scheduleItems = FXCollections.observableArrayList();
    public ArrayList<String> originalSchedule;
    @FXML
    public void initialize()throws IOException{
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
        String typeOfUser = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"type");
        isNormal = typeOfUser.equals("member");
        if (isNormal){
            schedules.setDisable(true);
            book.setDisable(true);
            cancel.setDisable(true);
        } else {
            getSchedules();
        }
    }

    public void bookLiveSession() throws IOException{
        messageBook.setText("");
        messageCancel.setText("");
        if (schedules.getSelectionModel().getSelectedItems().isEmpty()){
            return;
        }
        scheduleInfo selected = schedules.getSelectionModel().getSelectedItems().get(0);
        String trainerAccount = selected.getTrainerAcc();
        String date = selected.getTime().split(" ")[0];
        String time = selected.getTime().split(" ")[1];
        String isBooked = selected.getAppointment();
        if (isBooked.equals("Booked by you")){
            messageBook.setText("You've booked this\nsession.");
            return;
        }
        if (isBooked.equals("Booked by others")) {
            messageBook.setText("This session has\nbeen booked already.");
            return;
        }
        GymSystem.operateLiveSession(trainerAccount,date,time,GymSystemCheck.accountNumber,"book");
        messageBook.setText("Live session booked.");
        getSchedules();
    }

    public void cancelBook() throws IOException{
        messageBook.setText("");
        messageCancel.setText("");
        if (schedules.getSelectionModel().getSelectedItems().isEmpty()){
            return;
        }
        scheduleInfo selected = schedules.getSelectionModel().getSelectedItems().get(0);
        String trainerAccount = selected.getTrainerAcc();
        String date = selected.getTime().split(" ")[0];
        String time = selected.getTime().split(" ")[1];
        String isBooked = selected.getAppointment();
        if (isBooked.equals("Booked by others")){
            messageCancel.setText("You can't cancel\nothers' appointment.");
            return;
        }
        if (isBooked.equals("Unbooked ")) {
            messageCancel.setText("You can't cancel\nunbooked session.");
            return;
        }
        GymSystem.operateLiveSession(trainerAccount,date,time,GymSystemCheck.accountNumber,"cancel");
        messageCancel.setText("Successfully canceled.");
        getSchedules();
    }

    public void getSchedules() throws IOException{
        originalSchedule = GymSystemCheck.checkAllSchedules();
        scheduleItems.clear();
        for (int i=0; i<originalSchedule.size();i++){
            String trainerAcc;
            String time;
            String isBooked;
            String bookedBy = "";
            trainerAcc =  originalSchedule.get(i).split(" ")[0];
            time = originalSchedule.get(i).split(" ")[1] + " " +originalSchedule.get(i).split(" ")[2];
            isBooked = originalSchedule.get(i).split(" ")[3];
            if (isBooked.equals("Booked")) {
                if (originalSchedule.get(i).split(" ")[5].equals(GymSystemCheck.accountNumber)){
                    bookedBy = "by you";
                } else {
                    bookedBy = "by others";
                }
            }
            scheduleItems.add(new scheduleInfo(trainerAcc, time, isBooked + " " + bookedBy));
        }
        trainerNameCol.setCellValueFactory(new PropertyValueFactory<>("trainerName"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        appointmentCol.setCellValueFactory(new PropertyValueFactory<>("appointment"));
        schedules.setItems(scheduleItems);
    }

    public void backToMemberMain()throws IOException {
        jump.toMemberMain(username.getScene());
    }

    public void signOut()throws IOException{
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(username.getScene());
    }

    public static class scheduleInfo {
        private final SimpleStringProperty trainerNameProperty = new SimpleStringProperty();
        private final SimpleStringProperty timeProperty = new SimpleStringProperty();
        private final SimpleStringProperty appointmentProperty = new SimpleStringProperty();
        private final SimpleStringProperty trainerAccProperty = new SimpleStringProperty();

        private scheduleInfo(String trainerAcc,String time,String appointment) throws IOException {
            trainerNameProperty.set(GymSystemCheck.checkAccountInfo(trainerAcc,"username"));
            timeProperty.set(time);
            appointmentProperty.set(appointment);
            trainerAccProperty.set(trainerAcc);
        }

        public void setTrainerName(String name){
            trainerNameProperty.set(name);
        }

        public String getTrainerName(){
            return trainerNameProperty.get();
        }

        public void setTime(String time){
            timeProperty.set(time);
        }

        public String getTime(){
            return timeProperty.get();
        }

        public void setAppointment(String appointment){
            appointmentProperty.set(appointment);
        }

        public String getAppointment(){
            return appointmentProperty.get();
        }

        public void setTrainerAcc(String trainerAcc){
            trainerAccProperty.set(trainerAcc);
        }

        public String getTrainerAcc(){
            return trainerAccProperty.get();
        }
    }
}
