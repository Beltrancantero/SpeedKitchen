package org.speedkitchen.repositories;

import org.speedkitchen.entities.EjecucionPaso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjecucionPasoRepository extends JpaRepository<EjecucionPaso, Long> {
}
