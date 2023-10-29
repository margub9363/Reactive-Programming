package src.main.java.com.rp.sec02;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L10FluxToMono {
    public static void main(String[] args) {
        Flux.range(1,10)
                .filter( i -> i>10)
                .next()
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
