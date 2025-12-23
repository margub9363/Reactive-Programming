package src.main.java.com.rp.sec02;

import lombok.extern.slf4j.Slf4j;
import src.main.java.com.rp.courseUtil.Util;
import src.main.java.com.rp.sec02.helper.NameGenerator;

import java.util.List;

@Slf4j
public class L07FluxVsList {
    public static void main(String[] args) {
        List<String> names = NameGenerator.getNameList(5);
        log.info(names.toString());

        NameGenerator.getNames(5)
                .subscribe(Util.onNext());
    }
}
