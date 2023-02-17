package com.reactive.implementation.sec03;

import com.reactive.implementation.Util;
import reactor.core.publisher.Flux;

public class FluxCreateDemo {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {

            String country;

            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            }while (!country.equalsIgnoreCase("canada"));
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }

}
