package com.rp.sec03;

import com.rp.sec03.client.ExternalServiceClient;

public class L49NonBlockingStreamingMessages {
    public static void main(String[] args) {
        var client = new ExternalServiceClient();
        client.getNames()
                .subscribe(src.main.java.com.rp.courseUtil.Util.subscriber("sub1"));
        client.getNames()
                .subscribe(src.main.java.com.rp.courseUtil.Util.subscriber("sub2"));

        src.main.java.com.rp.courseUtil.Util.sleepSeconds(6);
    }
}
