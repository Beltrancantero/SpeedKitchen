package org.speedkitchen;

import org.speedkitchen.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner probarConexion(UsuarioRepository usuarioRepository) {
        return args -> {
            System.out.println("=========================================================");
            System.out.println("El contexto de Spring Boot ha cargado correctamente.");
            System.out.println("Mapeo de entidades JPA verificado contra PostgreSQL.");
            System.out.println("Total de usuarios en la tabla 'usuarios': " + usuarioRepository.count());
            System.out.println("=========================================================");
        };
    }
}