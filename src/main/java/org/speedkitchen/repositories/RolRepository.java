package org.speedkitchen.repositories;

import org.speedkitchen.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    // Spring Data JPA implementa los métodos CRUD automáticamente
}