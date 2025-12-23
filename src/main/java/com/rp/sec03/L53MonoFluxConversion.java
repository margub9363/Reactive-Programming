package com.rp.sec03;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class L53MonoFluxConversion {
    public static void main(String[] args) {
        var flux = Flux.range(1, 10);
        Mono.from(flux)
                .subscribe(src.main.java.com.rp.courseUtil.Util.subscriber());
    }

    private static void monoToFlux() {
        Mono<String> mono = getUserName(1);
        save(Flux.from(mono));
    }

    private static Mono<String> getUserName(int userId) {
        return switch (userId) {
            case 1 -> Mono.just("sam");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Invalid Input"));
        };
    }

    private static void save(Flux<String> flux) {
        flux.subscribe(src.main.java.com.rp.courseUtil.Util.subscriber());
    }
}
