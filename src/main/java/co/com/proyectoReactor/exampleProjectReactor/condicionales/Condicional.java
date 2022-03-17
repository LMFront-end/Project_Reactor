package co.com.proyectoReactor.exampleProjectReactor.condicionales;

import co.com.proyectoReactor.exampleProjectReactor.ExampleProjectReactorApplication;
import co.com.proyectoReactor.exampleProjectReactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Condicional {

    private static final Logger log = LoggerFactory.getLogger(ExampleProjectReactorApplication.class);

    // para no devolver una salida vacia
    public void defaultEmpty(){
        // si tiene parametros la linea 19 no se ejecuta
        Mono.just(new Persona(1, "Lina", "Maria", 23))
        //Mono.empty() // Flux.empty()
                // salida por defecto
                .defaultIfEmpty(new Persona(0, "Default", "hola", 99))
                .subscribe(x -> log.info(x.toString()));
    }

    public void takeUntil(){

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));
        personas1.add(new Persona(2, "Juan", "Montes", 25));

        Flux.fromIterable(personas1)
                .takeUntil(p -> p.getEdad() < 25)
                .subscribe(x -> log.info(x.toString()));
    }

    public void timeout() throws InterruptedException {

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));
        personas1.add(new Persona(2, "Juan", "Montes", 25));

        Flux.fromIterable(personas1)
                .delayElements(Duration.ofSeconds(3))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> log.info(x.toString()));

        Thread.sleep(10000);
    }
}
