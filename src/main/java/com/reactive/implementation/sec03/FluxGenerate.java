package com.reactive.implementation.sec03;

import com.reactive.implementation.Util;
import reactor.core.publisher.Flux;

public class FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            System.out.println("Emitting...");
            String country = Util.faker().country().name();
           synchronousSink.next(country);
//            synchronousSink.next(Util.faker().country().name());
            if (country.equalsIgnoreCase("canada")) {
                synchronousSink.complete();
            }
        }).log().subscribe(Util.subscriber());
    }
}
