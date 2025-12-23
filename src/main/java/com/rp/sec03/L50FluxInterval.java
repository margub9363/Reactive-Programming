package com.rp.sec03;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class L50FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(500))
                .map( i -> src.main.java.com.rp.courseUtil.Util.faker().name().firstName())
                .subscribe(src.main.java.com.rp.courseUtil.Util.subscriber());

        src.main.java.com.rp.courseUtil.Util.sleepSeconds(2); // << we are blocking the main thread otherwise
//        it will exit immediately and we wont see any result.
    }
}
