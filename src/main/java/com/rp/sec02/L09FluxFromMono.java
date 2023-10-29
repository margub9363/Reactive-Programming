package src.main.java.com.rp.sec02;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import src.main.java.com.rp.courseUtil.Util;

public class L09FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);

        flux.subscribe(Util.onNext());
    }
    private static void doSomething(Flux<String> flux) {

    }
}
