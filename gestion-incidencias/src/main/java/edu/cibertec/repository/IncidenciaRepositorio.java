package edu.cibertec.repository;

import edu.cibertec.models.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncidenciaRepositorio extends JpaRepository<Incidencia, Long> {

    @Query("SELECT i FROM Incidencia i WHERE i.descripcion LIKE %:palabraClave% OR i.nivelPrioridad LIKE %:palabraClave%")
    List<Incidencia> findAll(@Param("palabraClave") String palabraClave);
    
    // Método para encontrar incidencias por estado
    List<Incidencia> findByEstado(String estado);
}
