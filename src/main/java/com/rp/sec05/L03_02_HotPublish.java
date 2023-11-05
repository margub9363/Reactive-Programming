package src.main.java.com.rp.sec05;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.time.Duration;
import java.util.stream.Stream;

public class L03_02_HotPublish {

    public static void main(String[] args) {
//        share = publish().ref()
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(1); // -> it says that minimum you should have 1 subscriber to emit the data
//        Also the other behaviour of the refCount(1) method is that , till the work is in progress and someone joins in b/w the the item will be delivered to him from there and once the work is completed then the subscriber list will be considered empty. If in b/w some one else subscribe then he will be treated as the 1st subscriber and item will be delivered from start.

        movieStream.subscribe(Util.subscriber("sam"));
        Util.sleepSeconds(10);
        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(60);
    }

//    movie theatre
    private static Stream<String > getMovie() {
        System.out.println("Got the Movie Streaming Request");
        return Stream.of(
                "Scene1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }

}
