package sec14;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class Sec02MonoEmptyErrorTest {

    Mono<String> getUserName(int userId) {
        return switch (userId) {
            case 1 -> Mono.just("sam");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("invalid input"));
        };
    }

    @Test
    public void userTest() {
        StepVerifier.create(getUserName(1))
                .expectNext("sam")
                .expectComplete()
                .verify();
    }

    @Test
    public void empty() {
        StepVerifier.create(getUserName(2))
                .expectNext()
                .expectComplete()
                .verify();
    }

    @Test
    public void errorTest1() {
        StepVerifier.create(getUserName(3))
                .expectError()
                .verify();
    }

    @Test
    public void errorTest2() {
        StepVerifier.create(getUserName(3))
                .expectError(RuntimeException.class)
                .verify();
    }

    @Test
    public void errorTest3() {
        StepVerifier.create(getUserName(3))
                .expectErrorMessage("invalid input")
                .verify();
    }

    @Test
    public void errorTest4() {
        StepVerifier.create(getUserName(3))
                .consumeErrorWith(ex -> {
                    Assertions.assertEquals(RuntimeException.class, ex.getClass());
                    Assertions.assertEquals("invalid input", ex.getMessage());

                })
                .verify();
    }

}
