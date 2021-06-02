package GymSystem.ControlClass;

import GymSystem.EntityClass.Account;
import GymSystem.EntityClass.Income;
import GymSystem.EntityClass.NumberOfAccount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class VideoSystemCheck {

    /**
     * <p>get video information</p>
     * <p>read the videoinfo.txt and get the video information, stored in a {@code ArrayList<>}
     * </p>
     * @author Zhaoyang Ma
     * @version 2.0
     */
    public static ArrayList<String> checkVideos(String type) throws IOException{
        String fileName = "src/GymSystem/videos/videoinfo.txt";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String oneLine;
        String videoType;
        ArrayList<String> videos = new ArrayList<String>();

        if (type.equals("admin") || type.equals("platinum")) {
            while ((oneLine = bufferedReader.readLine()) != null) {
                videos.add(oneLine.split("/")[4]+ " - " +oneLine.split("/")[1]+ " /" +oneLine.split("/")[2]+ "/" +oneLine.split("/")[0]);
            }
        } else if(type.equals("member") || type.equals("premier")) {
            while ((oneLine = bufferedReader.readLine()) != null) {
                if (oneLine.split("/")[3].equals("general")) {
                    videos.add(oneLine.split("/")[4]+ " - " +oneLine.split("/")[1]+ " /" +oneLine.split("/")[2]+ "/" +oneLine.split("/")[0]);
                }
            }
        } else if(type.equals("trainer")) {
            while ((oneLine = bufferedReader.readLine()) != null) {
                videos.add(oneLine.split("/")[1]+ " /" +oneLine.split("/")[2]+ "/" +oneLine.split("/")[0]+ "/" +oneLine.split("/")[4]);
            }
        }
        return videos;
    }
}
