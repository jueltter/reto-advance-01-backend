package ec.com.samagua.reto_advance_01_backend.controladores;

import ec.com.samagua.reto_advance_01_backend.dtos.Restriccion;
import ec.com.samagua.reto_advance_01_backend.servicios.RestriccionService;
import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RestriccionesController {
    private final RestriccionService service;

    @CrossOrigin(origins = "*")
    @GetMapping("/restricciones")
    public ResponseEntity<List<Restriccion>> search(@QueryParam("placa") @NonNull String placa, @QueryParam("fecha") @NonNull String fecha) throws ParseException {
        log.info("placa: {}, fecha: {}", placa, fecha);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date fechaAsDate = formatter.parse(fecha);
        if ((new Date()).after(fechaAsDate)) {
            return ResponseEntity.badRequest().build();
        }
        List<Restriccion> retorno = service.findByPlacaAndFecha(placa, fechaAsDate);

        return ResponseEntity.ok(retorno);
    }
}
