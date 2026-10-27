package org.speedkitchen.repositories;

import org.speedkitchen.entities.RecetaIngrediente;
import org.speedkitchen.entities.RecetaIngredienteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaIngredienteRepository extends JpaRepository<RecetaIngrediente, RecetaIngredienteId> {
}
