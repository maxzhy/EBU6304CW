package GymSystem.ControlClass;

import java.io.*;
import java.util.Scanner;

public interface VideoSystem {

    static void addVideoInfo(String title, String comment) throws IOException{
        String fileName = "src/GymSystem/videos/videoinfo.txt";

        int count = 1;
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        while(scanner.hasNextLine()){
            scanner.nextLine();
            count++;
        }
        String lines = Integer.toString(count);



        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String accountInfo = lines + '/' + title + '/' + comment;
        bufferedWriter.write(accountInfo);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }



}
