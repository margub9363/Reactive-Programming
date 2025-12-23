package src.main.java.com.rp.sec01;

import reactor.core.publisher.Mono;
import src.main.java.com.rp.courseUtil.Util;

public class L06SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        getName();
        getName().subscribe(Util.onNext());

    }

    private static Mono<String> getName() {
        System.out.println("Entered Get Name method");
        return Mono.fromSupplier( () -> {
            System.out.println("Generating Name..."); // this is not a time consuming operation so it dosent need subscription
            Util.sleepSeconds(2);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);

    }
}
