package ec.com.samagua.reto_advance_01_backend.repositorios;

import ec.com.samagua.reto_advance_01_backend.entidades.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface VehiculoJpaRepository extends JpaRepository<Vehiculo, Long>, JpaSpecificationExecutor<Vehiculo> {

    List<Vehiculo> findByPlacaStartingWith(String placa);
}
