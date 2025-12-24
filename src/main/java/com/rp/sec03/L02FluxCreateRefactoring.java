package src.main.java.com.rp.sec03;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;
import src.main.java.com.rp.sec03.helper.NameProducer;

public class L02FluxCreateRefactoring {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(
                        Util.subscriber());
        /*
        nameProducer.accept(fluxSink) call hota hai tum ye kaise kah sakte ho?

        Short answer (pehle clear statement)
        Reactor ka contract hai:
        Flux.create(Consumer<FluxSink<T>>) me jo Consumer pass hota hai,
        uska accept() method subscribe time par call hota hai.
        Ye guess nahi hai — design by contract hai.

        */

       Runnable runnable = nameProducer::produce;

       for (int i=0; i<10; i++) {
           new Thread(runnable).start();
       }

       Util.sleepSeconds(2);

    }
}
