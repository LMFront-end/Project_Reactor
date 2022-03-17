package co.com.proyectoReactor.exampleProjectReactor.creacion;

import co.com.proyectoReactor.exampleProjectReactor.ExampleProjectReactorApplication;
import co.com.proyectoReactor.exampleProjectReactor.model.Persona;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creacion {

    private static final Logger log = LoggerFactory.getLogger(ExampleProjectReactorApplication.class);

    public void justFrom(){
        Mono.just(new Persona(1, "Jose", "Guerrero", 74));
        //Flux.fromIterable(coleccion);
        //Observable.just(item);
    }

    // para expresar flujos vacios
    public void empty(){
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    // crear un flujo de datos apartir de numeros
    public void range(){
        Flux.range(0, 3)
                .doOnNext(i -> log.info("i: " + i))
                .subscribe();
    }

    // repetir flujo de datos
    public void repeat(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Lina", "Guerrero", 23));
        personas.add(new Persona(2, "Juan", "Montes", 27));

        Flux.fromIterable(personas)
                .repeat(3)
                .subscribe(p -> log.info(p.toString()));
    }

}
