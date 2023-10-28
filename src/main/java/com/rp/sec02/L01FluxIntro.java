package src.main.java.com.rp.sec02;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L01FluxIntro {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1,2,3,4,"a",Util.faker().name().fullName());
        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
