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


       Runnable runnable = nameProducer::produce;

       for (int i=0; i<10; i++) {
           new Thread(runnable).start();
       }

       Util.sleepSeconds(2);

    }
}
