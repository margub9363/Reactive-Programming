package src.main.java.com.rp.sec03;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L03FluxTake {
    public static void main(String[] args) {
        Flux.range(1,10)
                .log()
                .take(3) // here after the 3rd request subscription will be cancelled and since there is no subscriber no data will be emitted afterwords.
                .log()
                .subscribe(Util.subscriber());
    }
}
