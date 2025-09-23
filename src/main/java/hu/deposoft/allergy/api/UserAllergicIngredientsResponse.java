package hu.deposoft.allergy.api;

import hu.deposoft.allergy.domain.Product;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserAllergicIngredientsResponse {
  private Product product;
  private Set<String> allergicIngredients;
}
