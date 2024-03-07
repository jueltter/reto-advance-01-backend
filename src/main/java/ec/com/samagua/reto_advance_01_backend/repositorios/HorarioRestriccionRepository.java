package ec.com.samagua.reto_advance_01_backend.repositorios;

import ec.com.samagua.reto_advance_01_backend.entidades.HorarioRestriccion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HorarioRestriccionRepository {

    private final HorarioRestriccionJpaRepository repository;

    public List<HorarioRestriccion> findAll() {
        return repository.findAll();
    }
}
