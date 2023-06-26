package GymSystem.BoundaryClass.Member;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

/**
 * class used in member's main page
 * <p>class used in member's main page</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 2.0
 */
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
     * @author Yongfan Jin
     * @throws IOException
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
     * @author Yongfan Jin
     * @version 1.0
     */
    public void hideLeftList() {
        leftList.setMouseTransparent(true);
        leftList.setOpacity(0);
        avatar.setOpacity(0);
        showLeftList.setOpacity(1);
    }

    /**
     * <p>jump to member's live page</p>
     * <p>Call {@link JumpTo#toMemberLive(Scene)} method in {@code JumptTo} class to jump to member's live page
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toLive() throws IOException{
        jump.toMemberLive(username.getScene());
    }

    /**
     * <p>jump to member's upgrade page</p>
     * <p>Call {@link JumpTo#toUpgrade(Scene)} method in {@code JumptTo} class to jump to member's upgrade page
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toUpgrade()throws IOException{
        jump.toUpgrade(username.getScene());
    }

    /**
     * <p>jump to member's information page</p>
     * <p>Call {@link JumpTo#toMemberInformation(Scene)} (Scene)} method in {@code JumptTo} class to jump to member's information page
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toInformation() throws IOException{
        jump.toMemberInformation(username.getScene());
    }

    /**
     * <p>jump to member's watch video page</p>
     * <p>Call {@link JumpTo#toMemberWatchVideo(Scene)} (Scene)} (Scene)} method in {@code JumptTo} class to jump to member's watch video page
     * </p>
     * @author Zhaoyang Ma
     * @version 2.0
     */
    public void toMemberWatchVideo() throws IOException{
        jump.toMemberWatchVideo(username.getScene());
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
}
