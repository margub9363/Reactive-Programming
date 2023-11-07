package src.main.java.com.rp.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import src.main.java.com.rp.courseUtil.Util;

public class L06Parallel {
    public static void main(String[] args) {



        Flux.range(1,10)
                .parallel(5)
                .runOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("next " + i))
                        .subscribe(v -> printThreadName("sub " + v));



        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : "+ Thread.currentThread().getName());
    }

}
