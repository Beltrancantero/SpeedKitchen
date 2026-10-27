package org.speedkitchen.repositories;

import org.speedkitchen.entities.PasosReceta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasosRecetaRepository extends JpaRepository<PasosReceta, Long> {
}
