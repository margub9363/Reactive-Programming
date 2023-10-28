package src.main.java.com.rp.sec01;


import com.github.javafaker.Faker;

import java.util.function.Function;

public class FakerDemo {
    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            System.out.println(Faker.instance().country().currency());

        }
    }
}
