package GymSystem.BoundaryClass.Member;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MemberMainController {
    public JumpTo jump = new JumpTo();
    public Label signOut;
    public ImageView showLeftList;
    public AnchorPane leftList;
    public ImageView avatar;
    public ImageView hideLeftList;
    public Label username;
    public Label toUpgrade;
    public Label toInformation;
    public Label toLive1;
    public Label toLive2;
    /**
     * <p>Method to show left navigation bar</p>
     * <p>By setting MouseTransparent and opacity of leftList,
     *    to show the left navigation bar and make it clickable.
     *    Also to show the avatar of user, because avatar should be
     *    totally opaque, while left navigation bar should be partially
     *    transparent.
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void showLeftList() throws IOException{
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
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void hideLeftList() {
        leftList.setMouseTransparent(true);
        leftList.setOpacity(0);
        avatar.setOpacity(0);
        showLeftList.setOpacity(1);
    }

    public void toLive() throws IOException{
        jump.toMemberLive(username.getScene());
    }

    public void toUpgrade()throws IOException{
        jump.toUpgrade(username.getScene());
    }

    public void toInformation() throws IOException{
        jump.toMemberInformation(username.getScene());
    }

    public void signOut()throws IOException {
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(signOut.getScene());
    }
}
