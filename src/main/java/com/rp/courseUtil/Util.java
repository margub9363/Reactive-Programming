package src.main.java.com.rp.courseUtil;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

@Slf4j
public class Util {

    public static final Faker FAKER= Faker.instance();
    public static Consumer<Object> onNext(){
        return o -> log.info("Received :" + o);
    }

    public static Consumer<Object> onError(){
        return e -> log.info("ERROR :" + e);
    }

    public static Runnable onComplete(){
        return () -> log.info("Completed");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleepSeconds(int seconds) {
        sleepMillis(seconds*1000);
    }

    public static void sleepMillis(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Subscriber<Object> subscriber() {
        return new src.main.java.com.rp.courseUtil.DefaultSubscriber("");
    }

    public static Subscriber<Object> subscriber(String name) {
        return new src.main.java.com.rp.courseUtil.DefaultSubscriber(name);
    }

//    public static void main(String[] args) {
//        Mono<Integer> mono = Mono.just(1);
//        mono.subscribe(subscriber());
//        mono.subscribe(subscriber("aaaa"));
//    }
}
