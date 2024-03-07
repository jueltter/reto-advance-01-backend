package ec.com.samagua.reto_advance_01_backend.dtos;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ec.com.samagua.reto_advance_01_backend.configuracion.JsonDateSerializer;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Restriccion {
    private String placa;
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date fecha;
    private boolean puedeCircular;
}
