package src.main.java.com.rp.sec02;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.util.Objects;
import java.util.function.Consumer;

public class L05FluxRange {
    public static void main(String[] args) {
       /* Flux.range(3,10)
                .subscribe(
                        Util.onNext()
                );*/
        Flux.range(1,5)
                .log()
                .map( i -> Util.faker().name().fullName())
                .subscribe(
                Util.onNext()
        );
    }
}
