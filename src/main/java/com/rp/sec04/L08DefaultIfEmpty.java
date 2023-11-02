package src.main.java.com.rp.sec04;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L08DefaultIfEmpty {
    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i>10)
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1,10
        );
    }
}
