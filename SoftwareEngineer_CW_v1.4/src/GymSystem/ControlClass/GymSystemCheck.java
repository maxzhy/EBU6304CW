package GymSystem.ControlClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for several methods of checking
 * <p>Class for several static method, aim to check something or return some information</p>
 * @author
 * @date 2021-04-07
 * @since 1.0
 * @version 1.0
 */
public class GymSystemCheck {
    public static String logInState="not"; //"manager","trainer","member","premier_member","platinum_member"
    public static String accountNumber="";
    public static void setLogInState(String state) {
        logInState=state;
    }
    public static void setAccountNumber(String accNum){accountNumber=accNum;}
    /**
     * <p>Check account number</p>
     * <p>Check whether account number is 1:Only composed of numbers and letters
     * 2. Starts with one letter. 3. 2-10 characters only. Use Regular Expression.
     * </p>
     * @param input str user's input of account number
     * @return if user's input is legal
     * @author Yongfan Jin
     * @date 2020-04-07
     * @version 1.0
     */
    public static boolean checkAccountNum(String input) {
        boolean isLegal;
        String rule = "[a-zA-z]+[A-Za-z0-9]{1,9}";
        isLegal = input.matches(rule);
        return isLegal;
    }

    /**
     * <p>Check password</p>
     * <p>Check whether password is greater than 6 characters. Use Regular Expression.
     * </p>
     * @param input str user's input of password
     * @return if user's input is legal
     * @author Yongfan Jin
     * @date 2020-04-07
     * @version 1.0
     */
    public static boolean checkPassword(String input) {
        boolean isLegal;
        int length = input.length();
        isLegal = length >= 6;
        return isLegal;
    }

    /**
     * <p>Check username</p>
     * <p>Check whether account number is 1:Only composed of numbers and letters
     * 2. 2-10 characters only. Use Regular Expression.
     * </p>
     * @param input str user's input of username
     * @return if user's input is legal
     * @author Yongfan Jin
     * @date 2020-04-07
     * @version 1.0
     */
    public static boolean checkUsername(String input) {
        boolean isLegal;
        String rule = "[A-Za-z0-9]{2,10}";
        isLegal = input.matches(rule);
        return isLegal;
    }

    /**
     * <p>Check phone number</p>
     * <p>Check whether account number is 1:Only composed of numbers
     * 2. Starts with number "1". 3. 11 numbers only. Use Regular Expression.
     * </p>
     * @param input str user's input of phone number
     * @return if user's input is legal
     * @author Yongfan Jin
     * @date 2020-04-07
     * @version 1.0
     */
    public static boolean checkPhoneNum(String input) {
        boolean isLegal;
        String rule = "1[0-9]{10}";
        isLegal = input.matches(rule);
        return isLegal;
    }

    /**
     * <p>To get some information of certain user</p>
     * <p>Using given account number from parameter, search accounts.txt and return certain information,
     * based on parameter {@code contentOfCheck}.
     * </p>
     * @param accountNumInput str account number of the user
     * @param contentOfCheck str what kind of information the method will return,
     *                       can choose from "accountNum","password","username","phoneNum","sexual"
     * @return the information which is supposed to be returned
     * @author Yongfan Jin
     * @date 2021-04-07
     * @version 1.0
     */
    public static String checkAccountInfo(String accountNumInput, String contentOfCheck) throws IOException {
        String fileName = "src/GymSystem/Information/accounts.txt";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String oneLine;
        String isRepeated="no";
        String accountNum;
        String password = "";
        String username = "";
        String phoneNum = "";
        String sexual = "";
        String type = "";
        while ((oneLine = bufferedReader.readLine()) != null) {
            accountNum = oneLine.split("/")[0];
            if (accountNum.equals(accountNumInput)) {
                isRepeated = "yes";
                password = oneLine.split("/")[1];
                username = oneLine.split("/")[2];
                phoneNum = oneLine.split("/")[3];
                sexual = oneLine.split("/")[4].equals("man") ? "Mr." : "Ms.";
                type = oneLine.split("/")[5];
                break;
            }
        }
        bufferedReader.close();
        fileReader.close();
        switch (contentOfCheck) {
            case "accountNum" :
                return isRepeated;
            case "password":
                return password;
            case "username":
                return username;
            case "phoneNum":
                return phoneNum;
            case "sexual":
                return sexual;
            case "type":
                return type;
            default:
                return null;
        }
    }

    public static ArrayList<String> checkSchedule(String acccountNumberInput) throws IOException {
        String fileName = "src/GymSystem/Information/schedule.txt";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String oneLine;
        String accountNum;
        ArrayList<String> schedules = new ArrayList<String>();
        while ((oneLine = bufferedReader.readLine()) != null){
            accountNum = oneLine.split("/")[0];
            if (acccountNumberInput.equals(accountNum)){
                schedules.add(oneLine.split("/")[1] + " " + oneLine.split("/")[2]);
            }
        }
        sortSchedule(schedules);
        bufferedReader.close();
        fileReader.close();
        return schedules;
    }

    public static ArrayList<String> sortSchedule(ArrayList<String> inputSchedule){
        for (int i = 0; i < inputSchedule.size(); i++) {
            for (int j = 0; j < inputSchedule.size() - i - 1; j++) {
                if (inputSchedule.get(j).compareTo(inputSchedule.get(j+1)) > 0 ) {
                    Collections.swap(inputSchedule, j, j+1);
                }
            }
        }
        return inputSchedule;
    }
}
