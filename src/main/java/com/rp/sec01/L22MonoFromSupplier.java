package com.rp.sec01;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
public class L22MonoFromSupplier {
    public static void main(String[] args) {

        var list = List.of(1,2,3);
//        Mono.just(sum(list));

//        Mono.fromSupplier( () -> sum(list));
        Mono.fromSupplier( () -> sum(list))
                .subscribe(src.main.java.com.rp.courseUtil.Util.subscriber());
    }

    private static int sum(List<Integer> list) {
        log.info("Finding the sum of {}" ,list);
        long count = list.stream().mapToInt(value -> value).count();
        log.info("Count is : {}", count);
        return (int) count;
    }
}
