package org.speedkitchen.entities;

import org.speedkitchen.entities.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepositorio extends JpaRepository<Rol, Integer> {
}





