package co.com.proyectoReactor.exampleProjectReactor;

import co.com.proyectoReactor.exampleProjectReactor.combinacion.Combinacion;
import co.com.proyectoReactor.exampleProjectReactor.creacion.Creacion;
import co.com.proyectoReactor.exampleProjectReactor.filtrado.Filtrado;
import co.com.proyectoReactor.exampleProjectReactor.model.Persona;
import co.com.proyectoReactor.exampleProjectReactor.transformacion.Transformacion;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

public class ExampleProjectReactorApplication implements CommandLineRunner {

	public void reactor() {
		// Flujo de un elemento
		Mono.just(new Persona(1, "Lina", "Guerrero", 23))
				// método doOnNext --> para depuración
				.doOnNext(p -> log.info("[reactor] Persona: " + p))
				// subscripcion al flujo de datos (recolección dell dato final)
				.subscribe(p -> log.info("[reactor] Persona: " + p));

	}

	public void rxjava2() {
		Observable.just(new Persona(2, "Maria", "Lopez", 23))
				// método doOnNext --> para depuración
				.doOnNext(p -> log.info("[reactor] Persona: " + p))
				// subscripcion al flujo de datos
				.subscribe(p -> log.info("[RxJava2] Persona: " + p));
	}

	public void mono() {
		// un solo elemento
		Mono.just(new Persona(1, "Juan", "Montes", 27))
				.subscribe(p -> log.info(p.toString()));
	}

	public void flux() {

		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Lina", "Guerrero", 23));
		personas.add(new Persona(2, "Juan", "Montes", 27));
		personas.add(new Persona(3, "Santiago", "Vlad", 25));
		personas.add(new Persona(4, "Mateo", "Vlad", 24));

		// flujo de datos asincrono

		Flux.fromIterable(personas)
				.subscribe(p -> log.info(p.toString()));
	}

	public void fluxMono() {

		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Lina", "Guerrero", 23));
		personas.add(new Persona(2, "Juan", "Montes", 27));
		personas.add(new Persona(3, "Santiago", "Vlad", 25));
		personas.add(new Persona(4, "Mateo", "Vlad", 24));

		Flux<Persona> fx = Flux.fromIterable(personas);
		fx.collectList()
				.subscribe(lista -> log.info(lista.toString()));
	}


	// revisar a modo de debug
	private static final Logger log = LoggerFactory.getLogger(ExampleProjectReactorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExampleProjectReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Combinacion combinacion = new Combinacion();
		combinacion.zip();
	}
}