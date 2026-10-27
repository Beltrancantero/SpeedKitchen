package org.speedkitchen.repositories;

import org.speedkitchen.entities.JugadorPartida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorPartidaRepository extends JpaRepository<JugadorPartida, Long> {
}
