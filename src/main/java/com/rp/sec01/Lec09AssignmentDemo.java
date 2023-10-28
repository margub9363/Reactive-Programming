package src.main.java.com.rp.sec01;

import src.main.java.com.rp.courseUtil.Util;
import src.main.java.com.rp.sec01.assignment.FileService;

import java.io.File;

public class Lec09AssignmentDemo {
    public static void main(String[] args) {
        FileService.read("file02.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.write("file03.txt", "This is file3")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
