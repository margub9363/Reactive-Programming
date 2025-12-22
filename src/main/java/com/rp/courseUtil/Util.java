package src.main.java.com.rp.courseUtil;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class Util {

    public static final Faker FAKER= Faker.instance();
    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received :" + o);
    }

    public static Consumer<Object> onError(){
        return e -> System.out.println("ERROR :" + e);
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
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
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name) {
        return new DefaultSubscriber(name);
    }

//    public static void main(String[] args) {
//        Mono<Integer> mono = Mono.just(1);
//        mono.subscribe(subscriber());
//        mono.subscribe(subscriber("aaaa"));
//    }
}
