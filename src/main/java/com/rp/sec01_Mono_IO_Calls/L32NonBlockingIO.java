package com.rp.sec01_Mono_IO_Calls;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class L32NonBlockingIO {
    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        log.info("Starting");

        for (int i = 0; i < 100; i++) {
            client.getProductName(i)
                    .subscribe(src.main.java.com.rp.courseUtil.Util.subscriber());
        }
        src.main.java.com.rp.courseUtil.Util.sleepSeconds(2);

    }
}
