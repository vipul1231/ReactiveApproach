package com.reactive.implementation.sec03;

import com.github.javafaker.Faker;
import com.reactive.implementation.Util;
import reactor.core.publisher.Flux;

public class FluxGenerateCounter {

    public static void main(String[] args) {
        Flux.generate(() -> 1, (counter, sink) -> {
            String country = Faker.instance().country().name();
            sink.next(counter);
            if (counter >=10 || country.equalsIgnoreCase("canada")) {
                sink.complete();
            }
            return  counter + 1;
        }).take(4).subscribe(Util.subscriber());

    }
}
