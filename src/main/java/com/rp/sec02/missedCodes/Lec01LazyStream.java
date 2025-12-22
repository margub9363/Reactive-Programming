package com.rp.sec02.missedCodes;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Lec01LazyStream {
    public static void main(String[] args) {
        Stream.of(1).peek(i -> log.info("received : {}", i)); // << this is not going to given any output because of Lazy
        Stream.of(1).peek(i -> log.info("received : {}", i)).collect(Collectors.toList()); // <<this gives output
    }
}
