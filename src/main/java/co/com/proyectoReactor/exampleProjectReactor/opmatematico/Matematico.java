package co.com.proyectoReactor.exampleProjectReactor.opmatematico;

import co.com.proyectoReactor.exampleProjectReactor.ExampleProjectReactorApplication;
import co.com.proyectoReactor.exampleProjectReactor.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Matematico {

    private static final Logger log = LoggerFactory.getLogger(ExampleProjectReactorApplication.class);

    public void average(){

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));
        personas1.add(new Persona(2, "Juan", "Montes", 25));

        Flux.fromIterable(personas1)
                .collect(Collectors.averagingInt(Persona::getEdad))
                .subscribe(x -> log.info(x.toString()));

    }

    public void count(){

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));
        personas1.add(new Persona(2, "Juan", "Montes", 25));

        Flux.fromIterable(personas1)
                .count()
                .subscribe(x -> log.info("cantidad: " + x));
    }

    // valor minimo
    public void min(){

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));
        personas1.add(new Persona(2, "Juan", "Montes", 25));

        Flux.fromIterable(personas1)
                .collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
                .subscribe(x -> log.info("Valor minimo: " + x.get().toString()));
    }

    public void max(){

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));
        personas1.add(new Persona(2, "Juan", "Montes", 25));

        Flux.fromIterable(personas1)
                .collect(Collectors.maxBy(Comparator.comparing(Persona::getEdad)))
                .subscribe(x -> log.info("Valor maximo: " + x.get().toString()));
    }

    public void sum(){

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));
        personas1.add(new Persona(2, "Juan", "Montes", 25));

        Flux.fromIterable(personas1)
                .collect(Collectors.summingInt(Persona::getEdad))
                .subscribe(x -> log.info("suma:  " + x));

    }

    public void summarizing(){

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));
        personas1.add(new Persona(2, "Juan", "Montes", 25));

        Flux.fromIterable(personas1)
                .collect(Collectors.summarizingInt(Persona::getEdad))
                .subscribe(x -> log.info("Resumen: " + x));
    }


}
