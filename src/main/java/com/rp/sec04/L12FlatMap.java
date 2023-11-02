package src.main.java.com.rp.sec04;

import src.main.java.com.rp.courseUtil.Util;
import src.main.java.com.rp.sec04.helper.OrderService;
import src.main.java.com.rp.sec04.helper.User;
import src.main.java.com.rp.sec04.helper.UserService;

public class L12FlatMap {
    public static void main(String[] args) {

        UserService.getUsers()
//                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .concatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }

}
