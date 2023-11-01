package src.main.java.com.rp.sec04;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L02HandleAssignment {
    public static void main(String[] args) {

        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle(((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if (s.toLowerCase().equals("canada"))
                        synchronousSink.complete();
        })).subscribe(Util.subscriber());
    }
}
