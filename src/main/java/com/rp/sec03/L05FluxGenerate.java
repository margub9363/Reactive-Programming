package src.main.java.com.rp.sec03;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    System.out.println("Emitting");
            synchronousSink.next(Util.faker().name().name()); // 1
        })
                .take(2)
                .subscribe(Util.subscriber());
    }
}
