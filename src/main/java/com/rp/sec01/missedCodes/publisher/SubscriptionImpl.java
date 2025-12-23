package com.rp.sec01.missedCodes.publisher;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Slf4j
public class SubscriptionImpl implements Subscription {

    //    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);
    private final Subscriber< ? super String> subscriber;
    public static final int MAX_ITEMS = 10;
    private int count = 0;
    private final Faker faker;
    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }
    private boolean isCancelled;
    @Override
    public void request(long requested) {
        if (isCancelled){
            log.info("Request has already been cancelled");
            return;
        }
        log.info("subscriber has requested {} items", requested);
        if (requested > MAX_ITEMS) {
            this.subscriber.onError(new RuntimeException("validation failed"));
            this.isCancelled = true;
            return;
        }
        for (int i = 0; i < requested && count < MAX_ITEMS; i++) {
            count++;
            this.subscriber.onNext(this.faker.internet().emailAddress());
        }
        if (count==MAX_ITEMS) {
            log.info("no more data to produce");
            this.subscriber.onComplete();
            this.isCancelled=true;
        }
    }

    @Override
    public void cancel() {
        log.info("Subscriber has cancelled");
        this.isCancelled = true;
    }
}
