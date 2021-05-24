package GymSystem.BoundaryClass.Trainer;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TrainerMainController {
    public JumpTo jump = new JumpTo();
    public Label signOut;
    public ImageView showLeftList;
    public AnchorPane leftList;
    public ImageView avatar;
    public ImageView hideLeftList;
    public Label username;
    public Label toUpload;
    public Label toClass;
    /**
     * <p>Method to show left navigation bar</p>
     * <p>By setting MouseTransparent and opacity of leftList,
     *    to show the left navigation bar and make it clickable.
     *    Also to show the avatar of user, because avatar should be
     *    totally opaque, while left navigation bar should be partially
     *    transparent.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void showLeftList() throws IOException {
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
        leftList.setMouseTransparent(false);
        leftList.setOpacity(0.8);
        avatar.setOpacity(1);
        showLeftList.setOpacity(0);
    }

    /**
     * <p>Method to hide the left navigation bar</p>
     * <p>By setting MouseTransparent and opacity of leftList,
     *      to hide the left navigation bar together with avatar
     *      and make them non-clickable.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void hideLeftList() {
        leftList.setMouseTransparent(true);
        leftList.setOpacity(0);
        avatar.setOpacity(0);
        showLeftList.setOpacity(1);
    }

    //Ma Zhaoyang
    public void toUploadVideo()throws IOException{
        jump.toUploadVideo(username.getScene());
    }

    public void toClass() throws IOException {
        jump.toTrainerClass(signOut.getScene());
    }

    public void signOut()throws IOException {
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(signOut.getScene());
    }
}
