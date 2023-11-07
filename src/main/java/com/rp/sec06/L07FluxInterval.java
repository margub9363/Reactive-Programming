package src.main.java.com.rp.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import src.main.java.com.rp.courseUtil.Util;

import java.time.Duration;

public class L07FluxInterval {
    public static void main(String[] args) {



        Flux.interval(Duration.ofSeconds(1))
                        .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : "+ Thread.currentThread().getName());
    }

}
