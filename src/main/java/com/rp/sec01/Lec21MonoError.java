package com.rp.sec01;

import reactor.core.publisher.Mono;
import src.main.java.com.rp.courseUtil.Util;

public class Lec21MonoError {
    public static void main(String[] args) {
        getUserName(21)
                .subscribe(
//                        s -> System.out.println(s)
                        s -> System.out.println(s),
                        throwable -> System.out.println("Some Exception Occured: " + throwable.getMessage() )
                );
        System.out.println("Smoothly terminating application....");
    }

    public static Mono<String> getUserName(int userID){
//        1
        if(userID == 1){
            return Mono.just(Util.FAKER.name().fullName());
        } else if (userID ==2) {
            return Mono.empty();
        }
        else return Mono.error(new RuntimeException("Not in the Allowed Range"));
    }


}
