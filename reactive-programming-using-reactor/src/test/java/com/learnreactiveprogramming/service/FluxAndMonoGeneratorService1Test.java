package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FluxAndMonoGeneratorService1Test {

    FluxAndMonoGeneratorService1 fluxAndMonoGeneratorService1 = new FluxAndMonoGeneratorService1();

    @Test
    void namesFlux(){
        //given

        //when
        var namesFlux = fluxAndMonoGeneratorService1.namesFlux();

        //then
        StepVerifier.create(namesFlux) //create automatically calls subscribe function
               // .expectNext("alex","ben","chloe") //passed test
               // .expectNext("ben","alex","chloe")  //failed test
              //  .expectNextCount(3)
                .expectNext("alex")
                .expectNextCount(2)
                .verifyComplete();

    }

    @Test
    void namesFluxmap(){
        //given
        //when
        var namesFlux = fluxAndMonoGeneratorService1.namesFluxmap();
        //then
        StepVerifier.create(namesFlux) //create automatically calls subscribe function
               // .expectNext("alex")
                .expectNext("ALEX")

                .verifyComplete();
    }

    @Test
    void namesimmutable(){
        var namesFlux =  fluxAndMonoGeneratorService1.namesFluximmutable();

        StepVerifier.create(namesFlux)
                .expectNext("ALEX")
                .expectNextCount(2)
                .verifyComplete();
    }
}
