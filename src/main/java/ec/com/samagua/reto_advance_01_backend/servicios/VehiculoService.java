package ec.com.samagua.reto_advance_01_backend.servicios;

import ec.com.samagua.reto_advance_01_backend.entidades.Vehiculo;
import ec.com.samagua.reto_advance_01_backend.repositorios.VehiculoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VehiculoService {

    @Autowired
    private VehiculoRepository repository;

    public Optional<Vehiculo> findById(Long id) {
        return repository.findById(id);
    }

    public Vehiculo save(Vehiculo entity) {
        return repository.save(entity);
    }

    public List<Vehiculo> findByPlacaStartingWith(String placa) {
        return repository.findByPlacaStartingWith(placa);
    }

    public List<Vehiculo> findAll() {
        return repository.findAll();
    }
}
