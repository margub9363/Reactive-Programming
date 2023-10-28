package src.main.java.com.rp.sec01;

import reactor.core.publisher.Mono;
import src.main.java.com.rp.courseUtil.Util;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        userRepository(20)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    public static Mono<String> userRepository(int userID){
//        1
        if(userID == 1){
            return Mono.just(Util.FAKER.name().fullName());
        } else if (userID ==2) {
            return Mono.empty();
        }
        else return Mono.error(new RuntimeException("Not in the Allowed Range"));
    }


}
