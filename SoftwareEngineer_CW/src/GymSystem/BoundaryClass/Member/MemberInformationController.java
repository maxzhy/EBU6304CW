package GymSystem.BoundaryClass.Member;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import GymSystem.ControlClass.JumpTo;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.io.IOException;

public class MemberInformationController {
    public JumpTo jump = new JumpTo();
    public Label signOut;
    public Label username;
    public Label password;
    public Label phoneNum;
    public Label membership;
    public Label sexual;
    public ImageView toMemberMain;
    public Label edit;
    public boolean visiable =false;
    public boolean isMan = false;
    public boolean isWoman = false;
    public TextField editUsername;
    public PasswordField editPassword;
    public TextField editPhoneNum;
    public Button editMembership;
    public RadioButton editSexualMan;
    public RadioButton editSexualWomen;
    public Button editApply;
    public Label message1;
    public Label message2;
    public Label message3;
    public Label message4;
    public Label message5;
    public Label usnmIcon;
    public Label pswdIcon;
    public Label phnmIcon;

    @FXML
    public void initialize() throws IOException{
        getCurrentInfo();
    }

    public void applyChange() throws IOException{
        boolean pswLegal = pswdIcon.getText().equals("√") || pswdIcon.getText().equals("");
        boolean usnmLegal = usnmIcon.getText().equals("√") || usnmIcon.getText().equals("");
        boolean phnmLegal = phnmIcon.getText().equals("√") || phnmIcon.getText().equals("");
        boolean sexLegal = isMan || isWoman;
        boolean allLegal;
        boolean isChanged = false;
        if (!sexLegal){
            allLegal = pswLegal && usnmLegal && phnmLegal;
        } else {
            allLegal = pswLegal && usnmLegal && phnmLegal && sexLegal;
        }

        String changedSex = isMan? "man": "woman";
        if (!allLegal) {
            message5.setText("Please fill in the information correctly.");
            return;
        }
        if (!usnmIcon.getText().equals("")){
            GymSystem.changeInfo(username.getText(),"username","change",editUsername.getText());
            isChanged =true;
        }
        if (!pswdIcon.getText().equals("")){
            GymSystem.changeInfo(password.getText(),"password","change",editPassword.getText());
            isChanged =true;
        }
        if (!phnmIcon.getText().equals("")){
            GymSystem.changeInfo(phoneNum.getText(),"phoneNum","change",editPhoneNum.getText());
            isChanged =true;
        }
        if (sexLegal){
            GymSystem.changeInfo(sexual.getText(),"sexual","change",changedSex);
            isChanged =true;
        }
        if (isChanged) {
            message5.setText("Information changed.");
        }
        getCurrentInfo();
        editUsername.setText("");
        editPassword.setText("");
        editPhoneNum.setText("");
        usnmIcon.setText("");
        pswdIcon.setText("");
        phnmIcon.setText("");
        message5.setText("");
        editSexualMan.setSelected(false);
        isMan = editSexualMan.isSelected();
        isWoman = editSexualWomen.isSelected();
        editSexualWomen.setSelected(false);
    }


    public void getCurrentInfo() throws IOException{
        username.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"));
        password.setText("******");
        phoneNum.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"phoneNum"));
        membership.setText(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"type"));
        if (GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"sexual").equals("Mr.")) {
            sexual.setText("man");
        } else {
            sexual.setText("woman");
        }
    }

    public void checkUsername() {
        if(GymSystemCheck.checkUsername(editUsername.getText())) {
            usnmIcon.setText("√");
            usnmIcon.setTextFill(Color.rgb(0, 255, 0));
        } else {
            usnmIcon.setText("X");
            usnmIcon.setTextFill(Color.rgb(255, 0, 0));
        }
        if(editUsername.getText().equals("")) {
            usnmIcon.setText("");
        }
    }

    public void checkPassword() {
        if(GymSystemCheck.checkPassword(editPassword.getText())){
            pswdIcon.setText("√");
            pswdIcon.setTextFill(Color.rgb(0, 255, 0));
        } else {
            pswdIcon.setText("X");
            pswdIcon.setTextFill(Color.rgb(255, 0, 0));
        }
        if(editPassword.getText().equals("")) {
            pswdIcon.setText("");
        }
    }

    public void checkPhoneNum() {
        if(GymSystemCheck.checkPhoneNum(editPhoneNum.getText())){
            phnmIcon.setText("√");
            phnmIcon.setTextFill(Color.rgb(0, 255, 0));
        } else {
            phnmIcon.setText("X");
            phnmIcon.setTextFill(Color.rgb(255, 0, 0));
        }
        if(editPhoneNum.getText().equals("")) {
            phnmIcon.setText("");
        }
    }

    /**
     * <p>Method for RadioButton "man" of choice of sexual</p>
     * <p>Ensure that user only choose one of the two choices:
     *      man or woman. They can't neither choose both nor choose nothing.
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void selectSexMan() {
        if (isMan) {
            editSexualMan.setSelected(true);
            return;
        }
        if (isWoman) {
            editSexualMan.setSelected(!isMan);
            editSexualWomen.setSelected(!isWoman);
        }
        isMan = editSexualMan.isSelected();
        isWoman = editSexualWomen.isSelected();
    }

    /**
     * <p>Method for RadioButton "woman" of choice of sexual</p>
     * <p>Ensure that user only choose one of the two choices:
     * man or woman. They can't neither choose both nor choose nothing.
     * </p>
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public void selectSexWoman() {
        if (isWoman) {
            editSexualWomen.setSelected(true);
            return;
        }
        if (isMan) {
            editSexualMan.setSelected(!isMan);
            editSexualWomen.setSelected(!isWoman);
        }
        isMan = editSexualMan.isSelected();
        isWoman = editSexualWomen.isSelected();
    }




    public void toggleEditInterface() {
        editUsername.setText("");
        editPassword.setText("");
        editPhoneNum.setText("");
        usnmIcon.setText("");
        pswdIcon.setText("");
        phnmIcon.setText("");
        message5.setText("");
        editSexualMan.setSelected(false);
        isMan = editSexualMan.isSelected();
        isWoman = editSexualWomen.isSelected();
        editSexualWomen.setSelected(false);
        editUsername.setVisible(!visiable);
        editPassword.setVisible(!visiable);
        editPhoneNum.setVisible(!visiable);
        editMembership.setVisible(!visiable);
        editSexualMan.setVisible(!visiable);
        editSexualWomen.setVisible(!visiable);
        editApply.setVisible(!visiable);
        message1.setVisible(!visiable);
        message2.setVisible(!visiable);
        message3.setVisible(!visiable);
        message4.setVisible(!visiable);
        message5.setVisible(!visiable);
        usnmIcon.setVisible(!visiable);
        pswdIcon.setVisible(!visiable);
        phnmIcon.setVisible(!visiable);
        visiable =!visiable;
    }

    public void toMemberMain() throws IOException{
        jump.toMemberMain(username.getScene());
    }

    public void toMemberUpgrade() throws IOException{
        jump.toUpgrade(username.getScene());
    }

    public void signOut()throws IOException {
        GymSystemCheck.setAccountNumber(null);
        GymSystemCheck.setLogInState("not");
        jump.toMain(signOut.getScene());
    }
}
