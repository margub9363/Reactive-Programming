package src.main.java.com.rp.sec01;

import reactor.core.publisher.Mono;
import src.main.java.com.rp.courseUtil.Util;

public class L05FromSupplier {
    public static void main(String[] args) {

        /*
//        use Just only when you have data already
//        Mono<String> mono = Mono.just(getName());
         */
        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(
                Util.onNext()
        );
    }

    public static String getName(){
        System.out.println("Generating Name...");
        return Util.FAKER.name().fullName();
    }

}
