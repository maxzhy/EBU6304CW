package GymSystem.BoundaryClass.Member;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class used in member's live page
 * <p>class used in member's live page, user can book live session here, including booking and sending requests to certain
 * trainer</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.0
 */
public class MemberLiveController {
    public JumpTo jump = new JumpTo();
    public Label username;
    public Label signOut;
    public Label home;
    public Label live;
    public Label video;
    public ImageView backToMemberMain;
    public Button book;
    public Button cancel;
    public Button submit;
    public Label messageBook;
    public Label messageCancel;
    public Label messageTarget;
    public Label messageAbility1;
    public Label messageAbility2;
    public Label messageRequest;
    public TextArea target;
    public TextArea ability;
    public boolean isNormal = true;
    public TableView<scheduleInfo> schedules;
    public TableColumn<String, scheduleInfo> trainerNameCol;
    public TableColumn<String, scheduleInfo> timeCol;
    public TableColumn<String, scheduleInfo> appointmentCol;
    public ObservableList<scheduleInfo> scheduleItems = FXCollections.observableArrayList();
    public ArrayList<String> originalSchedule;

    /**
     * <p>initialize</p>
     * <p>call {@link #getSchedules()} to get live session information and show them in {@code TableView}.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @FXML
    public void initialize()throws IOException{
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
        String typeOfUser = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"type");
        isNormal = typeOfUser.equals("member");
        if (isNormal){
            schedules.setDisable(true);
            book.setDisable(true);
            cancel.setDisable(true);
            messageTarget.setDisable(true);
            messageAbility1.setDisable(true);
            messageAbility2.setDisable(true);
            target.setDisable(true);
            ability.setDisable(true);
        } else {
            getSchedules();
            messageRequest.setText("click to submit your\ninformation to the trainer\nyou like");
        }
    }

    /**
     * <p>submit request</p>
     * <p>check the legality of requests, if legal, call {@link GymSystem#addRequest(String, String, String, String)}
     * to send the information to certain trainer
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void submitRequest() throws IOException{
        if (schedules.getSelectionModel().getSelectedItems().isEmpty()){
            messageRequest.setText("Please select a trainer by\nselecting a live session");
            return;
        }
        scheduleInfo selected = schedules.getSelectionModel().getSelectedItems().get(0);
        String trainerAccount = selected.getTrainerAcc();
        if(target.getText().isEmpty() || ability.getText().isEmpty()){
            messageRequest.setText("Please type in your request.");
            return;
        }
        GymSystem.addRequest(trainerAccount,GymSystemCheck.accountNumber,target.getText(),ability.getText());
        messageRequest.setText("Request submitted");

    }

    /**
     * <p>book live session</p>
     * <p> book the selected live session, user can only book live sessions that are not booked by others and are not
     * booked by himself
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
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

    /**
     * <p>cancel book</p>
     * <p>cancel the booked live session, user can only cancel live sessions that are booked by himself
     * </p>
     * @param
     * @return
     * @author
     * @version
     */
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

    /**
     * <p>get the schedule information</p>
     * <p>call {@link GymSystemCheck#checkAllSchedules()} method in {@code GymSystemCheck} class to get the schedule
     * information, and show them in the {@code TableView}.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
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

    /**
     * <p>jump to member's main page</p>
     * <p>Call {@link JumpTo#toMemberMain(Scene)} method in {@code JumptTo} class to jump to member's main page
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void backToMemberMain()throws IOException {
        jump.toMemberMain(username.getScene());
    }

    /**
     * <p>jump to member's live page</p>
     * <p>Call {@link JumpTo#toMemberLive(Scene)} method in {@code JumptTo} class to jump to member's live page
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toMemberLive() throws IOException{
        jump.toMemberLive(username.getScene());
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
     * class used to store schedule information
     * <p>class used to store schedule information, including trainer's name, time of live session, appointment state
     * trainer's account</p>
     * @author Yongfan Jin
     * @since 1.0
     * @version 1.0
     */
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
