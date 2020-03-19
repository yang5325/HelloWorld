import com.laoyang.ssm.domain.Traveller;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
public class date {


    @Test
    public void main() {
        Date date = new Date();
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        System.out.println("date==" + date);
        System.out.println("dateStr==" + dateStr);
    }


    @Test
    public void traveller() {
        Traveller traveller = new Traveller();
        traveller.setCredentialsType(1);
        traveller.setTravellerType(1);
        System.out.println(traveller);
    }

    @Test
    public void 与() {
        int i = 16;
        int j = i >>> 2;
        System.out.println(i);
        System.out.println(j);
    }

    @Test
    public void 加密(){
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String encode = b.encode("123");
        System.out.println(encode);
    }


    @Test
    public void hashTable(){
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        hashMap.put("name","张三");
        hashMap.put("name","李四");
    }
}