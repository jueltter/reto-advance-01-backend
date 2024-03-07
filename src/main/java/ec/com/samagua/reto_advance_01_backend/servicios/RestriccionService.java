package ec.com.samagua.reto_advance_01_backend.servicios;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.samagua.reto_advance_01_backend.dtos.Restriccion;
import ec.com.samagua.reto_advance_01_backend.entidades.HorarioRestriccion;
import ec.com.samagua.reto_advance_01_backend.repositorios.HorarioRestriccionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class RestriccionService {

    @Autowired
    private HorarioRestriccionRepository repository;
    @Autowired
    private ObjectMapper objectMapper;

    public List<Restriccion> findByPlacaAndFecha(String placa, Date fecha) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault());

        DayOfWeek diaSemana = localDateTime.getDayOfWeek();
        LocalTime horaYMinutos = localDateTime.toLocalTime();
        String ultimoDigitoPlaca = placa.substring(placa.length() - 1);

        log.info("fechaLocal: {}, diaSemana: {}, horaYMinutos: {}, ultimoDigitoPlaca: {}", fecha, diaSemana, horaYMinutos, ultimoDigitoPlaca);

        List<HorarioRestriccion> horariosRestriccion = repository.findAll();
        log.info("horariosRestriccion: {}", horariosRestriccion);

        boolean puedeCircular = horariosRestriccion.stream().noneMatch(horarioRestriccion -> {
            List<String> terminaPlaca;
            try {
                terminaPlaca = Arrays.asList(objectMapper.readValue(horarioRestriccion.getTerminaPlaca(), String[].class));
            } catch (JsonProcessingException e) {
                throw new IllegalStateException(e);
            }
            return horarioRestriccion.getDiaSemanaAsDayOfWeek().equals(diaSemana)
                    && (horarioRestriccion.getInicio().isBefore(horaYMinutos) || horarioRestriccion.getInicio().equals(horaYMinutos))
                    && (horarioRestriccion.getFin().isAfter(horaYMinutos) || horarioRestriccion.getFin().equals(horaYMinutos))
                    && terminaPlaca.contains(ultimoDigitoPlaca);
        });

        Restriccion restriccion = Restriccion.builder()
                .placa(placa)
                .fecha(fecha)
                .puedeCircular(puedeCircular)
                .build();

        return Collections.singletonList(restriccion);
    }

}
