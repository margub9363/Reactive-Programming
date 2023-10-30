package src.main.java.com.rp.sec03;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L07FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(
                () -> 1,
                (counter,sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if(counter >= 10 || country.toLowerCase().equals("canada"))
                        sink.complete();
                    return counter + 1;
                }
        ).subscribe(Util.subscriber());
    }
}
