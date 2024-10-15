package edu.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // Anotación principal para la aplicación Spring Boot
@EnableJpaRepositories(basePackages = "edu.cibertec.repository") // Activa JPA para los repositorios en el paquete especificado
public class GestionIncidenciasApplication {

    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot
        SpringApplication.run(GestionIncidenciasApplication.class, args);
    }
}
