package five;


import five.number.MaxNumberModule;
import five.number.RandomNumberModule;
import five.order.OrderService;
import five.order.PaymentService;
import five.user.UserRepository;
import five.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MainTest {
//    //5.1.
//    List<Integer> randomList;
//    @BeforeEach
//    void setUp(){
//        randomList = Arrays.asList(2,5,9,7,6,1);
//    }
//
//    @Test
//    void maxNumberModuleTest() {
//        MaxNumberModule maxNumberModule = new MaxNumberModule();
//
//        int maxValue = maxNumberModule.getMaxValue(randomList);
//
//        assertThat(maxValue).isEqualTo(9);
//    }
//
//    @Test
//    void randomNumberModuleTest() {
//        RandomNumberModule randomNumbers = new RandomNumberModule();
//
//        randomList = randomNumbers.getList(6);
//
//        assertThat(randomList.size()).isEqualTo(6);
//    }
//
//    @Test
//    void maxRandomTest() {
//        RandomNumberModule randomNumbers = new RandomNumberModule();
//        MaxNumberModule maxNumberModule = new MaxNumberModule();
//
//        randomList = randomNumbers.getList(6);
//        int maxValue = maxNumberModule.getMaxValue(randomList);
//
//        assertThat(Collections.max(randomList)).isEqualTo(maxValue);
//    }



    //5.2.
    @Test
    void userServiceTest() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String userName = userService.getUserName(5);

        assertThat(userName).isEqualTo("User 5");
    }
    //5.3.
    @Test
    void orderServiceTest() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("ord_15", 15000);

        assertTrue(result);
    }
}