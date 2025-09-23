package hu.deposoft.allergy.repository;

import hu.deposoft.allergy.domain.AllergicIngredient;
import hu.deposoft.allergy.domain.AllergicIngredientId;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergicIngredientRepository
    extends JpaRepository<AllergicIngredient, AllergicIngredientId> {
  Set<AllergicIngredient> findAllergicIngredientByUser(String user);
}
