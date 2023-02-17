package com.reactive.implementation.sec03;

import com.reactive.implementation.Util;
import reactor.core.publisher.Flux;

public class FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            fluxSink.next(1);
            fluxSink.next(2);
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
