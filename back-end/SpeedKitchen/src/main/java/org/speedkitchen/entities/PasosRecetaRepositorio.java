package org.speedkitchen.entities;

import org.speedkitchen.entities.PasosReceta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasosRecetaRepositorio extends JpaRepository<Rol, Integer> {
}
