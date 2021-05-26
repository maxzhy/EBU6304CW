package GymSystem.ControlClass;

import java.io.*;
import java.util.ArrayList;

/**
 * Class for GymSystem
 * <p>The Control class, including ......</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 4.0
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
     * @param typeOfUser str type of user, "member" or "trainer"
     * @throws IOException
     * @author Yongfan Jin
     * @version 2.0
     */
     static void addAccountInfo(String accountNum, String password, String username, String phoneNum, String sexual, String typeOfUser) throws IOException {
        String fileName = "src/GymSystem/Information/accounts.txt";
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String accountInfo = accountNum + '/' + password + '/' + username + '/' + phoneNum + '/' + sexual + '/' + typeOfUser;
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
     * @throws IOException
     * @version 1.0
     */
     static boolean logIn(String accountNumInput, String passwordInput) throws IOException {
        boolean isLegal = false;
        String fileName = "src/GymSystem/Information/accounts.txt";
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

    /**
     * <p>add schedule to schedule.txt</p>
     * <p>add the input parameters into the schedule.txt file
     * </p>
     * @param date str the date of schedule
     * @param timePeriod str the time period of schedule
     * @author Yongfan Jin
     * @version 1.0
     */
    static void addSchedule(String date, String timePeriod) throws IOException{
        String fileName = "src/GymSystem/Information/schedule.txt";
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String schedule = GymSystemCheck.accountNumber + '/' + date + '/' + timePeriod + '/';
        bufferedWriter.write(schedule);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    /**
     * <p>change information</p>
     * <p>change information in certain file, for accounts.txt, it can replace the certain content with input content,
     * for schedule.txt, it can delete some certain information
     * </p>
     * @param itemToBeChanged str the content that is to be changed
     * @param typeOfItem str the type of the content, "schedule", "username", "password", "phone number", "sexual"
     *                   "membership"
     * @param mode str the mode of change, "delete" to delete information
     *             "change" to change information
     * @param targetValue str the content that is to changed to
     * @throws IOException
     * @author Yongfan Jin
     * @version 1.0
     */
    static void changeInfo(String itemToBeChanged,String typeOfItem,String mode,String targetValue) throws IOException{
        String fileName = "";
        String accountNum;
        switch (typeOfItem){
            case "schedule" : {
                fileName = "src/GymSystem/Information/schedule.txt";
                break;
            }
            case "username":
            case "password":
            case "phoneNum":
            case "sexual":
            case "membership" : {
                fileName = "src/GymSystem/Information/accounts.txt";
                break;
            }
            default: break;
        }
        File oldFile = new File(fileName);
        File newFile = new File("temp");
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("temp", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String oneLine="";
        ArrayList<String> newLines = new ArrayList<String>();
        switch (mode) {
            case "delete" : {
                while ((oneLine = bufferedReader.readLine()) != null) {
                    accountNum = oneLine.split("/")[0];
                    if (!( accountNum.equals(GymSystemCheck.accountNumber) &&
                           itemToBeChanged.split("/")[0].equals(oneLine.split("/")[1]) &&
                           itemToBeChanged.split("/")[1].equals(oneLine.split("/")[2]))){
                        newLines.add(oneLine);
                    }
                }
                bufferedReader.close();
                fileReader.close();

                for (String s: newLines){
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();

                oldFile.delete();
                newFile.renameTo(oldFile);
                break;
            }

            case "change": {
                String newContent;
                String password = "";
                String username = "";
                String phoneNum = "";
                String sexual = "";
                String type = "";
                while ((oneLine = bufferedReader.readLine()) != null) {
                    accountNum = oneLine.split("/")[0];
                    if (accountNum.equals(GymSystemCheck.accountNumber)){
                        password = oneLine.split("/")[1];
                        username = oneLine.split("/")[2];
                        phoneNum = oneLine.split("/")[3];
                        sexual = oneLine.split("/")[4];
                        type = oneLine.split("/")[5];
                        switch (typeOfItem) {
                            case "username": username = targetValue; break;
                            case "password": password = targetValue; break;
                            case "phoneNum": phoneNum = targetValue; break;
                            case "sexual"  : sexual = targetValue; break;
                            case "membership": type = targetValue; break;
                        }
                        newContent=GymSystemCheck.accountNumber+'/'+password+'/'+username+'/'+phoneNum+'/'+sexual+'/'+type;
                        newLines.add(newContent);
                    }else {
                        newLines.add(oneLine);
                    }
                }
                bufferedReader.close();
                fileReader.close();

                for (String s: newLines){
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();

                oldFile.delete();
                newFile.renameTo(oldFile);
                break;
            }
        }
    }

    /**
     * <p>oprate live session</p>
     * <p>operate live session records in schedule.txt, including booking and canceling
     * </p>
     * @param trainerAccInput str trainer's account number
     * @param dateInput str the date of live session
     * @param timeInput str the time period of live session
     * @param memberAccInput str the booker's account number
     * @param mode str the mode of operation, "book" or "cancel"
     * @throws IOException
     * @author Yongfan Jin
     * @version 1.0
     */
    static void operateLiveSession(String trainerAccInput,String dateInput,String timeInput,String memberAccInput,String mode) throws IOException{
        String fileName = "src/GymSystem/Information/schedule.txt";
        File oldFile = new File(fileName);
        File newFile = new File("temp");
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("temp", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String oneLine="";
        ArrayList<String> newLines = new ArrayList<String>();
        String newContent;
        String trainerAcc = "";
        String date = "";
        String time = "";
        String memberAcc = "";
        while ((oneLine = bufferedReader.readLine()) != null) {
            trainerAcc = oneLine.split("/")[0];
            date = oneLine.split("/")[1];
            time = oneLine.split("/")[2];
            if (oneLine.split("/").length == 3){
                memberAcc="";
            } else {
                memberAcc = oneLine.split("/")[3];
            }
            switch (mode) {
                case "book" : {
                    if (trainerAcc.equals(trainerAccInput) && date.equals(dateInput) && time.equals(timeInput) && memberAcc.equals("")) {
                        memberAcc = memberAccInput;
                    }
                    newContent=trainerAcc+'/'+date+'/'+time+'/'+memberAcc;
                    newLines.add(newContent);
                    break;
                }
                case "cancel" : {
                    if (trainerAcc.equals(trainerAccInput) && date.equals(dateInput) && time.equals(timeInput) && memberAcc.equals(memberAccInput)) {
                        memberAcc = "";
                    }
                    newContent=trainerAcc+'/'+date+'/'+time+'/'+memberAcc;
                    newLines.add(newContent);
                    break;
                }
            }

        }
        bufferedReader.close();
        fileReader.close();

        for (String s: newLines){
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();

        oldFile.delete();
        newFile.renameTo(oldFile);
    }

    /**
     * <p>add request</p>
     * <p>add requests to the requests.txt
     * </p>
     * @param trainerAccInput str the trainer's account
     * @param studentAccInput str the student's account
     * @param targetInput str the content of targets
     * @param abilityInput str the content of physical ability
     * @throws IOException
     * @author Yongfan Jin
     * @version 1.0
     */
    static void addRequest(String trainerAccInput, String studentAccInput, String targetInput, String abilityInput) throws IOException{
        String fileName = "src/GymSystem/Information/requests.txt";
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String request = trainerAccInput + '/' + studentAccInput + '/' + targetInput + '/' + abilityInput;
        bufferedWriter.write(request);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    /**
     * <p>add income records</p>
     * <p>add income records in income.txt
     * </p>
     * @param amount str the amount of income
     * @param accNumInput str the account of purchaser
     * @param state str where the income from, "premier" or "platinum"
     * @author Yongfan Jin
     * @version 1.0
     */
    static void addIncome(String amount, String accNumInput, String state) throws IOException{
        String fileName = "src/GymSystem/Information/income.txt";
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String request = accNumInput + '/' + amount + '/' + state;
        bufferedWriter.write(request);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }
}
