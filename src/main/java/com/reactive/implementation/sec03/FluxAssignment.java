package com.reactive.implementation.sec03;

import reactor.core.publisher.Flux;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FluxAssignment {

    private static final Path path = Paths.get("src/main/resources/");

    private static String readFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(path.resolve(fileName).toFile()))) {
            String line;
            while ((line = bf.readLine()) != null) {
               stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {

        Flux.generate(() -> 1, (counter, sink) -> {

        }, () -> {

        });
        System.out.println(readFile("File1.txt"));
    }

}
