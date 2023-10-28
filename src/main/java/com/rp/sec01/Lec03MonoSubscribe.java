package src.main.java.com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {

//        publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                        .map(length -> length / 0);

//        1
//        here we are using a subscribe method where in along with subscribe it will not perform any action
//        mono.subscribe();

//        2
        mono.subscribe( item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );

    }
}
