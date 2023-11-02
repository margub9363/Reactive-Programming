package src.main.java.com.rp.sec04;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

public class L03DoCallBack {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            System.out.println("inside create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
//            fluxSink.error(new RuntimeException("oops"));
            System.out.println("--completed--");
        })
                .doOnComplete( () -> System.out.println("doOnComplete"))
                .doFirst( () -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext : " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 1 "+ s))
                .doOnRequest( l -> System.out.println("doOnRequest  : "+ l))
                .doFirst( () -> System.out.println("doFirst 2"))
                .doOnError( err -> System.out.println("doOnError : " + err.getMessage()))
                .doOnTerminate( () -> System.out.println("doOnTerminate"))
                .doOnCancel( () -> System.out.println("doOnCancel"))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 2 "+ s))
                .doFinally(signal -> System.out.println("doFinally : " + signal))
                .doFirst( () -> System.out.println("doFirst 3"))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : "+ o))
//                .take(2)
                .subscribe(Util.subscriber());
    }
}
