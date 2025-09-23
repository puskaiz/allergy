package hu.deposoft.allergy.service;

import hu.deposoft.allergy.api.UserAllergicIngredientsResponse;
import hu.deposoft.allergy.domain.AllergicIngredient;
import hu.deposoft.allergy.domain.Product;
import hu.deposoft.allergy.repository.AllergicIngredientRepository;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AllergicIngredientService {
  private final AllergicIngredientRepository repository;
  private final ProductService productService;

  public Set<String> findByUser(String user) {
    return repository.findAllergicIngredientByUser(user).stream()
        .map(AllergicIngredient::getIngredient)
        .collect(Collectors.toSet());
  }

  public void addAllergicIngredient(String user, String ingredient) {
    repository.save(new AllergicIngredient(user, ingredient));
  }

  public void removeAllergicIngredient(String user, String ingredient) {
    repository.delete(new AllergicIngredient(user, ingredient));
  }

  public UserAllergicIngredientsResponse getUserAllergicIngredientsInProduct(
      String user, String productId) {
    Set<String> userAllergicIngredients = findByUser(user);
    Product product = productService.getProduct(productId);
    if (product == null) {
      return null;
    }
    Set<String> productIngredients = product.getIngredients();
    userAllergicIngredients.retainAll(productIngredients);
    return new UserAllergicIngredientsResponse(product, userAllergicIngredients);
  }
}
