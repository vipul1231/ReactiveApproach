package com.reactive.implementation.sec03;

import com.reactive.implementation.Util;
import reactor.core.publisher.Flux;

public class FluxCreateIssueFix {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {

            String country;

            do {
                country = Util.faker().country().name();
                System.out.println("Emmiting: "+country);
                fluxSink.next(country);
            }while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        }).log().take(4).log().subscribe(Util.subscriber());
    }
}
