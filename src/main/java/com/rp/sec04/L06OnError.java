package src.main.java.com.rp.sec04;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import src.main.java.com.rp.courseUtil.Util;

public class L06OnError {
    public static void main(String[] args) {

        Flux.range(1,10)
                .log()
                .map(i -> i / (5-i))
//                .onErrorReturn(-1)
//                .onErrorResume(e -> fallBack())
                .onErrorContinue((err,obj) -> {})
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallBack() {
        return Mono.fromSupplier( () -> Util.faker().random().nextInt(100,200));
    }
}
