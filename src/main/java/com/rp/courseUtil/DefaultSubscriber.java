package src.main.java.com.rp.courseUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.Flow;

public class DefaultSubscriber implements Subscriber<Object> {

    private String name ="" + "-";

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    public DefaultSubscriber() {
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object item) {
        System.out.println(name + " Received : " +item);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + " ERROR : " +throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + " Completed");
    }

}
