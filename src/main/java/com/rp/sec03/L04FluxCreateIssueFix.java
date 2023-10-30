package src.main.java.com.rp.sec03;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L04FluxCreateIssueFix {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            do
            {
                country = Util.faker().country().name();
                System.out.println("Emitting : "+ country);
                fluxSink.next(country);
            } while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
