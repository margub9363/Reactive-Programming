package src.main.java.com.rp.sec03;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L01FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
           do
            {
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while (!country.toLowerCase().equals("canada"));
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
