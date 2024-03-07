package ec.com.samagua.reto_advance_01_backend.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "horario_restriccion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class HorarioRestriccion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "dia_semana")
    private Integer diaSemana;

    @Column(name = "termina_placa")
    private String terminaPlaca;

    @Column(name = "inicio")
    @Temporal(TemporalType.TIME)
    private LocalTime inicio;

    @Column(name = "fin")
    @Temporal(TemporalType.TIME)
    private LocalTime fin;

    public DayOfWeek getDiaSemanaAsDayOfWeek() {
        return DayOfWeek.of(diaSemana);
    }
}
