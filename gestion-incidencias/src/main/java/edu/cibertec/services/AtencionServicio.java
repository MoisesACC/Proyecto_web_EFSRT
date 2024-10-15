package edu.cibertec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.cibertec.models.Atencion;
import edu.cibertec.repository.AtencionRepositorio;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException; // Asegúrate de tener esta línea

@Service
public class AtencionServicio {

    @Autowired
    private AtencionRepositorio atencionRepositorio;

    /**
     * Lista todas las atenciones.
     * @return Lista de todas las atenciones.
     */
    public List<Atencion> listAtenciones() {
        return atencionRepositorio.findAll();
    }

    /**
     * Busca una atención por su ID.
     * @param id el ID de la atención.
     * @return un Optional que contiene la atención si se encuentra, de lo contrario vacío.
     */
    public Optional<Atencion> findAtencionById(Long id) {
        return atencionRepositorio.findById(id);
    }

    /**
     * Guarda una nueva atención.
     * @param atencion la atención a guardar.
     * @return la atención guardada.
     */
    public Atencion saveAtencion(Atencion atencion) {
        // Validar el objeto Atencion si es necesario
        return atencionRepositorio.save(atencion);
    }

    /**
     * Obtiene una atención por su ID.
     * @param id el ID de la atención.
     * @return la atención correspondiente al ID.
     * @throws NoSuchElementException si no se encuentra la atención.
     */
    public Atencion get(Long id) {
        return atencionRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Atención no encontrada con id: " + id));
    }

    /**
     * Elimina una atención por su ID.
     * @param id el ID de la atención a eliminar.
     */
    public void deleteAtencionById(Long id) {
        atencionRepositorio.deleteById(id);
    }
}
