package src.main.java.com.rp.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import src.main.java.com.rp.courseUtil.Util;

public class L03SubscribeOnMultipleItems {
    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create");
            for (int i = 0; i < 4; i++) {
                fluxSink.next(i);
                Util.sleepSeconds(4);
            }
            fluxSink.complete();
        }).doOnNext(i -> printThreadName("next " + i));

        flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v-> printThreadName("sub " + v));

            flux
                .subscribeOn(Schedulers.parallel())
                .subscribe(v-> printThreadName("sub " + v));


        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : "+ Thread.currentThread().getName());
    }

}
