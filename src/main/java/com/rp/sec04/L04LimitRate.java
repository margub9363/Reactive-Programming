package src.main.java.com.rp.sec04;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L04LimitRate {
    public static void main(String[] args) {
        Flux.range(1,1000)
                .log()
                .limitRate(100)
                .subscribe(Util.subscriber());
    }
}
