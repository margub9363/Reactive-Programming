package src.main.java.com.rp.sec05;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.time.Duration;
import java.util.stream.Stream;

public class L04_HotPublishAutoConnect {

    public static void main(String[] args) {
//        share = publish().ref()
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .autoConnect(0); // here we are saying that start the work even we have no subscriber. Also the behaviour of Auto connect is such that it will not emit any data once the activity is completed.

        Util.sleepSeconds(3);
        movieStream.subscribe(Util.subscriber("sam"));
        Util.sleepSeconds(10);

        System.out.println("Mike is about to join");

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
