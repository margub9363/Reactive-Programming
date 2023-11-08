package src.main.java.com.rp.sec07;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import src.main.java.com.rp.courseUtil.Util;

import java.util.ArrayList;

public class L02Latest {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small","16");

        Flux.create(fluxSink -> {
            for (int i = 1 ; i < 201; i++) {
                fluxSink.next(i);
                System.out.println("Pushed : " + i);
                Util.sleepMillis(1);
            }
            fluxSink.complete();
        })
                .onBackpressureLatest() // as the 75% of the queue of size -> o.75*16 -> 12 -> so after receiving 12th element , it will take the last value pusblihed
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                }).subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
/*
Pushed : 1
Pushed : 2
Pushed : 3
Pushed : 4
Pushed : 5
Pushed : 6
Pushed : 7
null Received : 1
Pushed : 8
Pushed : 9
Pushed : 10
Pushed : 11
null Received : 2
Pushed : 12 .........

Pushed : 66<----this will be latest after receiving 12th element
null Received : 12
Pushed : 67
Pushed : 68
Pushed : 69
Pushed : 70
Pushed : 71
Pushed : 72
Pushed : 73
Pushed : 74
null Received : 13
Pushed : 75
Pushed : 76
Pushed : 77
Pushed : 78
Pushed : 79
Pushed : 80
Pushed : 81
null Received : 14
Pushed : 82
Pushed : 83
Pushed : 84
Pushed : 85
null Received : 15
Pushed : 86
Pushed : 87
Pushed : 88
Pushed : 89
Pushed : 90
Pushed : 91
null Received : 16
Pushed : 92
Pushed : 93
Pushed : 94
Pushed : 95
null Received : 66
Pushed : 96

*/
