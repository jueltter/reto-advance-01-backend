package ec.com.samagua.reto_advance_01_backend.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Vehiculo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "placa")
    private String placa;

    @Column(name = "color")
    private String color;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "chasis")
    private String chasis;

    @Column(name = "kilometraje")
    private Double kilometraje;

    @Column(name = "anio_modelo")
    private Integer anioModelo;

    @Column(name = "marca")
    private String marca;

}
