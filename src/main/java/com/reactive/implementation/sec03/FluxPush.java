package com.reactive.implementation.sec03;

import com.reactive.implementation.Util;
import com.reactive.implementation.sec03.helper.ConsumerFluxSink;
import reactor.core.publisher.Flux;

public class FluxPush {

    public static void main(String[] args) {
        ConsumerFluxSink consumerFluxSink = new ConsumerFluxSink();

        Flux.push(consumerFluxSink).subscribe(Util.subscriber());

        Runnable runnable = consumerFluxSink::producer;

        for (int i=0;i<10;i++) {
            new Thread(runnable).start();
        }
    }
}
