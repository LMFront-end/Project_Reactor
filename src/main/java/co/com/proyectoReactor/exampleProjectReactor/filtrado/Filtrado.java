package co.com.proyectoReactor.exampleProjectReactor.filtrado;

import co.com.proyectoReactor.exampleProjectReactor.ExampleProjectReactorApplication;
import co.com.proyectoReactor.exampleProjectReactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtrado {

    private static final Logger log = LoggerFactory.getLogger(ExampleProjectReactorApplication.class);


    public void filter(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Lina", "Guerrero", 23));
        personas.add(new Persona(2, "Juan", "Montes", 27));
        personas.add(new Persona(3, "Santiago", "Vlad", 25));
        personas.add(new Persona(4, "Mateo", "Vlad", 24));

        // filtrar elementos
        Flux.fromIterable(personas)
                .filter(p -> p.getEdad() > 24)
                .subscribe(p -> log.info(p.toString()));
    }

    // filtrar valores repetidos
    public void distinct(){

        // valores primitivos
        Flux.fromIterable(List.of(1,1,2,2))
                .distinct()
                .subscribe(p -> log.info(p.toString()));


        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Lina", "Guerrero", 23));
        personas.add(new Persona(4, "Juan", "Montes", 27));
        personas.add(new Persona(3, "Santiago", "Vlad", 25));
        personas.add(new Persona(4, "Mateo", "Vlad", 24));

        Flux.fromIterable(personas)
                .distinct()
                .subscribe(p -> log.info(p.toString()));
    }

    // toma el elemento donde le indiquemos (1-3)
    public void take(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Lina", "Guerrero", 23));
        personas.add(new Persona(4, "Juan", "Montes", 27));
        personas.add(new Persona(3, "Santiago", "Vlad", 25));
        personas.add(new Persona(4, "Mateo", "Vlad", 24));

        Flux.fromIterable(personas)
                .take(3) //takelast
                .subscribe(p -> log.info(p.toString()));
    }

    // ignora el elemento que le indiquemos
    public void skip(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Lina", "Guerrero", 23));
        personas.add(new Persona(4, "Juan", "Montes", 27));
        personas.add(new Persona(3, "Santiago", "Vlad", 25));
        personas.add(new Persona(4, "Mateo", "Vlad", 24));

        Flux.fromIterable(personas)
                .skip(3) //takelast
                .subscribe(p -> log.info(p.toString()));
    }
}
