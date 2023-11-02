package src.main.java.com.rp.sec04;

import reactor.core.publisher.Flux;
import src.main.java.com.rp.courseUtil.Util;
import src.main.java.com.rp.sec04.helper.Person;

import java.util.function.Function;

public class L11SwitchOnFirst {
    public static void main(String[] args) {
        getPerson()
                .switchOnFirst((signal, personFlux) -> {
                    System.out.println("Inside switchOnFirst");
                    return signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux);
                })
//                .transform(applyFilterMap())
                .subscribe(Util.subscriber());
    }

    public static Flux<Person> getPerson() {
        return Flux.range(1,20)
                .map( i -> new Person());
        }

        public static Function<Flux<Person>,Flux<Person>> applyFilterMap() {
        return flux -> flux
                .filter( p -> p.getAge()>10)
                .doOnNext(p-> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not Allowing : " + p));
        }
}
