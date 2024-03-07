package ec.com.samagua.reto_advance_01_backend.repositorios;

import ec.com.samagua.reto_advance_01_backend.entidades.Vehiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VehiculoRepository {

    private final VehiculoJpaRepository repository;

    public Optional<Vehiculo> findById(Long id) {
        return repository.findById(id);
    }

    public Vehiculo save(Vehiculo entity) {
        return repository.save(entity);
    }

    public void delete(Vehiculo entity) {
        repository.delete(entity);
    }

    public List<Vehiculo> findByPlacaStartingWith(String placa) {
        return repository.findByPlacaStartingWith(placa);
    }

    public List<Vehiculo> findAll() {
        return repository.findAll();
    }
}
