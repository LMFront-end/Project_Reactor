package co.com.proyectoReactor.exampleProjectReactor.combinacion;

import co.com.proyectoReactor.exampleProjectReactor.ExampleProjectReactorApplication;
import co.com.proyectoReactor.exampleProjectReactor.model.Persona;
import co.com.proyectoReactor.exampleProjectReactor.model.Venta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combinacion {

    private static final Logger log = LoggerFactory.getLogger(ExampleProjectReactorApplication.class);

    public void merge(){

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));
        personas1.add(new Persona(3, "Santiago", "Vlad", 25));
        personas1.add(new Persona(4, "Mateo", "Vlad", 24));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(1, "Pedro", "Guerrero", 23));
        personas2.add(new Persona(2, "Camila", "Montes", 27));
        personas2.add(new Persona(3, "Federico", "Vlad", 25));
        personas2.add(new Persona(4, "Jorge", "Vlad", 24));

        // flujo ventas
        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));


        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.merge(fx1, fx2, fx3)
                .subscribe(p -> log.info(p.toString()));

    }

    public void zip(){
        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));
        personas1.add(new Persona(3, "Santiago", "Vlad", 25));
        personas1.add(new Persona(4, "Mateo", "Vlad", 24));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(1, "Pedro", "Guerrero", 23));
        personas2.add(new Persona(2, "Camila", "Montes", 27));
        personas2.add(new Persona(3, "Federico", "Vlad", 25));
        personas2.add(new Persona(4, "Jorge", "Vlad", 24));

        // flujo ventas
        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.zip(fx1, fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(x -> log.info(x));

    }

    public void zipWith(){

        List<Persona> personas1 = new ArrayList<>();
        personas1.add(new Persona(1, "Lina", "Guerrero", 23));
        personas1.add(new Persona(2, "Juan", "Montes", 27));

        List<Persona> personas2 = new ArrayList<>();
        personas2.add(new Persona(1, "Pedro", "Guerrero", 23));
        personas2.add(new Persona(2, "Camila", "Montes", 27));

        // flujo ventas
        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas1);
        Flux<Persona> fx2 = Flux.fromIterable(personas2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        fx1.zipWith(fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(x -> log.info(x));
    }
}
