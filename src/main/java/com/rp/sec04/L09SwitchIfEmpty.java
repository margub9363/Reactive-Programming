package src.main.java.com.rp.sec04;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L09SwitchIfEmpty {
    public static void main(String[] args) {

        getOrderNumbers()
                .filter(integer -> integer > 10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }
    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1,10);
    }

    private static Flux<Integer> fallback() {
        return Flux.range(20,5);
    }
}
