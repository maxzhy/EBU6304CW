package GymSystem.ControlClass;

import java.io.*;

/**
 * Class for GymSystem
 * <p>The Control class, including ......</p>
 * @author
 * @date 2021-04-07
 * @since 1.0
 * @version 1.0
 */
public interface GymSystem {
    /**
     * <p>Add account information</p>
     * <p>Add account information from parameters to accounts.txt, write them in one row at a time.
     * </p>
     * @param accountNum str account number
     * @param password str password
     * @param username str username
     * @param phoneNum str phone number
     * @param sexual str sexual
     * @return none
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
     static void addAccountInfo(String accountNum, String password, String username, String phoneNum, String sexual) throws IOException {
        String fileName = "src\\GymSystem\\Information\\accounts.txt";
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String accountInfo = accountNum + '/' + password + '/' + username + '/' + phoneNum + '/' + sexual + "/member";
        bufferedWriter.write(accountInfo);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    /**
     * <p>Log in method</p>
     * <p>From parameters, scan the accounts.txt to decide whether
     * there exist same account number and password, if so, log in,
     * if not, log in fails.
     * </p>
     * @param accountNumInput str account number user typed in
     * @param passwordInput str password user typed in
     * @return whether log in is successful
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
     static boolean logIn(String accountNumInput, String passwordInput) throws IOException {
        boolean isLegal = false;
        String fileName = "src\\GymSystem\\Information\\accounts.txt";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String oneLine="";
        String accountNum="";
        String password="";
        while ((oneLine = bufferedReader.readLine()) != null) {
            accountNum = oneLine.split("/")[0];
            password = oneLine.split("/")[1];
            if (accountNum.equals(accountNumInput) && password.equals(passwordInput)) {
                isLegal = true;
                break;
            }
        }
        bufferedReader.close();
        fileReader.close();
        return isLegal;
    }


}
