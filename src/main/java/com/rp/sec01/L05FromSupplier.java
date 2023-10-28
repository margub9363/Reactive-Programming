package src.main.java.com.rp.sec01;

import reactor.core.publisher.Mono;
import src.main.java.com.rp.courseUtil.Util;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class L05FromSupplier {
    public static void main(String[] args) {

        /*
//        use Just only when you have data already
//        Mono<String> mono = Mono.just(getName());
         */
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext()
        );

//        through Callable
        Callable<String> stringCallable = () -> getName();
        Mono<String> monoForCallable = Mono.fromSupplier(stringSupplier);
        monoForCallable.subscribe(
                Util.onNext()
        );
    }

    public static String getName(){
        System.out.println("Generating Name...");
        return Util.FAKER.name().fullName();
    }

}
