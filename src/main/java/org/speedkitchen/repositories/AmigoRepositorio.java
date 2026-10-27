package org.speedkitchen.repositories;

import org.speedkitchen.entities.Amigo;
import org.speedkitchen.entities.AmigoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmigoRepositorio extends JpaRepository<Amigo, AmigoId> {
}
