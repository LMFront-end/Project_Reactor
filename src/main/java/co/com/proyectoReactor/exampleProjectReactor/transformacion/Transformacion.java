package co.com.proyectoReactor.exampleProjectReactor.transformacion;

import co.com.proyectoReactor.exampleProjectReactor.ExampleProjectReactorApplication;
import co.com.proyectoReactor.exampleProjectReactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformacion {

    private static final Logger log = LoggerFactory.getLogger(ExampleProjectReactorApplication.class);

    //map
    public void map(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Lina", "Guerrero", 23));
        personas.add(new Persona(2, "Juan", "Montes", 27));
        personas.add(new Persona(3, "Santiago", "Vlad", 25));
        personas.add(new Persona(4, "Mateo", "Vlad", 24));

        Flux.fromIterable(personas)
                .map(p -> {
                    p.setEdad(p.getEdad() +2);
                    return p;
                })
                .subscribe(p -> log.info(p.toString()));
    }

    public void funcion(){
        Flux<Integer> fx = Flux.range(0, 10);

        Flux<Integer> fx2 = fx.map( x -> x + 10);

        fx2.subscribe(x -> log.info("x : " + x));
    }

    public void flapMap(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Lina", "Guerrero", 23));
        personas.add(new Persona(2, "Juan", "Montes", 27));
        personas.add(new Persona(3, "Santiago", "Vlad", 25));
        personas.add(new Persona(4, "Mateo", "Vlad", 24));


        Flux.fromIterable(personas)
                // el flapMap pide como retorno otro flujo de datos
                .flatMap(p -> {
                    p.setEdad(p.getEdad() + 10);
                    return Mono.just(p);

                }).subscribe(p -> log.info(p.toString()));
    }


    public void groupBy(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Lina", "Guerrero", 23));
        personas.add(new Persona(2, "Juan", "Montes", 27));
        personas.add(new Persona(3, "Santiago", "Vlad", 25));
        personas.add(new Persona(4, "Mateo", "Vlad", 24));

        Flux.fromIterable(personas)
                // agrupar en diferentes flux
                .groupBy(Persona::getIdPersona)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> log.info(x.toString()));
    }

}
