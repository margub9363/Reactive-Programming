package src.main.java.com.rp.sec07;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import src.main.java.com.rp.courseUtil.Util;

import java.util.ArrayList;

public class L02Drop_CapturingDroppedValue {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small","16");
        ArrayList<Object> list = new ArrayList<>();

        Flux.create(fluxSink -> {
            for (int i = 1 ; i < 201; i++) {
                fluxSink.next(i);
                System.out.println("Pushed : " + i);
                Util.sleepMillis(1);
            }
            fluxSink.complete();
        })
                .onBackpressureDrop(list::add)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                }).subscribe(Util.subscriber());

        Util.sleepSeconds(10);
        System.out.println(list); // will give me a list of values dropped
    }
}
