package src.main.java.com.rp.sec02;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L02MultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);
        integerFlux.subscribe(
                i -> System.out.println("Sub 1 : "+i)
        );

        integerFlux.subscribe(
                i -> System.out.println("Sub 2 : "+i)
        );
        Flux<Integer> oddFlux = integerFlux.filter(i -> i % 2 != 0);

//        Subscriber3 looking only for odd numbers
        oddFlux.subscribe(
                integer -> System.out.println("Sub 3 : "+integer)
        );

    }
}
