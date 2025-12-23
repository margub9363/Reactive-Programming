package src.main.java.com.rp.sec02.helper;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNameList(int count) {
        List<String > list = new ArrayList<>(count);
        for (int i = 0; i<count; i++){
            list.add(getNames());
        }
        return list;
    }

    private static String getNames(){
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }

    public static Flux<String > getNames(int count) {
        return Flux.range(0,count).map(i -> getNames());
    }
}
