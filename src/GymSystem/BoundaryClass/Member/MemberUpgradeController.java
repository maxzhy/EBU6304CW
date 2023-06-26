package GymSystem.BoundaryClass.Member;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.io.IOException;

/**
 * class used in member's upgrade page
 * <p>class used in member's upgrade page, user can upgrade his membership here</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.0
 */
public class MemberUpgradeController {
    public JumpTo jump = new JumpTo();
    public Label username;
    public Label signOut;
    public ImageView backToMemberMain;
    public Button upToPremier;
    public Button upToPlatinum;
    public Label message;
    public Label home;
    public Label live;
    public Label video;

    /**
     * <p>initialize the page</p>
     * <p>get the username and show it
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @FXML
    public void initialize()throws IOException{
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
    }

    /**
     * <p>upgrade to premier member</p>
     * <p>call {@link GymSystem#changeInfo(String, String, String, String)} and {@link GymSystem#addIncome(String, String, String)}
     * to upgrade to premier member and add one income record, only normal member can upgrade
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void upgradeToPremier() throws IOException{
        String currentType = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"type");
        if (currentType.equals("member")){
            GymSystem.changeInfo(currentType,"membership","change","premier");
            GymSystem.addIncome("150",GymSystemCheck.accountNumber,"premier");
        } else {
            message.setText("You have already been Premier Member!");
        }
    }

    /**
     * <p>upgrade to platinum member</p>
     * <p>call {@link GymSystem#changeInfo(String, String, String, String)} and {@link GymSystem#addIncome(String, String, String)}
     * to upgrade to platinum member and add one income record, only normal member and platinum member can upgrade
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void upgradeToPlatinum() throws IOException{
        String currentType = GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"type");
        if (currentType.equals("member")||currentType.equals("premier")){
            GymSystem.changeInfo(currentType,"membership","change","platinum");
            GymSystem.addIncome("200",GymSystemCheck.accountNumber,"platinum");
        } else {
            message.setText("You have already been Platinum Member!");
        }
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
    public void signOut()throws IOException{
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(username.getScene());
    }
}
