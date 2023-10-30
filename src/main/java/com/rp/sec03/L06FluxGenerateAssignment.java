package src.main.java.com.rp.sec03;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L06FluxGenerateAssignment {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("Emitting " + country);
            synchronousSink.next(country);
            if(country.toLowerCase().equals("canada"))
                synchronousSink.complete();
        })
                .subscribe(Util.subscriber());
    }
}
