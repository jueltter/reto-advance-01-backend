package ec.com.samagua.reto_advance_01_backend.controladores;

import ec.com.samagua.reto_advance_01_backend.entidades.Vehiculo;
import ec.com.samagua.reto_advance_01_backend.servicios.VehiculoService;
import jakarta.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class VehiculosController {

    private final VehiculoService service;

    @CrossOrigin(origins = "*")
    @GetMapping("/vehiculos")
    public ResponseEntity<List<Vehiculo>> search(@QueryParam("place") String placa) {
        if (placa == null || placa.isBlank()) {
            List<Vehiculo> retorno = service.findAll();
            return ResponseEntity.ok(retorno);
        }

        List<Vehiculo> retorno = service.findByPlacaStartingWith(placa);

        return ResponseEntity.ok(retorno);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/vehiculos")
    public ResponseEntity<Vehiculo> create(@RequestBody Vehiculo vehiculo) {
        vehiculo = service.save(vehiculo);
        return ResponseEntity.ok(vehiculo);
    }
}
