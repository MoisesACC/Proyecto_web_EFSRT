package edu.cibertec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.models.Empleado;
import edu.cibertec.repository.EmpleadoRepositorio;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

@Service
public class EmpleadoServicio {
    
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    /**
     * Busca empleados por nombre o apellido.
     * @param palabraClave el término de búsqueda.
     * @return Lista de empleados que coinciden con el término de búsqueda.
     */
    public List<Empleado> findAll(String palabraClave) {
        if (palabraClave != null && !palabraClave.isEmpty()) {
            return empleadoRepositorio.findAll(palabraClave);
        }
        return listaEmp();
    }
    
    /**
     * Lista todos los empleados.
     * @return Lista de todos los empleados.
     */
    public List<Empleado> listaEmp() {
        return empleadoRepositorio.findAll();
    }
    
    /**
     * Busca un empleado por su ID.
     * @param id el ID del empleado.
     * @return un Optional que contiene el empleado si se encuentra, de lo contrario vacío.
     */
    public Optional<Empleado> findById(Long id) {
        return empleadoRepositorio.findById(id);
    }
    
    /**
     * Guarda un empleado.
     * @param empleado el empleado a guardar.
     */
    public void save(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }

    /**
     * Obtiene un empleado por su ID.
     * @param id el ID del empleado.
     * @return el empleado correspondiente al ID.
     * @throws NoSuchElementException si no se encuentra el empleado.
     */
    public Empleado get(Long id) {
        return empleadoRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Empleado no encontrado con id: " + id));
    }
    
    /**
     * Obtiene un empleado por su código.
     * @param id el ID del empleado.
     * @return el empleado correspondiente al código o null si no se encuentra.
     */
    public Empleado obtenerEmpleadoPorCodEmpleado(Long id) {
        return empleadoRepositorio.findById(id).orElse(null);
    }

    /**
     * Elimina un empleado por su ID.
     * @param id el ID del empleado a eliminar.
     */
    public void delete(Long id) {
        empleadoRepositorio.deleteById(id);
    }
    
    /**
     * Obtiene todos los empleados técnicos.
     * @return Lista de empleados técnicos.
     */
    public List<Empleado> obtenerEmpleadosTecnicos() {
        return empleadoRepositorio.findByTipoEmp("Tecnico");
    }
}
