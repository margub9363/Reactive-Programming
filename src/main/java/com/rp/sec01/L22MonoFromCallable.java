package com.rp.sec01;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class L22MonoFromCallable {
    public static void main(String[] args) {

        var list = List.of(1,2,3);
//        Mono.fromSupplier(() -> sum(list)) //<< sum is giving error
//                .subscribe(src.main.java.com.rp.courseUtil.Util.subscriber());
        Mono.fromCallable( () -> sum(list))
                .subscribe(src.main.java.com.rp.courseUtil.Util.subscriber());
    }

    private static int sum(List<Integer> list) throws InterruptedException {
        log.info("Finding the sum of {}" ,list);
        long count = list.stream().mapToInt(value -> value).count();
        log.info("Count is : {}", count);
        Thread.sleep(10000);
        return (int) count;
    }
}
