package src.main.java.com.rp.sec02;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.util.List;
import java.util.stream.Stream;

public class L04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> stream = list.stream();
//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);  you cannot use the same stream again
        Flux<Integer> integerFlux = Flux.fromStream(stream);
        integerFlux
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
        integerFlux // here we will get an error because we are trying to have multiple subscribers for the same stream
//                correction : Error is there because same stream cannot be consumed again, but note same flux can
//                have multiple subscribers.
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
        /*Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream());
        integerFlux
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
        integerFlux // here we will not get any error because we are trying to create new stream
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );*/
    }
}
