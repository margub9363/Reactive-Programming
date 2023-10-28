package src.main.java.com.rp.sec01;

import reactor.core.publisher.Mono;
import src.main.java.com.rp.courseUtil.Util;

public class L08MonoFromRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("");
        };

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process is done. Sending Emails...");
                        });
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Time Consuming Process");
        };
    }
}
