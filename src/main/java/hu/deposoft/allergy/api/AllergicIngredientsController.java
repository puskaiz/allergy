package hu.deposoft.allergy.api;

import hu.deposoft.allergy.service.AllergicIngredientService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AllergicIngredientsController {
  private final AllergicIngredientService allergicIngredientService;

  @GetMapping("/allergic-ingredients")
  public Set<String> getAllergicIngredients(@AuthenticationPrincipal OAuth2User principal) {
    return allergicIngredientService.findByUser(getEmail(principal));
  }

  @PutMapping("/allergic-ingredients/{ingredient}")
  public void addAllergicIngredient(
      @AuthenticationPrincipal OAuth2User principal, @PathVariable String ingredient) {
    allergicIngredientService.addAllergicIngredient(getEmail(principal), ingredient);
  }

  @DeleteMapping("/allergic-ingredients/{ingredient}")
  public void removeAllergicIngredient(
      @AuthenticationPrincipal OAuth2User principal, @PathVariable String ingredient) {
    allergicIngredientService.removeAllergicIngredient(getEmail(principal), ingredient);
  }

  @GetMapping("/allergic-ingredients/product/{productId}")
  public UserAllergicIngredientsResponse getUserAllergicIngredientsInProduct(
      @AuthenticationPrincipal OAuth2User principal, @PathVariable String productId) {
    return allergicIngredientService.getUserAllergicIngredientsInProduct(
        getEmail(principal), productId);
  }

  private String getEmail(OAuth2User principal) {
    return principal.getAttribute("email");
  }
}
