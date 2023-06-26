package GymSystem.Test;

import GymSystem.ControlClass.GymSystem;
import GymSystem.ControlClass.GymSystemCheck;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * test class for {@link GymSystem}
 * <p>test class for {@link GymSystem}</p>
 * @author Yongfan Jin
 * @since 1.0
 * @version 4.0
 */
class GymSystemTest {

    /**
     * <p>test {@link GymSystem#addSchedule(String, String)}</p>
     * <p>test {@link GymSystem#addSchedule(String, String)}
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
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

    /**
     * <p>test {@link GymSystem#changeInfo(String, String, String, String)} for trainer</p>
     * <p>test {@link GymSystem#changeInfo(String, String, String, String)} for trainer
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @Test
    void changeInfoTrainer() throws IOException {
        GymSystemCheck.setAccountNumber("trainer01");
        GymSystem.changeInfo("2021-04-18/13:00-14:00","schedule","delete","none");
    }

    /**
     * <p>test {@link GymSystem#changeInfo(String, String, String, String)} for member</p>
     * <p>test {@link GymSystem#changeInfo(String, String, String, String)} for member
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @Test
    void changeInfoMember() throws IOException{
        GymSystemCheck.setAccountNumber("ecce");
        GymSystem.changeInfo(GymSystemCheck.checkAccountInfo(GymSystemCheck.accountNumber,"username"),"username","change","ecc");
    }

    /**
     * <p>test {@link GymSystem#operateLiveSession(String, String, String, String, String)}</p>
     * <p>test {@link GymSystem#operateLiveSession(String, String, String, String, String)}
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @Test
    void operateLiveSession() throws IOException {
        GymSystemCheck.setAccountNumber("ecce");
        GymSystem.operateLiveSession("trainer01","2021-05-03","11:00-12:00",GymSystemCheck.accountNumber,"cancel");
    }

    /**
     * <p>test {@link GymSystem#addRequest(String, String, String, String)}</p>
     * <p>test {@link GymSystem#addRequest(String, String, String, String)}
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @Test
    void addRequest() throws IOException{
        GymSystem.addRequest("trainer01","ecce","I want to be thinner","I'm good at running");
    }

    /**
     * <p>test {@link GymSystem#addIncome(String, String, String)}</p>
     * <p>test {@link GymSystem#addIncome(String, String, String)}
     * </p>
     * @author Yongfan Jin
     * @version 1.0
     */
    @Test
    void addIncome() throws IOException{
        GymSystem.addIncome("150","ecce","premier");
    }
}