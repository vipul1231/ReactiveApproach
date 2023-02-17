package com.reactive.implementation.sec03;

import com.reactive.implementation.Util;
import reactor.core.publisher.Flux;

public class FluxTake {

    public static void main(String[] args) {
        Flux.range(1, 10).log().filter( i -> i % 2 ==0).log()
                .take(4)
                .log().subscribe(Util.subscriber());
    }
}
