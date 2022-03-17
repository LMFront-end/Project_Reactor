package co.com.proyectoReactor.exampleProjectReactor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Persona {

    private Integer idPersona;
    private String nombre;
    private String apellido;
    private Integer edad;
}
