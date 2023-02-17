package com.reactive.implementation.sec03;

import com.reactive.implementation.Util;
import com.reactive.implementation.sec03.helper.ConsumerFluxSink;
import reactor.core.publisher.Flux;

public class FluxCreateRefactor {

    public static void main(String[] args) {
        ConsumerFluxSink consumerFluxSink = new ConsumerFluxSink();

        Flux.create(consumerFluxSink).subscribe(Util.subscriber());

        consumerFluxSink.producer();

        Runnable runnable = consumerFluxSink::producer;

        for (int i=0;i<10;i++) {
            new Thread(runnable).start();
        }

    }
}
