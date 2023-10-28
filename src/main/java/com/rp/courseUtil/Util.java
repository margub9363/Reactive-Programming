package src.main.java.com.rp.courseUtil;

import java.util.function.Consumer;

public class Util {
    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received :" + o);
    }

    public static Consumer<Object> onError(){
        return e -> System.out.println("ERROR :" + e);
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
    }
}
