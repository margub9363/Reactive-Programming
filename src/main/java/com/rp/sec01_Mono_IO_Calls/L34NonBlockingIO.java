package com.rp.sec01_Mono_IO_Calls;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class L34NonBlockingIO {
    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        log.info("starting");

        for (int i = 0; i < 10; i++) {
            var name = client.getProductName(i)
                    .block();
            log.info(name);
        }

    }
}
