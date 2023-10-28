package src.main.java.com.rp.sec01;

import reactor.core.publisher.Mono;
import src.main.java.com.rp.courseUtil.Util;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {

//        publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                        .map(length -> length / 1);

//        1
//        here we are using a subscribe method where in along with subscribe it will not perform any action
//        mono.subscribe();

//        2
        mono.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }
}
