package GymSystem.BoundaryClass.Manager;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import GymSystem.EntityClass.Income;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class used in manager's manage fund page
 * <p>Class for manager's manage fund page, manager can see how many income the gym system has earned.</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.0
 */
public class ManagerFundController {
    JumpTo jump = new JumpTo();
    public Label signOut;
    public Label home;
    public Label live;
    public Label video;
    public ImageView avatar;
    public Label username;
    public ImageView backToManagerMain;
    public TextArea incomePane;
    public Label totalIncome;

    /**
     * <p>initialize the page</p>
     * <p>Call {@link GymSystemCheck#checkIncome()} in {@code GymSystemCheck} class to get the data of incomes,
     * including the accounts, the amount of income, where the income from. Then, show the data in {@code PieChart}, also
     * calculate the total income for future use.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @FXML
    public void initialize()throws IOException{
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
        String account;
        String amount;
        String from;
        int totalAmount=0;
        String oneLine;
        ArrayList<Income> incomes = GymSystemCheck.checkIncome();
        for (int i=0;i<incomes.size();i++){
            account = incomes.get(i).getAccount();
            amount = incomes.get(i).getAmount();
            from = incomes.get(i).getFrom().toUpperCase();
            oneLine = i+1 + ". \"" + account + "\" paid to become \"" + from + "\" member, income: \"$" + amount + "\".\n";
            incomePane.appendText(oneLine);
            totalAmount+= Integer.parseInt(amount);
        }
        totalIncome.setText("$ " + String.valueOf(totalAmount));
    }

    /**
     * <p>jump to manager's main page</p>
     * <p>Call {@link JumpTo#toManagerMain(Scene)} method in {@code JumptTo} class to jump to manager's main page
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toManagerMain() throws IOException{
        jump.toManagerMain(signOut.getScene());
    }

    /**
     * <p>jump to home page</p>
     * <p>Call {@link JumpTo#toMain(Scene)} method in {@code JumptTo} class to jump to home page, and sign out.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void signOut() throws IOException{
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(signOut.getScene());
    }

    /**
     * <p>jump to manager watch video page</p>
     * <p>Call {@link JumpTo#toManagerWatchVideo(Scene)} (Scene)} method in {@code JumptTo} class to jump to watch video page.
     * </p>
     * @author Zhaoyang Ma
     * @version 2.0
     */
    public void toManagerWatchVideo() throws IOException {
        jump.toManagerWatchVideo(signOut.getScene());
    }
}
