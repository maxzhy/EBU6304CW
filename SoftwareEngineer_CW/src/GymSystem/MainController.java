package GymSystem;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Class for main page
 * <p>Class for main page, including......</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.0
 */
public class MainController {
    public JumpTo jump = new JumpTo();
    public Label logIn;
    public ImageView showLeftList;
    public AnchorPane leftList;
    public ImageView avatar;
    public ImageView hideLeftList;
    public Label leftListLogIn;
    public Label leftListSignUp;

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
    public void showLeftList() {
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
     * <p>Jump to log in page</p>
     * <p>By changing the scene configuration to change the page
     * </p>
     * @author Yongfan Jin
     * @throws Exception
     * @version 1.0
     */
    public void jumpToLogIn() throws Exception {
        jump.toLogIn(logIn.getScene());
    }

    public void jumpToSignUp() throws Exception {
        jump.toSignUp(logIn.getScene());
    }
}

//        Parent target = FXMLLoader.load(getClass().getResource("LogInGUI.fxml"));//载入LogIn界面的定义文件
//        Scene scene = new Scene(target); //创建场景；
//        Stage lgi=new Stage();//创建舞台；
//        lgi.setTitle("Log In");
//        lgi.setScene(scene); //将场景载入舞台；
//        lgi.show(); //显示窗口；