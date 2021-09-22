import com.quan.MySchool;

import com.quan.SchoolAutoConfiguration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeWork10 {
    @Autowired
    private MySchool mySchool;

    @Test
    public void Test(){
        System.out.printf(mySchool.toString());
    }
}
