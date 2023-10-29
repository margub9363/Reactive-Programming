package src.main.java.com.rp.sec02;

import src.main.java.com.rp.courseUtil.Util;
import src.main.java.com.rp.sec02.helper.NameGenerator;

import java.util.List;

public class L07FluxVsList {
    public static void main(String[] args) {
//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);

        NameGenerator.getNames(5)
                .subscribe(Util.onNext());
    }
}
