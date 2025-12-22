package com.rp.sec01;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import src.main.java.com.rp.courseUtil.Util;

@Slf4j
public class Lec03MonoSubscribe_1 {
    public static void main(String[] args) {

        var mono = Mono.just(100)
                .map( i-> i / 10);

        mono.subscribe(
                obj -> log.info("received {}", obj),
                throwable -> log.error("Some Exception occured" + throwable),
                () -> log.info("We have received data")
//                subscription -> subscription.request(1)
        );
    }
}
