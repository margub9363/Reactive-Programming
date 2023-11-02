package src.main.java.com.rp.sec04;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.time.Duration;

public class L06Delay {
    public static void main(String[] args) {
        Flux.range(1,10)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
