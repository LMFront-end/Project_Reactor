package co.com.proyectoReactor.exampleProjectReactor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venta {

    private Integer idVenta;
    private LocalDateTime fecha;
}
