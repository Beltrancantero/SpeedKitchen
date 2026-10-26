package org.speedkitchen.entities;

import org.speedkitchen.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepositorio extends JpaRepository<Rol, Integer> {
}
