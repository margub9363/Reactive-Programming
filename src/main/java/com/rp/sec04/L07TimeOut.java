package src.main.java.com.rp.sec04;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.time.Duration;

public class L07TimeOut {
    public static void main(String[] args) {

        getOrderNumber()
                .timeout(Duration.ofSeconds(2),fallback())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<Integer> getOrderNumber() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100,10)
                .delayElements(Duration.ofMillis(200));
    }
}
