package src.main.java.com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {
//        publisher
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);

//        here we are using a subscribe method where in along with subscribe it will perform an action
        mono.subscribe( i -> System.out.println("Received : " + i));
    }
}
