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
                .filter(p -> p.getEdad() > 28)
                .subscribe(p -> log.info(p.toString()));


    }
}
