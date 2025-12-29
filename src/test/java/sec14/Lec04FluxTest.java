package sec14;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec04FluxTest {

    private Flux<Integer> getItems() {
        return Flux.range(1,50);
    }

    private Flux<Integer> getRandomItems() {
        return Flux.range(1,50)
                .map( i -> src.main.java.com.rp.courseUtil.Util.faker().random().nextInt(1,100));
    }

    @Test
    public void rampTest1() {
        StepVerifier.create(getItems())
                .expectNext(1,2,3)
                .expectNextCount(47)
                .expectComplete()
                .verify();
    }

    @Test
    public void rampTest2() {
        StepVerifier.create(getItems())
                .expectNext(1,2,3)
                .expectNextCount(22)
                .expectNext(26,27,28)
                .expectNextCount(22)
                .expectComplete()
                .verify();
    }

    @Test
    public void rampTest3() {
        StepVerifier.create(getRandomItems())
                .expectNextMatches( i -> i> 0 && i < 101)
                .expectNextCount(49)
                .expectComplete()
                .verify();
    }

    @Test
    public void rampTest4() {
        StepVerifier.create(getRandomItems())
                .thenConsumeWhile( i -> i> 0 && i < 101)
                .expectComplete()
                .verify();
    }


}
