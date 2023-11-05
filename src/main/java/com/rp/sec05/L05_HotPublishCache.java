package src.main.java.com.rp.sec05;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.time.Duration;
import java.util.stream.Stream;

public class L05_HotPublishCache {

    public static void main(String[] args) {

//        cache() = publish().replay()
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .cache(2); // Here we are saying that cache only the last two values. i.e 6&7. FYI-> It can cache upto maximum integer value


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
