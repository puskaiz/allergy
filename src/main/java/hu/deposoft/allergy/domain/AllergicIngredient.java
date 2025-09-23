package hu.deposoft.allergy.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(AllergicIngredientId.class)
public class AllergicIngredient {
  @Column(name = "username")
  @Id
  private String user;

  @Id private String ingredient;
}
