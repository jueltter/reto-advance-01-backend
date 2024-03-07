package ec.com.samagua.reto_advance_01_backend.repositorios;

import ec.com.samagua.reto_advance_01_backend.entidades.HorarioRestriccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HorarioRestriccionJpaRepository extends JpaRepository<HorarioRestriccion, Long>, JpaSpecificationExecutor<HorarioRestriccion> {
}
