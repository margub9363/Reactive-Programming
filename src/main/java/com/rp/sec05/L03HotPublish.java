package src.main.java.com.rp.sec05;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.time.Duration;
import java.util.stream.Stream;

public class L03HotPublish {

    public static void main(String[] args) {
//        share = publish().ref()
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .publish().refCount(2); // -> it says that minimum you should have 1 subscriber to emit the data

        movieStream.subscribe(Util.subscriber("sam"));
        Util.sleepSeconds(5);
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
