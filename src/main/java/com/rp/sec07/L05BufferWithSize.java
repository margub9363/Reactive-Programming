package src.main.java.com.rp.sec07;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import src.main.java.com.rp.courseUtil.Util;

public class L05BufferWithSize {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small","16");

        Flux.create(fluxSink -> {
            for (int i = 1 ; i < 201 && !fluxSink.isCancelled(); i++) {
                fluxSink.next(i);
                System.out.println("Pushed : " + i);
                Util.sleepMillis(1);
            }
            fluxSink.complete();
        })
                .onBackpressureBuffer(20, o -> System.out.println("Dropped : " + o))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                }).subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}

/*
Pushed : 15
Pushed : 16
Pushed : 17
null Received : 2
null Received : 3
null Received : 4
null Received : 5
null Received : 6
null Received : 7
null Received : 8
null Received : 9
null Received : 10
null Received : 11
null Received : 12
null Received : 13
null Received : 14
null Received : 15
null Received : 16
null ERROR : The receiver is overrun by more signals than expected (bounded queue...)
*/
