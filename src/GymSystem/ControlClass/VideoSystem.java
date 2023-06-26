package GymSystem.ControlClass;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;
import java.util.Scanner;

public interface VideoSystem {

    /**
     * <p>add video information</p>
     * <p>add information related to videos to txt file
     * </p>
     * @param title str title of video
     * @param type str type of video
     * @param access str title of video
     * @param trainer str person who upload the video
     * @throws IOException
     * @author Zhaoyang Ma
     * @version 1.0
     */
    static int addVideoInfo(String title, String type, String access, String trainer) throws IOException{
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
        String accountInfo = lines + '/' + title + '/' + type+ '/' +access+ '/' +trainer;
        bufferedWriter.write(accountInfo);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();

        return count;
    }

    /**
     * <p>choose video path</p>
     * <p>Select video from local
     * </p>
     * @author Zhaoyang Ma
     * @version 1.0
     */
    static File videoPathChoose() throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.mov")
        );

        Window primaryStage = null;
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            return (selectedFile);
        }
        return null;
    }

    /**
     * <p>open video</p>
     * <p>call system video player to play selected video
     * </p>
     * @param num str chosen No. of video
     * @author Yongfan Jin
     * @version 2.0
     */
    static void openVideo(String num) {
        Runtime rn = Runtime.getRuntime();
        Process p = null;
        File file = new File("src/GymSystem/videos/" +num+ ".mp4");
        try {
            if(System.getProperty("os.name").equals("Mac OS X")){
                p = rn.exec( "open " + "src/GymSystem/videos/"+num+".mp4");
            }else{
                Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /k start "+file);
            }
            InputStream in = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String str = null;
            while((str=br.readLine()) != null){
                System.out.println(str);
            }
            br.close();
        }catch(Exception e) {
            System.out.println( "Error exec notepad!");
        }
    }
}
