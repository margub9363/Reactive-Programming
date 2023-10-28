package src.main.java.com.rp.sec02;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.util.Arrays;
import java.util.List;

public class L03FluxFromArrayList {
    public static void main(String[] args) {

        /*
        List<String> strings = Arrays.asList("a", "b", "c");
        Flux.fromIterable(strings)
                .subscribe(
                        Util.onNext()
                );
         */

        Integer[] arr = {2,5,7,8};
        Flux.fromArray(arr).subscribe(
                Util.onNext()
        );
    }
}
