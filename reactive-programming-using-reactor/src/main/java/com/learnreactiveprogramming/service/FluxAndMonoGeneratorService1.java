package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService1 {

    public Flux<String> namesFlux() {
       return Flux.fromIterable(List.of("alex","ben","chloe")).log();
    }

    public Flux<String> namesFluxmap()   //To perform the maping operation in the data , This is comparable to straming api
       {
        return Flux.fromIterable(List.of("alex","ben","chloe"))
                .map(String::toUpperCase)
              //  .map((s) -> s.toUpperCase())
                .log();
    }

    public Mono<String> namesMono(){
        return Mono.just("alex").log();
    }

    public Flux<String> namesFluximmutable()   //To show that the reactive streams are immutable whereas the strems are mutable
    {
        var namesimmmutable= Flux.fromIterable(List.of("alex","ben","chloe"));
        namesimmmutable.map(String::toUpperCase);
        return namesimmmutable.log();


    }

    public static void main(String [] args){
        FluxAndMonoGeneratorService1 fluxAndMonoGeneratorService1 = new FluxAndMonoGeneratorService1();

        fluxAndMonoGeneratorService1.namesFlux().subscribe(name -> {
            System.out.println("Flux Name is : "+ name);
        });

        fluxAndMonoGeneratorService1.namesMono().subscribe(name -> {
            System.out.println("Mono Names is : "+ name);
        });

        fluxAndMonoGeneratorService1.namesFluxmap().subscribe(name -> {
            System.out.println("Flux Name Uppercase is : "+ name);
        });

        fluxAndMonoGeneratorService1.namesFluximmutable().subscribe(name -> {
            System.out.println("Flux Name immutable is : "+ name);
        });
    }
}
