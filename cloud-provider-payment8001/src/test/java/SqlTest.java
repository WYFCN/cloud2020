import com.atguigu.springcloud.Dao.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SqlTest {

    @Autowired
    PaymentMapper paymentMapper;
    @Test
    public void test(){
        List<Payment> payments = paymentMapper.getPayments();
        System.out.println(payments);
    }
}