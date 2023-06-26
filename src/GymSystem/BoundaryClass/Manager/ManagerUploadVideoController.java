package GymSystem.BoundaryClass.Manager;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import GymSystem.ControlClass.VideoSystem;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


//Ma Zhaoyang
public class ManagerUploadVideoController {
    public TextField title, comment;
    public Button videoUploadButton, pathChooseButton;
    public Label pathBoard;
    public RadioButton general;
    public RadioButton platinum;
    public boolean isGeneral;
    public boolean isPlatinum;

    @FXML
    public JumpTo jump = new JumpTo();
    public Label username;
    public Label signOut;
    public File path;
    public ChoiceBox videoType;

    public void initialize() {
        videoType.setItems(FXCollections.observableArrayList(
                "yoga",
                "running",
                "movements",
                "others"
        ));
    }

    /**
     * <p>Method for RadioButton "general" of choice of accessibility</p>
     * <p>Ensure that user only choose one of the two choices:
     *      general or platinum. They can't neither choose both nor choose nothing.
     * </p>
     * @author Zhaoyang Ma
     * @version 1.0
     */
    public void setTypeGeneral() {
        if (isGeneral) {
            general.setSelected(true);
            return;
        }
        if (isPlatinum) {
            general.setSelected(!isGeneral);
            platinum.setSelected(!isPlatinum);
        }
        isGeneral = general.isSelected();
        isPlatinum = platinum.isSelected();
    }

    /**
     * <p>Method for RadioButton "platinum" of choice of accessibility</p>
     * <p>Ensure that user only choose one of the two choices:
     *      general or platinum. They can't neither choose both nor choose nothing.
     * </p>
     * @author Zhaoyang Ma
     * @version 1.0
     */
    public void setTypePlatinum() {
        if (isPlatinum) {
            platinum.setSelected(true);
            return;
        }
        if (isGeneral) {
            general.setSelected(!isGeneral);
            platinum.setSelected(!isPlatinum);
        }
        isGeneral = general.isSelected();
        isPlatinum = platinum.isSelected();
    }

    /**
     * <p>call {@link VideoSystem#videoPathChoose()} method in {@code VideoSystem} to find the path of video
     * </p>
     * @author Zhaoyang Ma
     * @version 1.0
     */
    public void videoPathDefine() throws IOException{
        path = VideoSystem.videoPathChoose();
        pathBoard.setText(path.toString());
    }

    /**
     * <p>Upload video method</p>
     * <p>  1. call {@link GymSystemCheck#checkAccountInfo(String, String)} method in {@code GymSystemCheck}
     *      2. Call {@link VideoSystem#addVideoInfo(String, String, String, String)} method in {@code VideoSystem} to add info.
     * </p>
     * @author Zhaoyang Ma
     * @throws IOException
     * @version 1.0
     */
    public void videoUpload() throws IOException {
        boolean typeLegal = isGeneral || isPlatinum;
        if (!typeLegal) {
            pathBoard.setText("Please choose video accessibility!");
            return;
        }
        if (videoType.getValue() == null){
            pathBoard.setText("Please choose video type!");
            return;
        }
        if (pathBoard.getText().equals("<- Click here to choose video") || pathBoard.getText().equals("Please choose video accessibility!") || pathBoard.getText().equals("Please choose video file!") || pathBoard.getText().equals("Please choose video type!")) {
            pathBoard.setText("Please choose video file!");
            return;
        }

        String titleInput = title.getText();
        String typeInput = (String) videoType.getValue();
        String accessInput = isGeneral ? "general" : "platinum";
        String managerInput;

        title.setText("");

        pathBoard.setText(path.toString()+ " Upload Successfully!");
        managerInput = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username");

        int currentVideo = VideoSystem.addVideoInfo(titleInput, typeInput, accessInput, managerInput);

        FileInputStream in = new FileInputStream(path);
        FileOutputStream out = new FileOutputStream("src/GymSystem/videos/"+Integer.toString(currentVideo)+".mp4");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        in.close();
        out.close();
    }

    /**
     * <p>jump to home page</p>
     * <p>Call {@link JumpTo#toMain(Scene)} method in {@code JumptTo} class to jump to home page, and sign out.
     * </p>
     * @author Zhaoyang Ma
     * @version 1.0
     */
    public void signOut() throws IOException{
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(signOut.getScene());
    }

    /**
     * <p>jump to manager's main page</p>
     * <p>Call {@link JumpTo#toManagerMain(Scene)} method in {@code JumptTo} class to jump to manager's main page
     * </p>
     * @author Zhaoyang Ma
     * @version 1.0
     */
    public void toManagerMain() throws IOException{
        jump.toManagerMain(signOut.getScene());
    }

    /**
     * <p>jump to manager's watch video page</p>
     * <p>Call {@link JumpTo#toManagerWatchVideo(Scene)} (Scene)} method in {@code JumptTo} class to jump to manager's watch video page
     * </p>
     * @author Zhaoyang Ma
     * @version 2.0
     */
    public void toManagerWatchVideo() throws IOException {
        jump.toManagerWatchVideo(signOut.getScene());
    }
}
