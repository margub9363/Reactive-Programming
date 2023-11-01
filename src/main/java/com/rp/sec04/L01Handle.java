package src.main.java.com.rp.sec04;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L01Handle {
    public static void main(String[] args) {

//        handle = filter + map

        Flux.range(1,20)
                .handle((integer, synchronousSink) -> {
                    if (integer==7)
                        synchronousSink.complete();
                    else synchronousSink.next(integer);
                }).subscribe(Util.subscriber());

    }

}
