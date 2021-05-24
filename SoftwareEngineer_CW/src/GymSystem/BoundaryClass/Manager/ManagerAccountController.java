package GymSystem.BoundaryClass.Manager;

import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import GymSystem.EntityClass.NumberOfAccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
/**
 * Class for manager's manage accounts page
 * <p>Class for manager's manage accounts page, manager can see how many accounts the gym system has.</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 1.0
 */
public class ManagerAccountController {
    JumpTo jump = new JumpTo();
    public Label signOut;
    public Label home;
    public Label live;
    public Label video;
    public ImageView avatar;
    public Label username;
    public ImageView backToManagerMain;
    public PieChart chart;
    public Label numOfMember;
    public Label numOfPremier;
    public Label numOfPlatinum;
    public Label numOfTrainer;
    public Label numOfTotal;
    public AnchorPane numPane;
    public int totalNum=0;

    /**
     * <p>initialize the page</p>
     * <p>call {@link GymSystemCheck#checkNumberOfAcc()} in {@code GymSystemCheck} class to get the data of accounts,
     * including the number of member, premier member, platinum member, trainer, also, calculate the total number of
     * accounts for future use.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @FXML
    public void initialize()throws IOException{
        NumberOfAccount nums ;
        nums = GymSystemCheck.checkNumberOfAcc();
        chart.setTitle("Number of Users");
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Normal Member", nums.getNumOfMember()),
                        new PieChart.Data("Premier Member", nums.getNumOfPremier()),
                        new PieChart.Data("Platinum Member", nums.getNumOfPlatinum()),
                        new PieChart.Data("Trainer", nums.getNumOfTrainer())
                );
        chart.setData(pieChartData);
        totalNum = nums.getNumOfPlatinum()+nums.getNumOfMember()+nums.getNumOfPremier()+nums.getNumOfTrainer();
    }

    /**
     * <p>show or hide the detail numbers of accounts</p>
     * <p>When click the chart, if the details are not shown, show details, including the number of member, premier
     * member, platinum member, trainer and the total accounts, if the details are shown already, hide them.
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    public void toggleNumbers(){
        numOfMember.setText("Number of Member: "+String.valueOf((int)chart.getData().get(0).getPieValue()));
        numOfPremier.setText("Number of Premier: "+String.valueOf((int)chart.getData().get(1).getPieValue()));
        numOfPlatinum.setText("Number of Platinum: "+String.valueOf((int)chart.getData().get(2).getPieValue()));
        numOfTrainer.setText("Number of Trainer: "+String.valueOf((int)chart.getData().get(3).getPieValue()));
        numOfTotal.setText("Total Number: "+String.valueOf(totalNum));
        numPane.setVisible(!numPane.isVisible());

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
}
