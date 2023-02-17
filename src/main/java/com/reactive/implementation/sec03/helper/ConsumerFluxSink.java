package com.reactive.implementation.sec03.helper;

import com.reactive.implementation.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class ConsumerFluxSink implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

//    public ConsumerFluxSink(FluxSink<String> stringFluxSink) {
//        this.fluxSink = stringFluxSink;
//    }

    public void producer() {
        String name = Util.faker().name().fullName();
        String threadName = Thread.currentThread().getName();
        this.fluxSink.next(threadName +" : "+name);
    }

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }
}
