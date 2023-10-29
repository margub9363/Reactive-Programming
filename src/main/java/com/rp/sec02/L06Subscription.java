package src.main.java.com.rp.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.util.concurrent.atomic.AtomicReference;

public class L06Subscription {
    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub : " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("OnNext : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("OnError : " +throwable.getMessage() );
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("OnComplete");
                    }
                });
        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("Going To  Cancel");
        atomicReference.get().cancel();
        Util.sleepSeconds(3);
        atomicReference.get().request(4); //once you have cancelled you will not get anymore item even if you request
    }
}
