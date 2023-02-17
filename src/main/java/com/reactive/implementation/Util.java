package com.reactive.implementation;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.Objects;
import java.util.function.Consumer;

public class Util {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received: "+o);
    }
    public static Consumer<Throwable> onError() {
        return o -> System.out.println("ERROR: "+o.getMessage());
    }
    public static Runnable onComplete() {
        return () -> System.out.println("Completed");
    }

    public static Faker faker() {
        return FAKER;
    }


    public static Subscriber<Object> subscriber(String name) {
        return new DefaultSubscriber(name);
    }

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber("DEFAULT");
    }
}
