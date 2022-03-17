package co.com.proyectoReactor.exampleProjectReactor.error;

import co.com.proyectoReactor.exampleProjectReactor.ExampleProjectReactorApplication;
import co.com.proyectoReactor.exampleProjectReactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class ErrorOp {

    private static final Logger log = LoggerFactory.getLogger(ExampleProjectReactorApplication.class);

    public void retry(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Pedro", "Guerrero", 23));
        personas.add(new Persona(2, "Camila", "Montes", 27));

        Flux.fromIterable(personas)
                // simulación de un error
                .concatWith(Flux.error(new RuntimeException("Un error")))
                .retry(1)
                .doOnNext(x -> log.info(x.toString()))
                .subscribe();

    }

    public void errorReturn(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Pedro", "Guerrero", 23));
        personas.add(new Persona(2, "Camila", "Montes", 27));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("Un error")))
                .onErrorReturn(new Persona(0, "xyz", "cdf", 99))
                .subscribe(x -> log.info(x.toString()));
    }


    public void errorResume(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Pedro", "Guerrero", 23));
        personas.add(new Persona(2, "Camila", "Montes", 27));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("Un error")))
                .onErrorResume(e -> Mono.just(new Persona(0, "xyz", "cdf", 99)))
                .subscribe(x -> log.info(x.toString()));
    }


    public void errorMap(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Pedro", "Guerrero", 23));
        personas.add(new Persona(2, "Camila", "Montes", 27));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("Un error")))
                .onErrorMap(e -> new InstantiationException(e.getMessage()))
                .subscribe(x -> log.info(x.toString()));
    }
}
