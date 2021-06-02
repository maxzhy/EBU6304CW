package GymSystem.BoundaryClass.Member;

import GymSystem.ControlClass.VideoSystem;
import GymSystem.ControlClass.VideoSystemCheck;
import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class MemberWatchVideoController {
    @FXML
    public JumpTo jump = new JumpTo();
    public Label username;
    public Label home;
    public ChoiceBox videoType;

    public Label signOut;
    public ImageView toMemberMain;
    public ListView<String> videoList;
    ArrayList<String> originalVideo = new ArrayList<String>();

    public ObservableList<String> videoShow = FXCollections.observableArrayList();

    /**
     * <p>initialize the page</p>
     * <p>call {@code showVideos()} to show videos
     * </p>
     * @author Zhaoyang Ma
     * @version 2.0
     */
    public void initialize() throws IOException{
        videoList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        videoType.setItems(FXCollections.observableArrayList(
                "all",
                "yoga",
                "running",
                "movements",
                "others"
        ));
        showVideos();
    }

    /**
     * <p>Show videos on the list</p>
     * <p>call {@link GymSystemCheck#checkAccountInfo(String, String)} in {@code GymSystemCheck} to check account type
     * </p>
     * @author Zhaoyang Ma
     * @version 2.0
     */
    public void showVideos() throws IOException{
        videoList.getItems().clear();

        String type = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"type");
        originalVideo = VideoSystemCheck.checkVideos(type);
        videoList.getItems().clear();
        for (int i = 0; i<originalVideo.size();i++){
            videoShow.add(i+1 + ": "+originalVideo.get(i));
        }
        videoList.setItems(videoShow);
    }

    /**
     * <p>Show selected videos on the list</p>
     * <p>call {@link GymSystemCheck#checkAccountInfo(String, String)} in {@code GymSystemCheck} to get account type
     *    call {@link VideoSystemCheck#checkVideos(String)} in {@code VideoSystem} to show videos
     * </p>
     * @author Zhaoyang Ma
     * @version 2.0
     */
    public void showSelectedVideos() throws IOException {
        if (videoType.getValue() == null){
            return;
        }
        String typeInput = (String) videoType.getValue();
        if (typeInput == "all"){
            initialize();
        } else {
            String type = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber, "type");
            originalVideo = VideoSystemCheck.checkVideos(type);
            videoList.getItems().clear();

            for (int i = 0; i < originalVideo.size(); i++) {
                if (originalVideo.get(i).split("/")[1].equals(typeInput)) {
                    videoShow.add(i + 1 + ": " + originalVideo.get(i));
                }
            }
            videoList.setItems(videoShow);
        }
    }

    /**
     * <p>Play video</p>
     * <p>call {@link VideoSystem#openVideo(String)}in {@code VideoSystem} to play videos
     * </p>
     * @author Zhaoyang Ma
     * @version 2.0
     */
    public void playVideo() {
        for (String s: videoList.getSelectionModel().getSelectedItems()) {
            String oneLine = s.split("/")[2];
            VideoSystem.openVideo(oneLine);
        }
    }

    /**
     * <p>jump to member's main page</p>
     * <p>Call {@link JumpTo#toMemberMain(Scene)} method in {@code JumptTo} class to jump to member's main page
     * </p>
     * @author Zhaoyang Ma
     * @version 1.0
     */
    public void toMemberMain() throws IOException{
        jump.toMemberMain(signOut.getScene());
    }

    /**
     * <p>jump to member's live page</p>
     * <p>Call {@link JumpTo#toMemberLive(Scene)} method in {@code JumptTo} class to jump to member's live page
     * </p>
     * @author Zhaoyang ma
     * @version 1.0
     */
    public void toMemberLive() throws IOException{
        jump.toMemberLive(signOut.getScene());
    }

    /**
     * <p>jump to home page</p>
     * <p>Call {@link JumpTo#toMain(Scene)} method in {@code JumptTo} class to jump to home page, and sign out.
     * </p>
     * @author Zhaoyang Ma
     * @version 1.0
     */
    public void signOut()throws IOException {
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(signOut.getScene());
    }
}
