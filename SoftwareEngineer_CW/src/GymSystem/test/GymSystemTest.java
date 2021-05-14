package GymSystem.test;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import org.junit.jupiter.api.Test;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;

class GymSystemTest {

    @Test
    void addSchedule() throws IOException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date() ;
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate.toString().getClass());
        ArrayList<String> result = new ArrayList<String>();
        result = GymSystemCheck.checkSchedule("trainer01");
        System.out.println("original:");
        for (String s : result) {
            System.out.println(s);
        }
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size() - i - 1; j++) {
                if (result.get(j).compareTo(result.get(j+1)) > 0 ) {
                    Collections.swap(result, j, j+1);
                }
            }
        }
        System.out.println("present:");
        for (String s : result) {
            System.out.println(s);
        }
    }

    @Test
    void changeInfoTrainer() throws IOException {
        GymSystemCheck.setAccountNumber("trainer01");
        GymSystem.changeInfo("2021-04-18/13:00-14:00","schedule","delete","none");
    }
    @Test
    void changeInfoMember() throws IOException{
        GymSystemCheck.setAccountNumber("ecce");
        GymSystem.changeInfo(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"),"username","change","ecc");
    }
    @Test
    void operateLiveSession() throws IOException {
        GymSystemCheck.setAccountNumber("ecce");
        GymSystem.operateLiveSession("trainer01","2021-05-03","11:00-12:00",GymSystemCheck.accountNumber,"cancel");
    }
    @Test
    void deleteRequest() throws IOException{
        //GymSystem.deleteRequest("trainer01","ecce");
    }
    @Test
    void addRequest() throws IOException{
        GymSystem.addRequest("trainer01","ecce","I want to be thinner","I'm good at running");
    }
}